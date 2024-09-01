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
public class DonorSystemUI {
    boolean isEnd = false;
    private Scanner scanner;
    
    private final int maxNum = 4;
    
    public DonorSystemUI(){
        scanner = new Scanner(System.in);
    }
    
    public void showUI(){
        while(!isEnd){
            isEnd = false;
            
            System.out.println("\nDonor System Menu");
            System.out.println("------------------------");
            System.out.println("1. Add new donor");
            System.out.println("2. Modify donor information");
            System.out.println("3. Display all donors");
            System.out.println("4. Delete Donor");
            System.out.println("0. Exit");

            int input = Integer.parseInt(scanner.nextLine());
            scanner = new Scanner(System.in);

            switch (input) {
                case 0:
                    isEnd = true;
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
