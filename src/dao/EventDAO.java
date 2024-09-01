/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.ArraySet;
import adt.LinkedSet;
import entity.Donor;
import entity.Event;

/**
 *
 * @author Tan Jee Schuan
 */
public class EventDAO {
    private LinkedSet<Event> eventSet;
    
    public EventDAO(){
        eventSet = new LinkedSet<Event>();
        //populatea set
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
    
    public LinkedSet getDonees(){
        return eventSet;
    }
}
