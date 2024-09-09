/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.ArrayList;
import adt.interfaces.List;
import entity.Donor;
import java.util.Scanner;
import adt.interfaces.Set;

/**
 *
 * @author Tan Jee Schuan
 */
public class DonorSystemUI {
    private Scanner scanner;
    
    private final int maxNum = 4;
    
    public DonorSystemUI(){
        scanner = new Scanner(System.in);
    }
    
    public void showUI(){
            System.out.println("\nDonor System Menu");
            System.out.println("------------------------");
            System.out.println("1. Add new donor");
            System.out.println("2. Modify donor information");
            System.out.println("3. Display all donors");
            System.out.println("4. Delete Donor");
            System.out.println("5. Donor Report");
            System.out.println("0. Exit");
        }

    public int getMenuSelection(){
        int input = Integer.parseInt(scanner.nextLine());
        return input;
    }
    
    public String getNewDonorName(){
        System.out.print("\nEnter new donor email: ");
        return scanner.nextLine();
    }

    public String getNewDonorEmail() {
        System.out.print("Enter new donor email: ");
        return scanner.nextLine();
    }

    public void showNewDonor(Object o) {
        System.out.println("\nNew Donor Added: " + o);
    }

    public void showDonor(Object o) {
        System.out.println(o);
    }
    
    public void showDonors(ArrayList s) {
        for(Object o: s){
            System.out.println(o);
        }
    }

    public int getDonorSelection() {
        System.out.print("Enter selected Donor index: ");
        int input = Integer.parseInt(scanner.nextLine());
        return input; 
    }

    public void showDonorModificationUI(Object o) {
        System.out.println("\nSelected Donor: " + o.toString());
        System.out.println("1. Donor Name");
        System.out.println("2. Donor Email");
        System.out.println("0. Cancel");
    }

    public int getDonorModificationSelection() {
        System.out.println("Enter Selection: ");
        int input = Integer.parseInt(scanner.nextLine());
        return input;
    }

    public void showDonorList(Set d) {
        int index = 0;
        for(var o: d){
            System.out.println("\nIndex: " + index);
            index++;
            System.out.println(o);
        }
    }

    public void showRemovedDonor(Donor selectedDonor) {
        System.out.println("\nDonor %s Deleted!".formatted(selectedDonor.getName()));
    }

    public void report(int total, List<String> recentDonor) {
        System.out.println("Donee Report");
        System.out.println("Total of donors: " + total);
        System.out.println();
        System.out.println("Recently donor added information: ");
        for (int i = 0; i < recentDonor.size(); i++) {
            System.out.println(recentDonor.get(i));
        }
    }
}
