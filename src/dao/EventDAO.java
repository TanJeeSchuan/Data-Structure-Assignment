/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.SortedArrayList;
import entity.CharityCause;
import entity.Event;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author Tan You Zhen
 */
public class EventDAO {
    private SortedArrayList<Event> eventList;
    
    public EventDAO(CharityCauseDAO charityCauseDAO){
        eventList = new SortedArrayList<Event>(new Comparator<Event>(){
            @Override
            public int compare(Event o1, Event o2) {
                return o1.getEventDate().compareTo(o2.getEventDate());
            }            
        });
        //populatea set
        Iterator<CharityCause> charityCauseIt = charityCauseDAO.getCharityCauses().iterator();
        
        CharityCause currentCharityCause = charityCauseIt.next();
        eventList.add(new Event("Run for Hope", "Central Park", currentCharityCause, LocalDateTime.of(2024, 10, 1, 10, 15, 0)));
        eventList.add(new Event("Charity Gala Night", "Grand Ballroom Hotel", currentCharityCause, LocalDateTime.of(2024, 10, 20, 14, 30, 45)));
        eventList.add(new Event("Spring Fundraiser", "Central Park", currentCharityCause, LocalDateTime.of(2024, 3, 15, 10, 0, 0)));
        eventList.add(new Event("Charity Run", "City Stadium", currentCharityCause, LocalDateTime.of(2024, 4, 20, 8, 30, 0)));
        
        currentCharityCause = charityCauseIt.next();
        eventList.add(new Event("Concert for a Cause", "City Arena", currentCharityCause, LocalDateTime.of(2024, 11, 5, 9, 45, 30)));
        eventList.add(new Event("Food Drive Extravaganza", "Community Center", currentCharityCause, LocalDateTime.of(2024, 11, 18, 16, 10, 0)));

        eventList.add(new Event("Summer Picnic", "Lakeside Park", currentCharityCause, LocalDateTime.of(2024, 6, 10, 12, 0, 0)));
        eventList.add(new Event("Music Festival for a Cause", "Downtown Plaza", currentCharityCause, LocalDateTime.of(2024, 7, 22, 15, 45, 0)));
        
        
        currentCharityCause = charityCauseIt.next();
        eventList.add(new Event("Charity Auction", "Town Hall", currentCharityCause, LocalDateTime.of(2024, 12, 2, 11, 20, 15)));
        eventList.add(new Event("Walk to End Hunger", "Riverside Park", currentCharityCause, LocalDateTime.of(2024, 12, 14, 18, 35, 0)));
        
        eventList.add(new Event("Volunteer Appreciation Dinner", "Hotel Conference Room", currentCharityCause, LocalDateTime.of(2024, 8, 5, 19, 0, 0)));
        eventList.add(new Event("Back-to-School Drive", "Community Center", currentCharityCause, LocalDateTime.of(2024, 8, 25, 9, 0, 0)));

        
        currentCharityCause = charityCauseIt.next();
        eventList.add(new Event("Silent Auction Dinner", "Luxury Banquet Hall", currentCharityCause, LocalDateTime.of(2024, 10, 15, 20, 50, 30)));
        eventList.add(new Event("Charity Golf Tournament", "Green Valley Golf Course", currentCharityCause, LocalDateTime.of(2024, 11, 22, 13, 5, 45)));
        
        eventList.add(new Event("Charity Movie Night", "Local Theater", currentCharityCause, LocalDateTime.of(2024, 5, 18, 20, 0, 0)));
        eventList.add(new Event("Spring Plant Sale", "Botanical Garden", currentCharityCause, LocalDateTime.of(2024, 4, 12, 14, 0, 0)));

        
        currentCharityCause = charityCauseIt.next();
        eventList.add(new Event("Benefit Art Show", "City Art Museum", currentCharityCause, LocalDateTime.of(2024, 12, 28, 21, 55, 0)));
        eventList.add(new Event("Charity Bake Sale", "School Gymnasium", currentCharityCause, LocalDateTime.of(2024, 11, 9, 17, 40, 15)));
        
        eventList.add(new Event("Fundraising Gala", "Luxury Hotel Ballroom", currentCharityCause, LocalDateTime.of(2024, 2, 28, 19, 30, 0)));
        eventList.add(new Event("Community Clean-Up", "City Park", currentCharityCause, LocalDateTime.of(2024, 3, 22, 10, 30, 0)));

        
//        new Event
//        eventList.add(new Donor("John Smith", "john.smith@example.com"));
//        eventList.add(new Donor("Emily Johnson", "emily.johnson@example.com"));
//        eventList.add(new Donor("Michael Brown", "michael.brown@example.com"));
//        eventList.add(new Donor("Sarah Davis", "sarah.davis@example.com"));
//        eventList.add(new Donor("David Wilson", "david.wilson@example.com"));
//        eventList.add(new Donor("Jessica Moore", "jessica.moore@example.com"));
//        eventList.add(new Donor("Daniel Taylor", "daniel.taylor@example.com"));
//        donorSet.add(new Donor("Laura Anderson", "laura.anderson@example.com"));
//        donorSet.add(new Donor("James Thomas", "james.thomas@example.com"));
//        donorSet.add(new Donor("Olivia Martinez", "olivia.martinez@example.com"));
    }
    
    public SortedArrayList getEvents(){
        return eventList;
    }

    public void addEvent(Event newEvent) {
        eventList.add(newEvent);
    }

    public void removeEvent(Event selectedEvent) {
        eventList.remove(selectedEvent);
    }
}
