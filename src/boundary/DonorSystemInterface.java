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
public class DonorSystemInterface {
    boolean isEnd = false;
    private Scanner scanner;
    
    private final int maxNum = 4;
    
    public DonorSystemInterface(){
        scanner = new Scanner(System.in);
    }
    
    public void startUI(){
        while(!isEnd){
            isEnd = false;
            
            System.out.println("\nonor System Menu");
            System.out.println("------------------------");
            System.out.println("1. Add new donor");
            System.out.println("2. Modify donor information");
            System.out.println("3. Display all donors");
            System.out.println("4. Delete Donor");
            System.out.println("0. Exit");

            int input = scanner.nextInt();

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
