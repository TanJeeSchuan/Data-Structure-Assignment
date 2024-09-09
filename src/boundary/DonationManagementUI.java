package boundary;

import adt.ArrayList;
import adt.LinkedSet;
import adt.interfaces.List;
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
public class DonationManagementUI {

    private Scanner sc;
    private DonationManagement dm;
    LinkedSet<Donor> donors = DB.getInstance().donorDAO.getDonors();

    public DonationManagementUI() {
        sc = new Scanner(System.in);
        dm = new DonationManagement();
        dm.donations = DB.getInstance().donationDAO.getDonations();
    }

    public int showMenu() {
        int option = 0;
        boolean valid;
        do {
            System.out.println();
            System.out.println("---------- Donation Management ----------");
            System.out.println("1. Add donation");
            System.out.println("2. Update donation");
            System.out.println("3. Remove domation");
            System.out.println("4. Display all donation");
            System.out.println("5. Search donation");
            System.out.println("6. Generate Report");
            System.out.println("0. Exit");
            System.out.println();

            valid = true;
            System.out.print("Enter your option: ");
            String getOption = sc.nextLine();
            System.out.println();

            try {
                option = Integer.parseInt(getOption);
                if (option < 0 || option > 6) {
                    System.out.println(
                            "Only 0 - 6 is allowed. Please try again.");
                    valid = false;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(
                        "Only integer is allowed. Please try again.");
                valid = false;
            }
        } while (!valid);

        return option;
    }

    public CharityCause getCauseOption(ArrayList<CharityCause> causes) {
        int option;
        CharityCause cause = null;

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
                    System.out.println(
                            "Only 1 - " + causes.size() +
                                    " is allowed. Please try again.");
                } else {
                    cause = (CharityCause) causes.get(option - 1);
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(
                        "Only integer is allowed. Please try again.");
            }

        } while (cause == null);

        return cause;
    }

    public double getDonationAmount() {
        boolean valid;
        double amount = 0;

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
            } catch (IllegalArgumentException ex) {
                System.out.println(
                        "Only integer is allowed. Please try again.");
                valid = false;
            }
        } while (!valid);

        return amount;
    }

    public String getDonorName() {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        return name;
    }

    public String getDonorEmail() {
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        System.out.println();

        return email;
    }

    public void promptSuccessMessage(String action) {
        System.out.println(
                "The donation information " + action + " sucessfully.");
    }

    public void noSuchInformation() {
        System.out.println("No such information.");
    }

    public int getModifyOption() {
        int option = 0;
        do {
            System.out.println();
            System.out.println("1. Donor");
            System.out.println("2. Cause");
            System.out.println("3. Donation amount");

            System.out.println("Enter the part you want to modify: ");

            String getInput = sc.nextLine();
            try {
                option = Integer.parseInt(getInput);
                if (option < 1 || option > 3) {
                    System.out.println(
                            "Only 1 to 3 is allowed. Please try again.");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(
                        "Only number is allowed. Please try again.");
            }
        } while (option < 1 || option > 3);
        System.out.println();

        return option;
    }

    public void promptTitle(String title) {
        System.out.println("-------- " + title + " --------");
    }

    public boolean getDeleteConfirmation(Donation donation) {
        System.out.println(
                "----------------------------------------------------------");
        System.out.println(donation);

        String confirmation;

        do {
            System.out.println("Do you confirm to remove it? (Y/N)");
            confirmation = sc.nextLine();
            switch (confirmation.charAt(0)) {
                case 'Y':
                case 'y':
                    return true;
                case 'N':
                case 'n':
                    return false;
                default:
                    System.out.println(
                            "Only 'Y' or 'N' is allowed. Please try again.");

            }
        } while (confirmation.charAt(0) != 'Y' && 
                confirmation.charAt(0) != 'y' && 
                confirmation.charAt(0) != 'N' && 
                confirmation.charAt(0) != 'n');

        return true;
    }

    public void displayAllDonations(List<String> donations) {
        for(int i = 0; i < donations.size(); i++){
            System.out.println(donations.get(i));
        }
    }

    public void promptInformation(String donationInformation) {
        System.out.println(donationInformation);
    }

    public int getReportOption() {
        int option = 0;
        boolean valid;
        do {
            System.out.println("1. Donor in Donation Report");
            System.out.println("2. Donation Report");
            System.out.println("3. Most Recent Donor");
            System.out.println();

            valid = true;
            System.out.print("Enter your option: ");
            String getOption = sc.nextLine();
            System.out.println();

            try {
                option = Integer.parseInt(getOption);
                if (option < 1 || option > 3) {
                    System.out.println(
                            "Only 1 - 3 is allowed. Please try again.");
                    valid = false;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(
                        "Only integer is allowed. Please try again.");
                valid = false;
            }
        } while (!valid);

        return option;
    }

    public void promtMostRecentDonor(
            Donor donor, int highest, String donationArrayString) {
        System.out.println(donor);
        System.out.println("Total donation: " + highest);
        System.out.println("---------------");
        System.out.println("Donation Detail ");
        System.out.println("---------------");
        System.out.println(donationArrayString);
    }

    public void displayDonorReport(int number, List<String> donorInfo) {
        System.out.println(
                "Total of donors who participated in the donation: " 
                        + number);
        System.out.println();
        for (int i = 0; i < donorInfo.size(); i++) {
            System.out.println(donorInfo.get(i));
        }
    }

    public void displayDonationReport(List<String> donationInfoReport) {
        System.out.println("Total of donation: " + donationInfoReport.size());
        System.out.println();
        for (int i = 0; i < donationInfoReport.size(); i++) {
            System.out.println(donationInfoReport.get(i));
        }
        
    }

    public int getSelection() {
        System.out.print("Enter the index you want to modify: ");
        String selection = sc.nextLine();
        
        return Integer.parseInt(selection);
    }
}
