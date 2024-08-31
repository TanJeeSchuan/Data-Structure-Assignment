/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import adt.LinkedSet;
import adt.interfaces.SetInterface;
import entity.DonationManagement;
import entity.Donor;
import entity.CharityCause;
import entity.Donation;

/**
 *
 * @author xuanx
 */
public class DonMngTest {

    SetInterface<Donor> donors = new LinkedSet<>();

    DonationManagement dm = new DonationManagement();

    public DonMngTest() {
        addDonation();
    }

    public void addDonation() {
        Donor donor = new Donor("Eric", "E@e.ee");
        CharityCause cc = new CharityCause("cause");
        Donor donor2 = new Donor("Ferry", "F@e.ee");
        CharityCause cc2 = new CharityCause("Fcause");
        Donor donor3 = new Donor("George", "G@e.ee");
        CharityCause cc3 = new CharityCause("Gcause");

        donors.add(donor);
        donors.add(donor2);
        donors.add(donor3);

        dm.addDonation(donor, cc, 1);
        dm.addDonation(donor, cc, 2);
        dm.addDonation(donor, cc, 3);

        // dm.addDonation(donor, cc, 1);
        dm.addDonation(donor2, cc2, 2);
        dm.addDonation(donor3, cc3, 3);

        System.out.println(dm.getAllDonations());              
        System.out.println();
        System.out.println(dm.getDonationString(dm.getMostRecentDonor()));          
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Update");
        System.out.println();
        
        Donation donation = new Donation(donor, cc, 4.0);
        
        Donation type = (Donation)dm.getDonorDonation(donor).get(0);
        type.setAmount(100.0);
        System.out.println(dm.getDonorDonation(donor).get(0));
        System.out.println(dm.getAllDonations());
    }

//    public void updateDonation() {
//        
//    }

    public static void main(String[] args) {
        DonMngTest t = new DonMngTest();
    }
}
