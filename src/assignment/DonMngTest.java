/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import adt.ArrayList;
import adt.LinkedSet;
import adt.interfaces.List;
import adt.interfaces.SetInterface;
import entity.DonationManagement;
import entity.Donor;
import entity.CharityCause;
import entity.Donation;
import java.util.Scanner;

/**
 *
 * @author Liau Xiao Xuan
 */
public class DonMngTest {

    Scanner sc = new Scanner(System.in);

    SetInterface<Donor> donors = new LinkedSet<>();

    DonationManagement dm = new DonationManagement();
    Donor donor2 = new Donor("Ferry", "F@e.ee");

    public DonMngTest() {
        // donationTest();
        donationManagementMenu();
    }

    public void donationTest() {
        Donor donor = new Donor("Eric", "E@e.ee");
        CharityCause cc = new CharityCause("cause");
        CharityCause cc2 = new CharityCause("Fcause");
        Donor donor3 = new Donor("George", "G@e.ee");
        CharityCause cc3 = new CharityCause("Gcause");

        donors.add(donor);
        donors.add(donor2);
        donors.add(donor3);

        dm.addDonation(donor, cc, 1);
        dm.addDonation(donor, cc, 2);
        dm.addDonation(donor, cc, 3);

        // dm.addDonation(donor, cc, 1);
        dm.addDonation(donor2, cc2, 2);                             // add
        dm.addDonation(donor3, cc3, 3);

        System.out.println(dm.getAllDonations());                                     // display
        System.out.println();
        System.out.println(dm.getDonationString(dm.getMostRecentDonor()));      // report

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Update");
        System.out.println();

        Donation dn1 = (Donation) dm.getDonorDonation(donor).get(0);
        Donation dn2 = (Donation) dm.getDonorDonation(donor).get(1);            // search

        dn1.setAmount(100.0);                                                   // update
        System.out.println(dm.getDonorDonation(donor).get(0));
        System.out.println(dm.getAllDonations());

        dm.getDonorDonation(donor).remove(dn2);                                     // remove
        System.out.println(dm.getAllDonations());

    }

    public void donationManagementMenu() {
        int option = 0;
        do {
            System.out.println("---------- Donation Management ----------");
            System.out.println("1. Add donation");
            System.out.println("2. Update donation");
            System.out.println("3. Remove domation");
            System.out.println("4. Display all donation");
            System.out.println("5. Search donation");
            System.out.println("6. Generate Report");
            System.out.println("7. Exit");
            System.out.println();
            System.out.print("Enter your option: ");
            String getOption = sc.nextLine();
            System.out.println();

            try {
                option = Integer.parseInt(getOption);
                if (option < 1 || option > 7) {
                    System.out.println("Only 1 - 7 is allowed. Please try again.");
                } else {
                    switch (option) {
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
            } catch (IllegalArgumentException ex) {
                System.out.println("Only integer is allowed. Please try again.");
            }
        } while (option != 7);
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
        Donor donor = donor2;

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
        Donor donor = donor2;

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
        Donor donor = donor2;

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

        List<CharityCause> causes = new ArrayList<>();
        causes.add(new CharityCause("ACause"));
        causes.add(new CharityCause("BCause"));
        causes.add(new CharityCause("CCause"));
        causes.add(new CharityCause("DCause"));

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
                    cause = causes.get(option - 1);
                }
            } catch (Exception ex) {
                System.out.println("Only integer is allowed. Please try again.");
            }

        } while (cause == null);
        return cause;
    }

    public static void main(String[] args) {
        DonMngTest t = new DonMngTest();
    }
}
