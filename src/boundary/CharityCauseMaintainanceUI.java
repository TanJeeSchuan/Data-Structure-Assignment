package boundary;

import adt.ArrayList;
import adt.LinkedSet;
import adt.SortedArrayList;
import java.util.Scanner;

/**
 *
 * @author Tan Jee Schuan
 */
public class CharityCauseMaintainanceUI {
    private Scanner scanner;
    
    public CharityCauseMaintainanceUI(){
        scanner = new Scanner(System.in);
    }
    
    public void showUI(){
        System.out.println("\nCharity Cause Maintainance Menu");
        System.out.println("------------------------");
        System.out.println("1. Add new charity cause");
        System.out.println("2. Modify charity cause");
        System.out.println("3. Display all charity causes");
        System.out.println("4. Delete cause");
        System.out.println("0. Exit");
    }
    
    public void showAddCharityUI(){
        System.out.print("Enter cause name: ");
    }
    
    public void showCharityCauseHeader(){
        System.out.println("\n%-10s%-30s%-20s".formatted(
                "CauseId","Cause Name","Number of Donee"));
    }
    
    public void showCharityCauseSelection(String charityString){
        System.out.println(charityString);
    }
    
    public String getCauseDetails(){
        return scanner.nextLine();
    }

    public int getSelection() {
        int input = 0;
        boolean isEnd = false;
        while(!isEnd){
            isEnd = false;
            
            System.out.print("Enter selection: ");
            
            input = Integer.parseInt(scanner.nextLine());
            scanner = new Scanner(System.in);
            
            if(input >= 0 && input < 5){
                isEnd = true;
            } else {
                System.out.println("\nInvalid Input!\n");
            }
        }
        
        return input;
    }

    public int getCauseSelection() {
        System.out.print("\nEnter selected cause index: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void showModificationUI(Object get) {
        System.out.println("\nSelected Charity Cause: " + get.toString());
        System.out.println("1. Cause Name");
        System.out.println("2. Donees");
        System.out.println("0. Cancel");
    }

    public int inputModificationChoice() {
        System.out.print("\nEnter parameter to modify: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getNewCauseName() {
        System.out.print("\nEnter new charity cause name: ");
        return (scanner.nextLine());
    }

    public void showCharityCauseDonees(SortedArrayList lst) {
        System.out.println("Donees of cause: ");
        int i = 0;
        for(var o: lst){
            System.out.println(i + " " + o.toString());
            i++;
        }
    }
    
    public void showCharityCauses(ArrayList lst) {
        for(var o: lst){
            System.out.println("\n"+o);
        }
    }

    public int getAddOrRemoveDonee() {
        System.out.println("\n1. Add Donor");
        System.out.println("2. Remove Donor");
        System.out.print("Enter selection: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int getRemovedDoneeIndex() {
        System.out.print("\nEnter Donor index to remove: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void showDonees(LinkedSet donees) {
        System.out.println();
        int i = 0;
        for(Object o: donees){
            System.out.println(i + " " + o.toString());
            i++;
        }
    }

    public int getNewDoneeIndex() {
        System.out.println("Enter index of new donee: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
