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
    public void addDonation(Donor donor, CharityCause charityCause, double amount) {
        Donation newDonation = new Donation(donor, charityCause, amount);

        if (donations.has(donor)) {
            donations.get(donor).add(newDonation);
        } else {
            ArrayList<Donation> donationArrayList = new ArrayList<>();
            donationArrayList.add(newDonation);
            donations.add(donor, donationArrayList);
        }
    }
    
    public void setDonation(Donor donor, Donation donation, int index){
        if(donations.has(donor)){
            donations.get(donor).remove(index);
            donations.get(donor).add(donation);
        }
    }
    
    public boolean setDonationDonor(Donor originDonor, Donor newDonor, Donation donation, int index){
        if(donations.has(originDonor)){
            donations.get(originDonor).remove(index);
        }else{
            return false;
        }
        if (donations.has(newDonor)) {
            donations.get(newDonor).add(donation);
        } else {
            ArrayList<Donation> donationArrayList = new ArrayList<>();
            donationArrayList.add(donation);
            donations.add(newDonor, donationArrayList);
        }
        return true;
    }
    

    public ArrayMap<Donor, ArrayList<Donation>> getDonations() {
        return donations;
    }
    
    public ArrayList<Donation> getDonorDonation(Donor donor){
        if (donations.has(donor)) {
            return donations.get(donor);
        }
        return null;
    }
    
    public ArrayMap<Donor, ArrayList<Donation>> getMostRecentDonor(){
        int highest = 0;
        Donor donor= null;
        for(int i = 0; i < donors.size(); i++){
            if(donations.get(donors.getValue(i)).size() > highest){
                highest = donations.get(donors.getValue(i)).size();
                donor = donors.getValue(i);
            }
        }
        
        ArrayMap<Donor, ArrayList<Donation>> mostRecentDonor = new ArrayMap();
        mostRecentDonor.add(donor, donations.get(donor));
        return mostRecentDonor;
    }

}
