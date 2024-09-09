/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.interfaces.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import adt.interfaces.Set;
import java.time.LocalDate;

/**
 *
 * @author Tan You Zhen
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
        System.out.println("6. Upcoming Event");
        System.out.println("0. Exit");
    }

    public int getMenuSelection() {
        System.out.println("Enter Selection: ");
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
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
        
        return date.atStartOfDay();
    }

    public void showCharityCause(List charityCauses) {
        int index = 0;
        for(var charityCause: charityCauses){
            System.out.println(index + " ----- " + charityCause.toString());
            index++;
        }
    }

    public int getEventIndex() {
        System.out.print("Enter selected event index: ");
        int input = Integer.parseInt(scanner.nextLine());
        return input; 
    }    

    public void showEvents(Set set) {
        for(var e: set){
            System.out.println(e);
        }
    }
    
    public void showEvent(String s) {
        System.out.println(s);
    }

    public int getEventSelection() {
        System.out.println("Enter Selected Event Index: ");
        int input = Integer.parseInt(scanner.nextLine());
        return input -1;
    }

    public void showEventModificationUI() {
        System.out.println("1. Modify Event Name");
        System.out.println("2. Modify Event Venue");
        System.out.println("3. Modify Event Date");
        System.out.println("4. Modify Event Charity Cause");
        System.out.println("0. Exit");
    }

    public int getEventModificationSelection() {
        System.out.println("Enter Selected Event Operation: ");
        int input = Integer.parseInt(scanner.nextLine());
        return input;    
    }

    public void showPastEvents() {
        System.out.println("\nPast Events\n-----------------");
    }

    public void showFutureEvents() {
        System.out.println("\nFuture Events\n-----------------");    
    }

    public void showRemovedEvent(Object selectedEvent) {
        System.out.println("Removed " + selectedEvent.toString());
    }
}
