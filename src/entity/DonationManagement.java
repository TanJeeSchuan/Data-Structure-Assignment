package entity;

import adt.ArrayMap;
import adt.ArrayList;
import adt.FixedSizedLinkedQueue;
import adt.LinkedQueue;

/**
 *
 * @author Liau Xiao Xuan
 */
public class DonationManagement {

    public ArrayMap<Donor, ArrayList<Donation>> donations;
    //recent Donations
    LinkedQueue<Donation> recentDonations;
    public DonationManagement() {
        recentDonations = new FixedSizedLinkedQueue(5);
        donations = new ArrayMap();
    }
    
    public DonationManagement(ArrayMap donations) {
        recentDonations = new FixedSizedLinkedQueue(5);
        this.donations = donations;
    }

    //add donation
    public void addDonation(Donor donor, CharityCause charityCause, 
            double amount) {
        Donation newDonation = 
                new Donation(donor, charityCause, amount);

        recentDonations.enqueue(newDonation);
        
        if (!donations.isEmpty() && donations.has(donor)) {
            donations.get(donor).add(newDonation);

        } else {
            ArrayList<Donation> donationArrayList = new ArrayList<>();
            donationArrayList.add(newDonation);
            donations.add(donor, donationArrayList);

        }

    }

    // for the situation: change the donor of the donation
    public void setDonationDonor(Donor originDonor, Donor newDonor, 
            Donation donation) {
        donations.get(originDonor).remove(donation);

        if (donations.has(newDonor)) {
            donations.get(newDonor).add(donation);
        } else {
            ArrayList<Donation> donationArrayList = new ArrayList<>();
            donationArrayList.add(donation);
            donations.add(newDonor, donationArrayList);
        }

    }

    public ArrayMap<Donor, ArrayList<Donation>> getAllDonations() {
        return donations;
    }

    // get all the donations of the donor
    public ArrayList<Donation> getDonorDonation(Donor donor) {
        if (donations.has(donor)) {
            return donations.get(donor);
        }
        return null;
    }

    public LinkedQueue<Donation> getRecentDonors() {
        return recentDonations;
    }
    
    
}
