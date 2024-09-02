/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.ArrayList;
import adt.LinkedSet;
import boundary.DonationManagementUI;
import dao.DB;
import entity.CharityCause;
import entity.DonationManagement;
import entity.Donor;

/**
 *
 * @author xuanx
 */
public class DonationManagementControl {

    private DonationManagementUI donationManagementUI;
    private DonationManagement dm;
    LinkedSet<Donor> donors = DB.getInstance().donorDAO.getDonors();

    public DonationManagementControl() {
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

        System.out.println("---------- Add Donation ----------");

        // ----- CAUSE ---------------------------------------------------------------------------------------------------
        CharityCause cause = getCause();

        // -------DONATION AMOUNT-------------------------------------------------------------------------------------------------
        double amount = 0;
        boolean valid = true;

        do {
            valid = true;
            System.out.print("Donation amount: RM ");
            String getOption = sc.nextLine();
            try {
                amount = Double.parseDouble(getOption);
                if (amount <= 0) {
                    System.out.println("The value must greater than RM 0.");
                    valid = false;
                }
            } catch (Exception ex) {
                System.out.println("Only integer is allowed. Please try again.");
                valid = false;
            }
        } while (!valid);

        // -------DONOR-------------------------------------------------------------------------------------------------
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        System.out.println();

        Donor donor = new Donor(name, email);
//        donors.add(donor);

        dm.addDonation(donor, cause, amount);
        System.out.println("The donation information added sucessfully.");
    }
    
    public CharityCause getCause() {
        int option = 0;
        CharityCause cause = null;

        ArrayList<CharityCause> causes = DB.getInstance().charityCauseDAO.getCharityCauses();

        do {
            System.out.println("CAUSE");
            System.out.println("-------------");
            for (int i = 0; i < causes.size(); i++) {
                System.out.println((i + 1) + ". " + causes.get(i));
            }
            System.out.print("Enter the cause you want to donate: ");
            String getOption = sc.nextLine();

            try {
                option = Integer.parseInt(getOption);

                if (option < 1 || option > causes.size()) {
                    System.out.println("Only 1 - " + causes.size() + " is allowed. Please try again.");
                } else {
                    cause = (CharityCause) causes.get(option - 1);
                }
            } catch (Exception ex) {
                System.out.println("Only integer is allowed. Please try again.");
            }

        } while (cause == null);
        return cause;
    }
}
