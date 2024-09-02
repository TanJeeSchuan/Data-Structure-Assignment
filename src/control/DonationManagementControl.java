/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * @author xuanx
 */
public class DonationManagementControl {

    private Scanner sc;
    private DonationManagementUI donationManagementUI;
    private DonationManagement dm;
    LinkedSet<Donor> donors = DB.getInstance().donorDAO.getDonors();

    public DonationManagementControl() {
        sc = new Scanner(System.in);

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
                    displayDonation();
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
        donationManagementUI.promptTitle("Add Donation");

        ArrayList<CharityCause> causes = DB.getInstance().charityCauseDAO.getCharityCauses();
        CharityCause cause = donationManagementUI.getCauseOption(causes);
        double amount = donationManagementUI.getDonationAmount();
        Donor donor = new Donor(donationManagementUI.getDonorName(), donationManagementUI.getDonorEmail());
        dm.addDonation(donor, cause, amount);

        donationManagementUI.promptSuccessMessage("added");
    }

    public void updateDonation() {
        donationManagementUI.promptTitle("Update Donation");

        Donor donor = new Donor(donationManagementUI.getDonorName(), donationManagementUI.getDonorEmail());
        Donation donation;

        if (!dm.donations.has(donor)) {
            donationManagementUI.noSuchInformation();
        } else {
            donation = donationManagementUI.getModifyDonation(dm.getDonorDonation(donor));

            int option = donationManagementUI.getModifyOption();

            switch (option) {
                case 1:
                    Donor newDonor = new Donor(donationManagementUI.getDonorName(), donationManagementUI.getDonorEmail());
                    dm.setDonationDonor(donor, newDonor, donation);
                    donation.setDonor(newDonor);

                    break;
                case 2:
                    ArrayList<CharityCause> causes = DB.getInstance().charityCauseDAO.getCharityCauses();
                    CharityCause cause = donationManagementUI.getCauseOption(causes);
                    donation.setCause(cause);

                    break;
                case 3:
                    double amount = donationManagementUI.getDonationAmount();
                    donation.setAmount(amount);

                    break;
            }

            donationManagementUI.promptSuccessMessage("updated");
        }
    }

    public void removeDonation() {
        donationManagementUI.promptTitle("Delete Donation");

        Donor donor = new Donor(donationManagementUI.getDonorName(), donationManagementUI.getDonorEmail());
        Donation donation;

        if (!dm.donations.has(donor)) {
            donationManagementUI.noSuchInformation();
        } else {
            donation = donationManagementUI.getModifyDonation(dm.getDonorDonation(donor));
            if (donationManagementUI.getDeleteConfirmation(donation)) {
                dm.getDonorDonation(donor).remove(donation);
                donationManagementUI.promptSuccessMessage("deleted");
            }
        }
    }

    public void displayDonation() {
        ArrayMap<Donor, ArrayList<Donation>> donations = dm.getAllDonations();

        String allDonationsString = "";
        for (int i = 0; i < donations.size(); i++) {
            Donor donor = donations.getKey(i);
            allDonationsString += getDonationString(donor);
        }

        donationManagementUI.promptTitle("Display Donation");
        donationManagementUI.displayAllDonations(allDonationsString);

    }

    public void searcDonation() {
        donationManagementUI.promptTitle("Search Donation");

        Donor donor = new Donor(donationManagementUI.getDonorName(), donationManagementUI.getDonorEmail());

        if (!dm.donations.has(donor)) {
            donationManagementUI.noSuchInformation();
        } else {
            donationManagementUI.promptInformation(getDonationString(donor));
        }
    }

    public void donationReport() {
        donationManagementUI.promptTitle("Donation Report");
        int option = donationManagementUI.getReportOption();
        switch (option) {
            case 1:
                donorReport();
                System.out.println("1. Donor in Donation Report");
                System.out.println("2. Donation Report");
                break;
            case 2:
                donationReport();
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
        donorInfo.add("%-3s | %-8s | %-30s | %-30s | %-5s".formatted("No.", "Donor ID", "Donor name", "Donor Email", "Total Donation"));

        for (int i = 0; i < dm.donations.size(); i++) {
            Donor donor = dm.donations.getKey(i);
            donorInfo.add("%-3d | %-8d | %-30s | %-30s | %-5d".formatted(i + 1, donor.getDonorId(), donor.getName(), donor.getEmail(), dm.donations.get(donor).size()));
            number++;
        }

        donationManagementUI.displayDonorReport(number, donorInfo);
    }

    public void donationsReport() {
        donationManagementUI.promptTitle("Donation Report");

        List<String> donationInfoReport = new ArrayList<>();
        int number = 0;
        donationInfoReport.add("%-3s | %-11s | %-30s | %-20s | %-15s".formatted("No.", "Donation ID", "Donor name", "Cause", "Donation Amount"));

        for (int i = 0; i < dm.donations.size(); i++) {
            Donor donor = dm.donations.getKey(i);
            List<Donation> donationInfo = dm.donations.get(donor);
            for (int j = 0; j < dm.donations.get(donor).size(); j++) {
                Donation donation = donationInfo.get(i);
                donationInfoReport.add("%-3d | %-11d | %-30s | %-20s | %-15d".formatted(i + 1, donation.getDonationId(), donor.getName(), donation.getCause(), donation.getAmount()));
                number++;
            }
        }

        donationManagementUI.displayDonationReport(number, donationInfoReport);
    }

    public void getMostRecentDonor() {
        donationManagementUI.promptTitle("Most Recent Donor");

        int highest = 0;
        Donor donor = null;

        for (int i = 0; i < dm.donations.size(); i++) {
            if (dm.donations.get(dm.donations.getKey(i)).size() > highest) {
                donor = dm.donations.getKey(i);
                highest = dm.donations.get(donor).size();
            }
        }

        donationManagementUI.promtMostRecentDonor(donor, highest, getDonationArrayString(donor));
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

        ArrayList<Donation> donationArray = dm.donations.get(donor);

        for (int j = 0; j < donationArray.size(); j++) {
            arrString += donationArray.get(j);
            arrString += "\n";
        }
        return arrString;
    }

}
