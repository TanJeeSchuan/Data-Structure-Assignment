/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.LinkedSet;
import boundary.DoneeSystemUI;
import dao.DB;
import entity.Donee;

/**
 *
 * @author xuanx
 */
public class DoneeSystemControl {

    private DoneeSystemUI doneeSystemUI;
    private DB db = DB.getInstance();

    public DoneeSystemControl() {
        doneeSystemUI = new DoneeSystemUI();
    }

    public void startUI() {
        boolean isEnd = false;

        while (!isEnd) {
            isEnd = false;

            doneeSystemUI.showUI();
            int choice = doneeSystemUI.getMenuSelection();

            switch (choice) {
                case 0:
                    isEnd = true;
                    break;
                case 1:
                    addDonee();
                    break;
                case 2:
                    modifyDonee();
                    break;
                case 3:
                    displayAllDonees();
                    break;
                case 4:
                    deleteDonee();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    public void addDonee() {
        String doneeName = doneeSystemUI.getNewDoneeName();
        String doneeContact = doneeSystemUI.getNewDoneeContact();
        String doneeAddress = doneeSystemUI.getNewDoneeAddress();

        Donee newDonee = new Donee(doneeName, doneeContact, doneeAddress);
        DB.getInstance().doneeDAO.addDonee(newDonee);
        doneeSystemUI.showNewDonee(newDonee);
    }

    public void modifyDonee() {
        LinkedSet<Donee> doneeSet = db.doneeDAO.getDonees();
        doneeSystemUI.showDoneeList(doneeSet);

        int selectedIndex = doneeSystemUI.getDoneeSelection();
        Donee selectedDonee = doneeSet.getValue(selectedIndex);
        doneeSystemUI.showDoneeModificationUI(selectedDonee);

        int selection = doneeSystemUI.getDoneeModificationSelection();
        switch (selection) {
            case 0:
                break;
            case 1:
                modifyDoneeName(selectedDonee);
                break;
            case 2:
                modifyDoneeContact(selectedDonee);
            case 3:
                modifyDoneeAddress(selectedDonee);
            default:
                throw new AssertionError();
        }

        doneeSystemUI.showNewDonee(selectedDonee);
    }

    private void displayAllDonees() {
        LinkedSet<Donee> doneeSet = db.doneeDAO.getDonees();
        doneeSystemUI.showDonees(doneeSet);
    }

    private void deleteDonee() {
        LinkedSet<Donee> doneeSet = db.doneeDAO.getDonees();
        doneeSystemUI.showDoneeList(doneeSet);

        int selectedIndex = doneeSystemUI.getDoneeSelection();
        Donee selectedDonee = doneeSet.getValue(selectedIndex);

        db.doneeDAO.removeDonee(selectedDonee);
        doneeSystemUI.showRemovedDonee(selectedDonee);
    }

    private void modifyDoneeName(Donee selectedDonee) {
        String newName = doneeSystemUI.getNewDoneeName();
        selectedDonee.setName(newName);
    }

    private void modifyDoneeContact(Donee selectedDonee) {
        String newContact = doneeSystemUI.getNewDoneeName();
        selectedDonee.setContactNumber(newContact);
    }

    private void modifyDoneeAddress(Donee selectedDonee) {
        String newAddress = doneeSystemUI.getNewDoneeName();
        selectedDonee.setAddress(newAddress);
    }
}
