/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Tan Jee Schuan
 */
public class Donation implements Comparable<Donation>{
    private static int currentDonationId = 1;
    private int donationId;
    
    private Donor donor;
    private CharityCause cause;
    private Double amount;

    public Donation(Donor donor, CharityCause cause, Double amount) {
        donationId = currentDonationId;
        
        this.donor = donor;
        this.cause = cause;
        this.amount = amount;
        
        currentDonationId++;
    }
    
    @Override
    public int compareTo(Donation o) {
        return this.donationId - o.donationId;
    }
}
