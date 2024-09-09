package entity;

import java.time.LocalDateTime;

/**
 *
 * @author Tan Jee Schuan
 */
public class Event implements Comparable<Event>{
    private static int currentId = 1;
    private int eventId;
    private String eventName;
    private String eventVenue;
    private LocalDateTime eventDate;
    private CharityCause charityCause;
    
    public Event(String eventName, String eventVenue){
        this.eventId = currentId;
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.eventDate = LocalDateTime.now();
        
        currentId++;
    }
    
    public Event(String eventName, String eventVenue, CharityCause charityCause){
        this.eventId = currentId;
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.charityCause = charityCause;
        this.eventDate = LocalDateTime.now();
        
        currentId++;
    }
    
    public Event(String eventName, String eventVenue, CharityCause charityCause, LocalDateTime eventDate){
        this.eventId = currentId;
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.charityCause = charityCause;
        this.eventDate = eventDate;
        
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
    
    public CharityCause getCharityCause(){
        return charityCause;
    }
    
    public void setCharityCause(CharityCause charityCause){
        this.charityCause = charityCause;
    }
    
    public LocalDateTime getEventDate(){
        return this.eventDate;
    }
    
    public void setEventDate(LocalDateTime eventDate){
        this.eventDate = eventDate;
    }
    
    @Override
    public int compareTo(Event o) {
        return this.eventId - o.eventId;
    }
    
    @Override
    public String toString() {
        return this.eventId + ", " + this.eventName + ", " + this.eventVenue;
    }
}
