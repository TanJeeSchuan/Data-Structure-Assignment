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
    
        public void updateDonation() {
        System.out.println("---------- Update Donation ----------");
        boolean isExist = false;

        // *********** Get donor **************//
        Donor donor = null;

//        do {
//            System.out.println("Enter the your name: ");
//            String name = sc.nextLine();
//
//            for (int i = 0; i < donors.size() && !isExist; i++) {
//                if (donors.getValue(i).equals(name)) {
//                    donor = donors.getValue(i);
//                    isExist = true;
//                }
//            }
//
//            if (!isExist) {
//                System.out.println("No such name. Please try again");
//            }
//        } while (!isExist);
        Donation donation = null;
        System.out.println(dm.getDonorDonation(donor));

        int option = 0;
        do {
            System.out.print("Enter the index that you want to modify: ");
            String getInput = sc.nextLine();
            try {
                option = Integer.parseInt(getInput);
                if (option <= 0 || option > dm.getDonorDonation(donor).size()) {
                    System.out.println("Only 1 to " + dm.getDonorDonation(donor).size() + " is allowed. Please try again.");
                } else {
                    donation = (Donation) dm.getDonorDonation(donor).get(option - 1);
                }
            } catch (Exception ex) {
                System.out.println("Only number is allowed. Please try again.");
            }
        } while (donation == null);

        double amount = 0;

        System.out.println();
        System.out.println("1. Donor");
        System.out.println("2. Cause");
        System.out.println("3. Donation amount");

        do {
            System.out.println("Enter the part you want to modify: ");

            String getInput = sc.nextLine();
            try {
                option = Integer.parseInt(getInput);
                switch (option) {
                    case 1:
                        // updateDonor();
                        donation.setDonor(donor);
                        break;
                    case 2:
                        CharityCause cause = getCause();
                        donation.setCause(cause);
                        break;
                    case 3:
                        boolean valid = true;
                        do {
                            valid = true;
                            try {
                                System.out.print("Enter the amount: ");
                                amount = sc.nextDouble();
                                if (amount <= 0) {
                                    System.out.println("Amount must greater than 0. Please try again.");
                                    valid = false;
                                }
                            } catch (Exception ex) {
                                System.out.println("Only number is allowed. Please try again.");
                                valid = false;
                            }

                        } while (!valid);

                        donation.setAmount(amount);

                        break;
                    default:
                        System.out.println("Only 1 to 3 is allowed. Please try again.");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Only number is allowed. Please try again.");
            }
        } while (option < 1 || option > 3);
        System.out.println();
        System.out.println("The donation information updated successfully.");
    }

    public void removeDonation() {
        // *********** Get donor **************//
        Donor donor = null;

//        do {
//            System.out.println("Enter the your name: ");
//            String name = sc.nextLine();
//
//            for (int i = 0; i < donors.size() && !isExist; i++) {
//                if (donors.getValue(i).equals(name)) {
//                    donor = donors.getValue(i);
//                    isExist = true;
//                }
//            }
//
//            if (!isExist) {
//                System.out.println("No such name. Please try again");
//            }
//        } while (!isExist);
        Donation donation = null;
        System.out.println(dm.getDonorDonation(donor));

        int option = 0;
        do {
            System.out.print("Enter the index that you want to modify: ");
            String getInput = sc.nextLine();
            try {
                option = Integer.parseInt(getInput);
                if (option <= 0 || option > dm.getDonorDonation(donor).size()) {
                    System.out.println("Only 1 to " + dm.getDonorDonation(donor).size() + " is allowed. Please try again.");
                } else {
                    donation = (Donation) dm.getDonorDonation(donor).get(option - 1);
                }
            } catch (Exception ex) {
                System.out.println("Only number is allowed. Please try again.");
            }
        } while (donation == null);

        String confirmation = null;
        System.out.println("----------------------------------------------------------");
        System.out.println(donation);

        do {
            System.out.println("Do you confirm to remove it? (Y/N)");
            confirmation = sc.nextLine();
            switch (confirmation.charAt(0)) {
                case 'Y':
                case 'y':
                    dm.getDonorDonation(donor).remove(donation);
                    System.out.println();
                    System.out.println("The donation data deleted.");
                    break;
                case 'N':
                case 'n':
                    System.out.println();
                    System.out.println("The donation data retained.");
                    break;
                default:
                    System.out.println("Only 'Y' or 'N' is allowed. Please try again.");

            }
        } while (confirmation.charAt(0) != 'Y' && confirmation.charAt(0) != 'y' && confirmation.charAt(0) != 'N' && confirmation.charAt(0) != 'n');

    }

    public void displayDonation() {
        System.out.println("---------- Display Donation ----------");
        System.out.println(dm.getAllDonations());
    }

    public void searcDonation() {
        System.out.println("---------- Search Donation ----------");
        Donor donor = null;
        boolean isExist = false;

        do {
            System.out.println("Enter the your name: ");
            String name = sc.nextLine();

            for (int i = 0; i < donors.size() && !isExist; i++) {
                if (donors.getValue(i).equals(name)) {
                    donor = donors.getValue(i);
                    isExist = true;
                }
            }

            if (!isExist) {
                System.out.println("No such name. Please try again");
            }
        } while (!isExist);

        Donation donation = null;
        System.out.println(donor);
        System.out.println(dm.getDonorDonation(donor));
    }

    public void donationReport() {
        System.out.println("---------- Donation Report ----------");
        System.out.println("Most Recent Donor: ");
        System.out.println(dm.getDonationString(dm.getMostRecentDonor()));
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
