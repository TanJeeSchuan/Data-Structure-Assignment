package control;

import adt.ArrayList;
import adt.ArrayMap;
import adt.LinkedSet;
import adt.interfaces.List;
import boundary.DonationManagementUI;
import dao.DB;
import entity.CharityCause;
import entity.Donation;
import entity.DonationManagement;
import entity.Donor;
import java.util.Scanner;

/**
 *
 * @author Liau Xiao Xuan
 */
public class DonationManagementControl {

    private Scanner sc;
    private DonationManagementUI donationManagementUI;
    private DonationManagement dm;
    private DB db;

    public DonationManagementControl() {
        sc = new Scanner(System.in);
        db = DB.getInstance();
        dm = new DonationManagement(db.donationDAO.getDonations());
        donationManagementUI = new DonationManagementUI();
    }

    public void startUI() {
        boolean isEnd = false;

        while (!isEnd) {
            isEnd = false;

            int option = donationManagementUI.showMenu();

            switch (option) {
                case 0:
                    isEnd = true;
                    break;
                case 1:
                    addDonation();
                    break;
                case 2:
                    updateDonation();
                    break;
                case 3:
                    removeDonation();
                    break;
                case 4:
                    displayAllDonation();
                    break;
                case 5:
                    searcDonation();
                    break;
                case 6:
                    donationReport();
                    break;
            }
        }
    }

    public void addDonation() {
        boolean isExist = false;
        LinkedSet<Donor> donorSet = db.donorDAO.getDonors();

        donationManagementUI.promptTitle("Add Donation");

        ArrayList<CharityCause> causes
                = DB.getInstance().charityCauseDAO.getCharityCauses();
        CharityCause cause = donationManagementUI.getCauseOption(causes);
        double amount = donationManagementUI.getDonationAmount();
        Donor donor = new Donor(donationManagementUI.getDonorName(),
                donationManagementUI.getDonorEmail());

        for (int i = 0; i < donorSet.size(); i++) {
            if (donorSet.getValue(i).equals(donor)) {
                isExist = true;
            }
        }
        if (!isExist) {
            DB.getInstance().donorDAO.addDonor(donor);
        }

        dm.addDonation(donor, cause, amount);
        db.donationDAO.syncDonations(dm.donations);

        donationManagementUI.promptSuccessMessage("added");
    }

    public void updateDonation() {
        donationManagementUI.promptTitle("Update Donation");

        donationManagementUI.displayAllDonations(displayDonation());
        int selection = donationManagementUI.getSelection();
        int index = 0;
        Donation donation = null;
        boolean found = false;

        for (int i = 0; i < dm.donations.size(); i++) {
            Donor donor = dm.donations.getKey(i);
            List<Donation> donationInfo = dm.donations.get(donor);
            for (int j = 0; j < dm.donations.get(donor).size() 
                    && !found; j++) {
                if (++index == selection) {
                    donation = donationInfo.get(j);
                    found = true;
                }
            }
        }

        Donor donor = donation.getDonor();

        int option = donationManagementUI.getModifyOption();

        switch (option) {
            case 1:
                Donor newDonor
                        = new Donor(donationManagementUI.getDonorName(),
                                donationManagementUI.getDonorEmail());
                dm.setDonationDonor(donor, newDonor, donation);
                donation.setDonor(newDonor);

                break;
            case 2:
                ArrayList<CharityCause> causes
                        = DB.getInstance().charityCauseDAO.getCharityCauses();
                CharityCause cause
                        = donationManagementUI.getCauseOption(causes);
                donation.setCause(cause);

                break;
            case 3:
                double amount = donationManagementUI.getDonationAmount();
                donation.setAmount(amount);

                break;
        }

        db.donationDAO.syncDonations(dm.donations);
        donationManagementUI.promptSuccessMessage("updated");
    }

    public void removeDonation() {
        donationManagementUI.promptTitle("Delete Donation");

        donationManagementUI.displayAllDonations(displayDonation());
        int selection = donationManagementUI.getSelection();
        int index = 0;
        Donation donation = null;
        boolean found = false;

        for (int i = 0; i < dm.donations.size(); i++) {
            Donor donor = dm.donations.getKey(i);
            List<Donation> donationInfo = dm.donations.get(donor);
            for (int j = 0; j < dm.donations.get(donor).size() 
                    && !found; j++) {
                if (++index == selection) {
                    donation = donationInfo.get(j);
                    found = true;
                }
            }
        }

        Donor donor = donation.getDonor();

        if (donationManagementUI.getDeleteConfirmation(donation)) {
            dm.getDonorDonation(donor).remove(donation);
            donationManagementUI.promptSuccessMessage("deleted");
        }

        db.donationDAO.syncDonations(dm.donations);
    }

    public void displayAllDonation() {
        donationManagementUI.promptTitle("Display Donation");
        donationManagementUI.displayAllDonations(displayDonation());
    }

    public List<String> displayDonation() {
        List<String> donationsInfo = new ArrayList<>();
        int number = 0;
        donationsInfo.add(
                "%-3s | %-30s | %-30s | %-15s"
                        .formatted("No.", "Donor name",
                                "Cause", "Donation Amount"));

        for (int i = 0; i < dm.donations.size(); i++) {
            Donor donor = dm.donations.getKey(i);
            List<Donation> donationInfo = dm.donations.get(donor);
            for (int j = 0; j < dm.donations.get(donor).size(); j++) {
                Donation donation = donationInfo.get(j);
                donationsInfo.add(
                        "%-3d | %-30s | %-30s | %-15.2f"
                                .formatted(++number, donor.getName(),
                                        donation.getCause(),
                                        donation.getAmount()));
            }

        }

        return donationsInfo;
    }

    public void searcDonation() {
        donationManagementUI.promptTitle("Search Donation");

        Donor donor = new Donor(donationManagementUI.getDonorName(),
                donationManagementUI.getDonorEmail());

        if (!dm.donations.has(donor)) {
            donationManagementUI.noSuchInformation();
        } else {
            donationManagementUI.promptInformation(
                    getDonationString(donor));
        }
    }

    public void donationReport() {
        donationManagementUI.promptTitle("Donation Report");
        int option = donationManagementUI.getReportOption();
        switch (option) {
            case 1:
                donorReport();
                break;
            case 2:
                donationsReport();
                break;
            case 3:
                getMostRecentDonor();
                break;
        }
    }

    public void donorReport() {
        donationManagementUI.promptTitle("Donor in Donation Report");
        List<String> donorInfo = new ArrayList<>();
        int number = 0;
        donorInfo.add("%-3s | %-8s | %-30s | %-30s | %-5s"
                .formatted("No.", "Donor ID","Donor name", 
                        "Donor Email", "Total Donation"));

        for (int i = 0; i < dm.donations.size(); i++) {
            Donor donor = dm.donations.getKey(i);
            donorInfo.add("%-3d | %-8d | %-30s | %-30s | %-5d"
                    .formatted(i + 1, donor.getDonorId(), 
                            donor.getName(),donor.getEmail(), 
                                dm.donations.get(donor).size()));
            number++;
        }

        donationManagementUI.displayDonorReport(number, donorInfo);
    }

    public void donationsReport() {
        donationManagementUI.promptTitle("Donation Report");

        donationManagementUI.displayDonationReport(
                displayDonation());
    }

    public void getMostRecentDonor() {
        donationManagementUI.promptTitle("Most Recent Donor");

        int highest = 0;
        Donor donor = null;

        for (int i = 0; i < dm.donations.size(); i++) {
            if (dm.donations.get(
                    dm.donations.getKey(i)).size() > highest) {
                donor = dm.donations.getKey(i);
                highest = dm.donations.get(donor).size();
            }
        }

        donationManagementUI.promtMostRecentDonor(
                donor, highest, getDonationArrayString(donor));
    }

    public String getDonationString(Donor donor) {
        String arrString = "";
        arrString += "Donor\n";
        arrString += "------\n";
        arrString += donor;

        arrString += "\nDonation Detail\n";
        arrString += "--------------------";
        arrString += getDonationArrayString(donor);
        return arrString;
    }

    public String getDonationArrayString(Donor donor) {
        String arrString = "";

        ArrayList<Donation> donationArray = db.donationDAO.donations.
                get(donor);

        for (int j = 0; j < donationArray.size(); j++) {
            arrString += "\n";
            arrString += donationArray.get(j);
            arrString += "\n";
        }
        return arrString;
    }

}
