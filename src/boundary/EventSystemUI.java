/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.interfaces.List;
import adt.interfaces.SetInterface;
import entity.CharityCause;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public void showAddingNewEvent() {
        System.out.println("\nAdding New Event...");
    }

    public String getNewEventName() {
        System.out.print("Enter Event Name: ");
        String output = scanner.nextLine();
        return output;
    }

    public String getNewEventVenue() {
        System.out.print("Enter Event Venue: ");
        String output = scanner.nextLine();
        return output;    
    }

    public LocalDateTime getNewEventDate() {
        System.out.print("Enter Event Date With Format (yyyy-mm-dd): ");
        String dateString = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_DATE);
        
        return dateTime;
    }

    public void showCharityCauses(List<CharityCause> charityCauses) {
        int index = 0;
        for(CharityCause charityCause: charityCauses){
            System.out.println(index + " ----- " + charityCause.toString());
        }
    }

    public int getCharityCauseIndex() {
        System.out.print("Enter selected event index: ");
        int input = Integer.parseInt(scanner.nextLine());
        return input; 
    }    

    public void showEvents(SetInterface set) {
        for(var e: set){
            System.out.println(e);
        }
    }
}
