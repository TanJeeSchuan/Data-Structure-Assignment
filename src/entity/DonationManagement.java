package entity;

import adt.ArrayMap;
import adt.ArrayList;
import adt.FixedSizedLinkedQueue;
import adt.LinkedQueue;

/**
 *
 * @author Tan Jee Schuan
 */
public class DonationManagement {

//    LinkedSet<Donor> donors;
    //fast lookup
    public ArrayMap<Donor, ArrayList<Donation>> donations;
    //recent Donations
    LinkedQueue<Donation> recentDonations;
    
    //todo

    //adt<event, adt<donor, donation>>
    //adt<cause, adt<donor, donation>>
    //set of donors
    //most recent donor //CircularFifoQueue
    //queue
    //eg list(dict{cause, dict{donor, float donation}})
    public DonationManagement() {
//        donors = new LinkedSet<>();
        recentDonations = new FixedSizedLinkedQueue(5);
        donations = new ArrayMap();
        //get all donors
        // ------------------------Testing--------------------
//        Donor donor1 = new Donor("Alice", "A@a.aa");
//        Donor donor2 = new Donor("Bil", "B@a.aa");
//        Donor donor3 = new Donor("Chris", "C@a.aa");
//        Donor donor4 = new Donor("David", "D@a.aa");
//
//        donors.add(donor1);
//        donors.add(donor2);
//        donors.add(donor3);
//        donors.add(donor4);

    }
    
    public DonationManagement(ArrayMap donations) {
        recentDonations = new FixedSizedLinkedQueue(5);
        this.donations = donations;
    }

    //add donation
    public void addDonation(Donor donor, CharityCause charityCause, double amount) {
        Donation newDonation = new Donation(donor, charityCause, amount);

        recentDonations.enqueue(newDonation);
        
        if (!donations.isEmpty() && donations.has(donor)) {
            donations.get(donor).add(newDonation);

        } else {
            ArrayList<Donation> donationArrayList = new ArrayList<>();
            donationArrayList.add(newDonation);
            donations.add(donor, donationArrayList);

        }

    }

    public void setDonationDonor(Donor originDonor, Donor newDonor, Donation donation) {
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
