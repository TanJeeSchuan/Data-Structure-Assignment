/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.ArrayList;
import adt.interfaces.List;
import adt.interfaces.SetInterface;
import boundary.EventSystemUI;
import dao.DB;
import entity.CharityCause;
import entity.Event;
import java.time.LocalDateTime;

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
                    displayAllEvents();
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
        CharityCause eventCharityCause = getSelectedCharityCause();
        LocalDateTime eventDate = eventSystemUI.getNewEventDate();
        
        Event newEvent = new Event(eventName, eventVenue, eventCharityCause, eventDate);
        
        db.eventDAO.addEvent(newEvent);
    }    

    private CharityCause getSelectedCharityCause() {
        List<CharityCause> charityCauses =  db.charityCauseDAO.getCharityCauses();
        eventSystemUI.showCharityCauses(charityCauses);
        int selectedIndex = eventSystemUI.getCharityCauseIndex();
        CharityCause selectedCharityCause = charityCauses.get(selectedIndex);
        return selectedCharityCause;
    }

    private void displayAllEvents() {
        SetInterface<Event> eventList =  db.eventDAO.getEvents();
        eventSystemUI.showEvents(eventList);    }
    }
