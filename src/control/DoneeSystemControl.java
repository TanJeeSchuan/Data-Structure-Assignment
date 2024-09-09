/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.ArrayList;
import adt.LinkedQueue;
import adt.LinkedSet;
import adt.interfaces.List;
import boundary.DoneeSystemUI;
import dao.DB;
import entity.CharityCause;
import entity.Donee;
import adt.interfaces.Queue;

/**
 *
 * @author xuanx
 */
public class DoneeSystemControl {

    private DoneeSystemUI doneeSystemUI;
    private Queue<Donee> doneeQueue = new LinkedQueue<>();
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
                case 5:
                    doneeReport();
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
        doneeQueue.enqueue(newDonee);
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
                break;
            case 3:
                modifyDoneeAddress(selectedDonee);
                break;
            default:
                throw new AssertionError();
        }

        doneeSystemUI.showNewDonee(selectedDonee);
    }

    private void displayAllDonees() {
        LinkedSet<Donee> doneeSet = db.doneeDAO.getDonees();
        ArrayList<CharityCause> causes = db.charityCauseDAO.getCharityCauses();
        String causeName = null;
        ArrayList<String> doneesInfo = new ArrayList<>();
        doneesInfo.add("%-3s | %-20s | %-30s | %-11s | %-50s".formatted("No.", "Donee Name", "Cause", "Contact Number", "Address"));
        for (int i = 0; i < doneeSet.size(); i++) {
            causeName = null;
            for (int j = 0; j < causes.size() && causeName == null; j++) {
                CharityCause cause = (CharityCause) causes.get(j);
                if (cause.donees.contains(doneeSet.getValue(i))) {
                    causeName = cause.getCauseName();
                }
            }
            doneesInfo.add("%-3d | %-20s | %-30s | %-11s | %-50s".formatted(i + 1, doneeSet.getValue(i).getName(), causeName, doneeSet.getValue(i).getContactNumber(), doneeSet.getValue(i).getAddress()));

        }

        doneeSystemUI.showDonees(doneesInfo);
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

    private void doneeReport() {
        List<String> recentDonee = new ArrayList<>();
        Queue<Donee> tempQueue = new LinkedQueue<>();
        LinkedSet<Donee> doneeSet = db.doneeDAO.getDonees();
        int total = doneeSet.size();

        if (doneeQueue.isEmpty()) {
            recentDonee.add("No new donees have been added recently.");
        } else {
            recentDonee.add("%-8s | %-30s | %-11s | %-50s".formatted("Donee ID", "Donee Name", "Contact Number", "Address"));

            // get data
            for (int i = 0; i < 10 && !doneeQueue.isEmpty(); i++) {
                Donee donee = doneeQueue.dequeue();
                tempQueue.enqueue(donee);
                recentDonee.add("%-8d | %-30s | %-11s | %-50s".formatted(donee.getDoneeId(), donee.getName(), donee.getContactNumber(), donee.getAddress()));

            }
            // store back
            while (!tempQueue.isEmpty()) {
                doneeQueue.enqueue(tempQueue.dequeue());
            }
        }

        doneeSystemUI.report(total, recentDonee);
    }
}
