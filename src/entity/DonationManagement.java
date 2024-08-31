/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.ArrayMap;
import adt.LinkedSet;
import adt.ArrayList;
import adt.interfaces.List;
import adt.interfaces.MapInterface;

/**
 *
 * @author Tan Jee Schuan
 */
public class DonationManagement {

    LinkedSet<Donor> donors;
    //fast lookup
    MapInterface<Donor, ArrayList<Donation>> donations = new ArrayMap<>();

    //adt<event, adt<donor, donation>>
    //adt<cause, adt<donor, donation>>
    //set of donors
    //most recent donor //CircularFifoQueue
    //queue
    //eg list(dict{cause, dict{donor, float donation}})
    public DonationManagement() {
        donors = new LinkedSet<>();

        //get all donors
        // ------------------------Testing--------------------
        Donor donor1 = new Donor("Alice", "A@a.aa");
        Donor donor2 = new Donor("Bil", "B@a.aa");
        Donor donor3 = new Donor("Chris", "C@a.aa");
        Donor donor4 = new Donor("David", "D@a.aa");

        donors.add(donor1);
        donors.add(donor2);
        donors.add(donor3);
        donors.add(donor4);

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

    public void setDonationDonor(Donor originDonor, Donor newDonor, Donation donation, int index) {
        donations.get(originDonor).remove(index);

        if (donations.has(newDonor)) {
            donations.get(newDonor).add(donation);
        } else {
            ArrayList<Donation> donationArrayList = new ArrayList<>();
            donationArrayList.add(donation);
            donations.add(newDonor, donationArrayList);
        }

    }

    public void removeDonation(Donor donor, Donation donation, int index) {
        if (donations.has(donor)) {
            donations.get(donor).remove(index);
        }
    }

    public String getAllDonations() {
        String mapToString = "";
        for (int i = 0; i < donations.size(); i++) {
            Donor donor = donations.getKey(i);
            mapToString += getDonationString(donor);
        }
        return mapToString;
    }

    public ArrayList<Donation> getDonorDonation(Donor donor) {
        if (donations.has(donor)) {
            return donations.get(donor);
        }
        return null;
    }

//    public ArrayList<Donor> getDonors(){
//        ArrayList<Donor> donationDonors = new ArrayList<>();
//    }
    public Donor getMostRecentDonor() {
        int highest = 0;
        Donor donor = null;

        for (int i = 0; i < donations.size(); i++) {
            if (donations.get(donations.getKey(i)).size() > highest) {
                donor = donations.getKey(i);
                highest = donations.get(donor).size();
            }
        }

        return donor;
    }

    public String getDonationString(Donor donor) {
        String arrString = "";
        arrString += "Donor\n";
        arrString += "------\n";
        arrString += donor;

        arrString += "\nDonation Detail\n";
        arrString += "--------------------";
        arrString += getDonationArrayString(donor);
        return arrString;
    }

    public String getDonationArrayString(Donor donor) {
        String arrString = "";

        ArrayList<Donation> donationArray = donations.get(donor);

        for (int j = 0; j < donationArray.size(); j++) {
            arrString += donationArray.get(j);
            arrString += "\n";
        }
        return arrString;
    }

}
