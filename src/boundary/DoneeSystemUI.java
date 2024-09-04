/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.ArrayList;
import adt.interfaces.List;
import adt.interfaces.SetInterface;
import entity.Donee;
import java.util.Scanner;

/**
 *
 * @author xuanx
 */
public class DoneeSystemUI {

    private Scanner scanner;

    private final int maxNum = 4;

    public DoneeSystemUI() {
        scanner = new Scanner(System.in);
    }

    public void showUI() {
        System.out.println("\nDonee System Menu");
        System.out.println("------------------------");
        System.out.println("1. Add new donee");
        System.out.println("2. Modify donee information");
        System.out.println("3. Display all donees");
        System.out.println("4. Delete Donee");
        System.out.println("5. Donee Report");
        System.out.println("0. Exit");
    }

    public int getMenuSelection() {
        int input = Integer.parseInt(scanner.nextLine());
        return input;
    }

    public String getNewDoneeName() {
        System.out.print("\nEnter new donee name: ");
        return scanner.nextLine();
    }

    public String getNewDoneeContact() {
        System.out.print("Enter new donee contact number: ");
        return scanner.nextLine();
    }

    public String getNewDoneeAddress() {
        System.out.print("Enter new donee address: ");
        return scanner.nextLine();
    }

    public void showNewDonee(Object o) {
        System.out.println("\nNew Donee Added: " + o);
    }

    public void showDonee(Object o) {
        System.out.println(o);
    }

    public void showDonees(ArrayList s) {
        for (Object o : s) {
            System.out.println(o);
        }
    }

    public int getDoneeSelection() {
        System.out.print("Enter selected Donee index: ");
        int input = Integer.parseInt(scanner.nextLine());
        return input;
    }

    public void showDoneeModificationUI(Object o) {
        System.out.println("\nSelected Donee: " + o.toString());
        System.out.println("1. Donee Name");
        System.out.println("2. Donee Contact Number");
        System.out.println("3. Donee Address");
        System.out.println("0. Cancel");
    }

    public int getDoneeModificationSelection() {
        System.out.println("Enter Selection: ");
        int input = Integer.parseInt(scanner.nextLine());
        return input;
    }

    public void showDoneeList(SetInterface d) {
        int index = 0;
        for (var o : d) {
            System.out.println("\nIndex: " + index);
            index++;
            System.out.println(o);
        }
    }

    public void showRemovedDonee(Donee selectedDonee) {
        System.out.println("\nDonee %s Deleted!".formatted(selectedDonee.getName()));
    }

    public void report(int total, List<String> recentDonee) {
        System.out.println("Donee Report");
        System.out.println("Total of donees: " + total);
        System.out.println();
        System.out.println("The last " + recentDonee.size() + " donee informations added: ");
        for (int i = 0; i < recentDonee.size(); i++) {
            System.out.println(recentDonee.get(i));
        }
    }
}
