/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Tan Jee Schuan
 */
public class Event implements Comparable<Event>{
    private static int currentId = 1;
    private int eventId;
    private String eventName;
    private String eventVenue;
    
    public Event(String eventName, String eventVenue){
        this.eventId = currentId;
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        
        currentId++;
    }
    
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }
    
    @Override
    public int compareTo(Event o) {
        return this.eventId - o.eventId;
    }
}
