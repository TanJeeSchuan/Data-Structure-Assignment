/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import adt.LinkedSet;

/**
 *
 * @author Tan Jee Schuan
 */
public class DonationManagement {
    LinkedSet<Donor> donors;
    
    //adt<event, adt<donor, donation>>
    //adt<cause, adt<donor, donation>>
    
    //set of donors
    
    //most recent donor //CircularFifoQueue
    //queue
    
    //eg list(dict{cause, dict{donor, float donation}})

    public DonationManagement() {
        donors = new LinkedSet<>();
        
        //get all donors
    }
}