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
public class EventSystemUI {
    private Scanner scanner;
        
    public EventSystemUI(){
        scanner = new Scanner(System.in);
    }
    
    public void showUI() {
        System.out.println("\nEvent System Menu");
        System.out.println("-----------------");
        System.out.println("1. Add Event");
        System.out.println("2. Modify Event");
        System.out.println("3. Display all events");
        System.out.println("4. Event report");
        System.out.println("5. Delete Event");
        System.out.println("6. Upcoming Events");
    }

    public int getMenuSelection() {
        int input = Integer.parseInt(scanner.nextLine());
        return input;
    }
    
    
}
