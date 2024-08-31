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
public class MainInterface {
    boolean isEnd = false;
    private Scanner scanner;
    
    private final int maxNum = 4;
    
    public MainInterface(){
        scanner = new Scanner(System.in);
    }
    
    public void startUI(){
        DonorSystemInterface donorSystemInterface = new DonorSystemInterface();
        while(!isEnd){
            isEnd = false;
            
            System.out.println("\nCharity System Main Menu");
            System.out.println("------------------------");
            System.out.println("1. Donor System");
            System.out.println("2. Donee System");
            System.out.println("3. Donation Management System");
            System.out.println("4. Charity Cause Management System");
            System.out.println("5. Event System");
            System.out.println("0. Exit");

            int input = scanner.nextInt();

            switch (input) {
                case 0:
                    isEnd = true;
                    break;
                case 1:
                    donorSystemInterface.startUI();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("\nInvalid Input!\n");
            }
        }
    }

    public boolean isEnd() {
        return isEnd;
    }    
}
