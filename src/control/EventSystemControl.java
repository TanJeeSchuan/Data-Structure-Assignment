/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.EventSystemUI;
import dao.DB;
import entity.Event;

/**
 *
 * @author Tan Jee Schuan
 */
public class EventSystemControl {
    private EventSystemUI eventSystemUI;
    private DB db = DB.getInstance();
    
    public EventSystemControl(){
        eventSystemUI = new EventSystemUI();
    }
    
    public void startUI(){
        boolean isEnd = false;
        
        while(!isEnd){
            isEnd = false;
        
            eventSystemUI.showUI();
            int choice = eventSystemUI.getMenuSelection();
    
            switch (choice) {
                case 0:
                    isEnd = true;
                    break;
                case 1:
                    addEvent();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    private void addEvent() {
        eventSystemUI.showAddingNewEvent();
        String eventName = eventSystemUI.getNewEventName();
        String eventVenue = eventSystemUI.getNewEventVenue();
        
        Event newEvent = new Event(eventName, eventVenue);
        
        db.eventDAO.addEvent(newEvent);
    }    
}
