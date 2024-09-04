/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.ArrayList;
import adt.ArraySet;
import adt.LinkedSet;
import adt.LinkedStack;
import adt.interfaces.List;
import adt.interfaces.StackInterface;
import boundary.DonorSystemUI;
import dao.DB;
import entity.Donor;

/**
 *
 * @author Tan Jee Schuan
 */
public class DonorSystemControl {

    private DonorSystemUI donorSystemUI;
    private StackInterface<Donor> donorStack = new LinkedStack<>();
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
            default:
                throw new AssertionError();
        }

        donorSystemUI.showNewDonor(selectedDonor);
    }

    private void displayAllDonors() {
        LinkedSet<Donor> donorSet = db.donorDAO.getDonors();
        donorSystemUI.showDonors(donorSet);
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
        StackInterface<Donor> tempStack = new LinkedStack<>();
        LinkedSet<Donor> donorSet = db.donorDAO.getDonors();
        int total = donorSet.size();

        recentDonor.add("%-8s | %-30s | %-11s | %-50s".formatted("Donor ID", "Donor Name", "Contact Number", "Address"));

        // get data
        for (int i = 0; i < 10 || donorStack.isEmpty(); i++) {
            Donor donor = donorStack.pop();
            tempStack.push(donor);
            recentDonor.add("%-8s | %-30s | %-30s".formatted(donor.getDonorId(), donor.getName(), donor.getEmail()));

        }
        // store back
        while (!tempStack.isEmpty()) {
            donorStack.push(tempStack.pop());
        }

        donorSystemUI.report(total, recentDonor);
    }
}
