/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.ArrayMap;
import adt.LinkedSet;
import adt.ArrayList;

/**
 *
 * @author Tan Jee Schuan
 */
public class DonationManagement {
    LinkedSet<Donor> donors;
    //fast lookup
    ArrayMap<Donor, ArrayList<Donation>> donations;
    
    
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
    
    //add donation
    public void addDonation(Donor donor, CharityCause charityCause,double amount){
        Donation newDonation = new Donation(donor,charityCause, amount);
        
        if(donations.has(donor)){
            donations.get(donor).add(newDonation);
        } else {
            ArrayList<Donation> donationArrayList = new ArrayList<>();
            donationArrayList.add(newDonation);
            donations.add(donor, donationArrayList);
        }
    }
}