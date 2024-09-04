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
import java.time.format.DateTimeFormatter;

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
                    modifyEvent();
                    break;
                case 3:
                    displayAllEvents();
                    break;
                case 4:
                    eventReport();
                    break;
                case 5:
                    deleteEvent();
                    break;
                case 6:
                    upcomingEvent();
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
        eventSystemUI.showCharityCause(charityCauses);
        int selectedIndex = eventSystemUI.getEventIndex();
        CharityCause selectedCharityCause = charityCauses.get(selectedIndex);
        return selectedCharityCause;
    }

    private void displayAllEvents() {
        List<Event> eventList =  db.eventDAO.getEvents();
        
        eventSystemUI.showEvent("%-70s\t%-40s\t%-40s".formatted("Event", "Cause", "Date"));
        eventSystemUI.showEvent("------------------------------------------------------------");
        for(Event event: eventList){
            String s = "%-70s\t%-40s\t%-40s".formatted(event.toString(), event.getCharityCause().getCauseName(), event.getEventDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
            eventSystemUI.showEvent(s);
        }
    }

    private void modifyEvent() {
        List<Event> eventList = db.eventDAO.getEvents();
        
        int i = 1;
        for(Event event: eventList){
            String s = "%%d\t-70s\t%-40s\t%-40s".formatted(i, event.toString(), event.getCharityCause().getCauseName(), event.getEventDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
            eventSystemUI.showEvent(s);
            i++;
        }

        int selectedIndex = eventSystemUI.getEventSelection();
        Event selectedEvent = eventList.get(selectedIndex);
        
        eventSystemUI.showEventModificationUI();
        int selection = eventSystemUI.getEventModificationSelection();
        switch (selection) {
            case 0:
                break;
            case 1:
                modifyEventName(selectedEvent);
                break;
            case 2:
                modifyEventVenue(selectedEvent);
                break;
            case 3:
                modifyEventDate(selectedEvent);
                break;
            case 4:
                modifyEventCharityCause(selectedEvent);
                break;
            default:
                throw new AssertionError();
        }

        eventSystemUI.showEvent("%%d\t-70s\t%-40s\t%-40s".formatted(i, selectedEvent.toString(), selectedEvent.getCharityCause().getCauseName(), selectedEvent.getEventDate().format(DateTimeFormatter.ISO_LOCAL_DATE)));
    }
    
    private void modifyEventName(Event selectedEvent) {
        String s = eventSystemUI.getNewEventName();
        selectedEvent.setEventName(s);
    }

    private void modifyEventVenue(Event selectedEvent) {
        String s = eventSystemUI.getNewEventName();
        selectedEvent.setEventName(s);    
    }

    private void modifyEventDate(Event selectedEvent) {
        LocalDateTime s = eventSystemUI.getNewEventDate();
        selectedEvent.setEventDate(s);
    }

    private void modifyEventCharityCause(Event selectedEvent) {
        CharityCause charityCause = getSelectedCharityCause();
        selectedEvent.setCharityCause(charityCause);
    }

    private void eventReport() {
        List<Event> eventList = db.eventDAO.getEvents();
        
        eventSystemUI.showPastEvents();
        for(Event event: eventList){
            if(event.getEventDate().isBefore(LocalDateTime.now()))
                eventSystemUI.showEvent("%-70s\t%-40s\t%-40s".formatted(event.toString(), event.getCharityCause().getCauseName(), event.getEventDate().format(DateTimeFormatter.ISO_LOCAL_DATE)));
        }
        
        eventSystemUI.showFutureEvents();
        for(Event event: eventList){
            if(event.getEventDate().isAfter(LocalDateTime.now()))
                eventSystemUI.showEvent("%-70s\t%-40s\t%-40s".formatted(event.toString(), event.getCharityCause().getCauseName(), event.getEventDate().format(DateTimeFormatter.ISO_LOCAL_DATE)));
        }
    }

    private void deleteEvent() {
        List<Event> eventList = db.eventDAO.getEvents();
        
        int i = 1;
        for(Event event: eventList){
            String s = "%d\t%-70s\t%-40s\t%-40s".formatted(i, event.toString(), event.getCharityCause().getCauseName(), event.getEventDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
            eventSystemUI.showEvent(s);
            i++;
        }

        int selectedIndex = eventSystemUI.getEventSelection();
        Event selectedEvent = eventList.get(selectedIndex);
        db.eventDAO.removeEvent(selectedEvent);
        
        eventSystemUI.showRemovedEvent(selectedEvent);
    }

    private void upcomingEvent() {
        List<Event> eventList = db.eventDAO.getEvents();
        eventSystemUI.showFutureEvents();
        for(Event event: eventList){
            if(event.getEventDate().isAfter(LocalDateTime.now()))
                eventSystemUI.showEvent("%-70s\t%-40s\t%-40s".formatted(event.toString(), event.getCharityCause().getCauseName(), event.getEventDate().format(DateTimeFormatter.ISO_LOCAL_DATE)));
        }    
    }
}
