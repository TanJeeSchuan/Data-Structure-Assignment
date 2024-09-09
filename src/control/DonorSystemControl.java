/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.ArrayList;
import adt.ArrayMap;
import adt.LinkedQueue;
import adt.LinkedSet;
import adt.interfaces.List;
import adt.interfaces.Queue;
import boundary.DonorSystemUI;
import dao.DB;
import entity.Donation;
import entity.Donor;

/**
 *
 * @author Tan Jee Schuan
 */
public class DonorSystemControl {

    private DonorSystemUI donorSystemUI;
    private Queue<Donor> donorStack = new LinkedQueue<>();
    private DB db = DB.getInstance();

    public DonorSystemControl() {
        donorSystemUI = new DonorSystemUI();
    }

    public void startUI() {
        boolean isEnd = false;

        while (!isEnd) {
            isEnd = false;

            donorSystemUI.showUI();
            int choice = donorSystemUI.getMenuSelection();

            switch (choice) {
                case 0:
                    isEnd = true;
                    break;
                case 1:
                    addDonor();
                    break;
                case 2:
                    modifyDonor();
                    break;
                case 3:
                    displayAllDonors();
                    break;
                case 4:
                    deleteDonor();
                    break;
                case 5:
                    donorReport();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    public void addDonor() {
        String donorName = donorSystemUI.getNewDonorName();
        String donorEmail = donorSystemUI.getNewDonorEmail();

        Donor newDonor = new Donor(donorName, donorEmail);
        DB.getInstance().donorDAO.addDonor(newDonor);
        donorSystemUI.showNewDonor(newDonor);
    }

    public void modifyDonor() {
        LinkedSet<Donor> donorSet = db.donorDAO.getDonors();
        donorSystemUI.showDonorList(donorSet);

        int selectedIndex = donorSystemUI.getDonorSelection();
        Donor selectedDonor = donorSet.getValue(selectedIndex);
        donorSystemUI.showDonorModificationUI(selectedDonor);

        int selection = donorSystemUI.getDonorModificationSelection();
        switch (selection) {
            case 0:
                break;
            case 1:
                modifyDonorName(selectedDonor);
                break;
            case 2:
                modifyDonorEmail(selectedDonor);
                break;
            default:
                throw new AssertionError();
        }

        donorSystemUI.showNewDonor(selectedDonor);
    }

    private void displayAllDonors() {
        LinkedSet<Donor> donorSet = db.donorDAO.getDonors();
        ArrayMap<Donor, ArrayList<Donation>> donations = DB.getInstance().donationDAO.getDonations();
        int number = 0;
        ArrayList<String> donorsInfo = new ArrayList<>();
        donorsInfo.add("%-3s | %-30s | %-30s | %-15s".formatted("No.", "Donor Name", "Donor Email", "No. of donation"));
        for (int i = 0; i < donorSet.size(); i++) {
            try {
                number = donations.get(donorSet.getValue(i)).size();
            } catch (Exception ex) {
                number = 0;
            } finally {
                donorsInfo.add("%-3d | %-30s | %-30s | %-15d".formatted(i + 1, donorSet.getValue(i).getName(), donorSet.getValue(i).getEmail(), number));
            }
        }

        donorSystemUI.showDonors(donorsInfo);
    }

    private void deleteDonor() {
        LinkedSet<Donor> donorSet = db.donorDAO.getDonors();
        donorSystemUI.showDonorList(donorSet);

        int selectedIndex = donorSystemUI.getDonorSelection();
        Donor selectedDonor = donorSet.getValue(selectedIndex);

        db.donorDAO.removeDonor(selectedDonor);
        donorSystemUI.showRemovedDonor(selectedDonor);
    }

    private void modifyDonorName(Donor selectedDonor) {
        String newName = donorSystemUI.getNewDonorName();
        selectedDonor.setName(newName);
    }

    private void modifyDonorEmail(Donor selectedDonor) {
        String newEmail = donorSystemUI.getNewDonorName();
        selectedDonor.setEmail(newEmail);
    }

    private void donorReport() {
        List<String> recentDonor = new ArrayList<>();
        Queue<Donor> tempStack = new LinkedQueue<>();
        LinkedSet<Donor> donorSet = db.donorDAO.getDonors();
        int total = donorSet.size();

        if (donorStack.isEmpty()) {
            recentDonor.add("No new donors have been added recently.");

        } else {
            recentDonor.add("%-8s | %-30s | %-11s | %-50s".formatted("Donor ID", "Donor Name", "Contact Number", "Address"));

            // get data
            for (int i = 0; i < 10 && !donorStack.isEmpty(); i++) {
                Donor donor = donorStack.dequeue();
                tempStack.enqueue(donor);
                recentDonor.add("%-8d | %-30s | %-30s".formatted(donor.getDonorId(), donor.getName(), donor.getEmail()));
            }
            // store back
            while (!tempStack.isEmpty()) {
                donorStack.enqueue(tempStack.dequeue());
            }
        }

        donorSystemUI.report(total, recentDonor);
    }
}
