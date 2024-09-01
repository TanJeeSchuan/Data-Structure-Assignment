/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import dao.DB;
import java.util.Scanner;

/**
 *
 * @author Tan Jee Schuan
 */
public class CharityCauseMaintainanceUI {
    private Scanner scanner;
    
    private final int maxNum = 4;
    
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
}
