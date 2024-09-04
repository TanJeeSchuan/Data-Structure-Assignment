/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.ArraySet;
import adt.LinkedSet;
import entity.CharityCause;
import entity.Donor;
import entity.Event;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Iterator;

/**
 *
 * @author Tan Jee Schuan
 */
public class EventDAO {
    private LinkedSet<Event> eventSet;
    
    public EventDAO(CharityCauseDAO charityCauseDAO){
        eventSet = new LinkedSet<Event>();
        //populatea set
        Iterator<CharityCause> charityCauseIt = charityCauseDAO.getCharityCauses().getIterator();
        
        CharityCause currentCharityCause = charityCauseIt.next();
        eventSet.add(new Event("Run for Hope", "Central Park", currentCharityCause, LocalDateTime.of(2024, 10, 1, 10, 15, 0)));
        eventSet.add(new Event("Charity Gala Night", "Grand Ballroom Hotel", currentCharityCause, LocalDateTime.of(2024, 10, 20, 14, 30, 45)));
        
        currentCharityCause = charityCauseIt.next();
        eventSet.add(new Event("Concert for a Cause", "City Arena", currentCharityCause, LocalDateTime.of(2024, 11, 5, 9, 45, 30)));
        eventSet.add(new Event("Food Drive Extravaganza", "Community Center", currentCharityCause, LocalDateTime.of(2024, 11, 18, 16, 10, 0)));
        
        currentCharityCause = charityCauseIt.next();
        eventSet.add(new Event("Charity Auction", "Town Hall", currentCharityCause, LocalDateTime.of(2024, 12, 2, 11, 20, 15)));
        eventSet.add(new Event("Walk to End Hunger", "Riverside Park", currentCharityCause, LocalDateTime.of(2024, 12, 14, 18, 35, 0)));
        
        currentCharityCause = charityCauseIt.next();
        eventSet.add(new Event("Silent Auction Dinner", "Luxury Banquet Hall", currentCharityCause, LocalDateTime.of(2024, 10, 15, 20, 50, 30)));
        eventSet.add(new Event("Charity Golf Tournament", "Green Valley Golf Course", currentCharityCause, LocalDateTime.of(2024, 11, 22, 13, 5, 45)));
        
        currentCharityCause = charityCauseIt.next();
        eventSet.add(new Event("Benefit Art Show", "City Art Museum", currentCharityCause, LocalDateTime.of(2024, 12, 28, 21, 55, 0)));
        eventSet.add(new Event("Charity Bake Sale", "School Gymnasium", currentCharityCause, LocalDateTime.of(2024, 11, 9, 17, 40, 15)));

        
        
//        new Event
//        eventSet.add(new Donor("John Smith", "john.smith@example.com"));
//        eventSet.add(new Donor("Emily Johnson", "emily.johnson@example.com"));
//        eventSet.add(new Donor("Michael Brown", "michael.brown@example.com"));
//        eventSet.add(new Donor("Sarah Davis", "sarah.davis@example.com"));
//        eventSet.add(new Donor("David Wilson", "david.wilson@example.com"));
//        eventSet.add(new Donor("Jessica Moore", "jessica.moore@example.com"));
//        eventSet.add(new Donor("Daniel Taylor", "daniel.taylor@example.com"));
//        donorSet.add(new Donor("Laura Anderson", "laura.anderson@example.com"));
//        donorSet.add(new Donor("James Thomas", "james.thomas@example.com"));
//        donorSet.add(new Donor("Olivia Martinez", "olivia.martinez@example.com"));
    }
    
    public LinkedSet getEvents(){
        return eventSet;
    }

    public void addEvent(Event newEvent) {
        eventSet.add(newEvent);
    }
}
