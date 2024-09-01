/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import java.util.Scanner;

/**
 *
 * @author Tan Jee Schuan
 */
public class MainUI {
    private Scanner scanner;
    
    private final int maxNum = 4;
    
    public MainUI(){
        scanner = new Scanner(System.in);
    }
    
    public void showUI(){        
        System.out.println("\nCharity System Main Menu");
        System.out.println("------------------------");
        System.out.println("1. Donor System");
        System.out.println("2. Donee System");
        System.out.println("3. Donation Management System");
        System.out.println("4. Charity Cause Management System");
        System.out.println("5. Event System");
        System.out.println("0. Exit");
    }
    
    public int getSelection(){
        int input = 0;
        boolean isEnd = false;
        
        while(!isEnd){
            isEnd = false;
            
            System.out.print("Enter selection: ");
            
            input = Integer.parseInt(scanner.nextLine());
            
            if(input >= 0 && input < 6){
                isEnd = true;
            } else {
                System.out.println("\nInvalid Input!\n");
            }
        }
        
        return input;
    }
}
