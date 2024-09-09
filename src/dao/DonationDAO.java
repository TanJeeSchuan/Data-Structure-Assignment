package dao;

import adt.ArrayList;
import adt.ArrayMap;
import adt.LinkedSet;
import entity.CharityCause;
import entity.Donation;
import entity.Donor;
import java.util.Iterator;

/**
 *
 * @author Tan Jee Schuan
 */
public class DonationDAO {
    public ArrayMap<Donor, ArrayList<Donation>> donations;
    
    public DonationDAO(DonorDAO donorDAO, CharityCauseDAO charityCauseDAO){
        donations = new ArrayMap();
        
        LinkedSet<Donor> donorList = donorDAO.getDonors();
        ArrayList<CharityCause> charityCauses = charityCauseDAO.
                getCharityCauses();
        
        Iterator donItr = donorList.iterator();
        Iterator charityItr = charityCauses.iterator();
        
        ArrayList<Donation> newDonations = new ArrayList<>();
        Donor currentDonor = (Donor)donItr.next();
        CharityCause currentCharityCause = (CharityCause)charityItr.next();
        newDonations.add(new Donation(currentDonor, currentCharityCause, 
                150.00));
        newDonations.add(new Donation(currentDonor, currentCharityCause, 
                750.00));
        donations.add(currentDonor, newDonations);
        
        newDonations = new ArrayList<>();
        currentDonor = (Donor)donItr.next();
//        currentCharityCause = (CharityCause)charityItr.next();
        newDonations.add(new Donation(currentDonor, currentCharityCause, 
                70.00));
        newDonations.add(new Donation(currentDonor, currentCharityCause, 
                570.00));
        donations.add(currentDonor, newDonations);
        
        newDonations = new ArrayList<>();
        currentDonor = (Donor)donItr.next();
        currentCharityCause = (CharityCause)charityItr.next();
        newDonations.add(new Donation(currentDonor, currentCharityCause, 
                70.00));
        newDonations.add(new Donation(currentDonor, currentCharityCause, 
                570.00));
        donations.add(currentDonor, newDonations);
        
        newDonations = new ArrayList<>();
        currentDonor = (Donor)donItr.next();
//        currentCharityCause = (CharityCause)charityItr.next();
        newDonations.add(new Donation(currentDonor, currentCharityCause, 
                70.00));
        newDonations.add(new Donation(currentDonor, currentCharityCause, 
                570.00));
        donations.add(currentDonor, newDonations);
        
        newDonations = new ArrayList<>();
        currentDonor = (Donor)donItr.next();
        currentCharityCause = (CharityCause)charityItr.next();
        newDonations.add(new Donation(currentDonor, currentCharityCause, 
                70.00));
        newDonations.add(new Donation(currentDonor, currentCharityCause, 
                570.00));
        donations.add(currentDonor, newDonations);
        
        newDonations = new ArrayList<>();
        currentDonor = (Donor)donItr.next();
//        currentCharityCause = (CharityCause)charityItr.next();
        newDonations.add(new Donation(currentDonor, currentCharityCause, 
                70.00));
        newDonations.add(new Donation(currentDonor, currentCharityCause, 
                570.00));
        donations.add(currentDonor, newDonations);
        
        newDonations = new ArrayList<>();
        currentDonor = (Donor)donItr.next();
        currentCharityCause = (CharityCause)charityItr.next();
        newDonations.add(new Donation(currentDonor, currentCharityCause, 
                70.00));
        newDonations.add(new Donation(currentDonor, currentCharityCause, 
                570.00));
        donations.add(currentDonor, newDonations);
        
        newDonations = new ArrayList<>();
        currentDonor = (Donor)donItr.next();
//        currentCharityCause = (CharityCause)charityItr.next();
        newDonations.add(new Donation(currentDonor, currentCharityCause, 
                70.00));
        newDonations.add(new Donation(currentDonor, currentCharityCause, 
                570.00));
        donations.add(currentDonor, newDonations);
        
        newDonations = new ArrayList<>();
        currentDonor = (Donor)donItr.next();
//        currentCharityCause = (CharityCause)charityItr.next();
        newDonations.add(new Donation(currentDonor, currentCharityCause, 
                70.00));
        newDonations.add(new Donation(currentDonor, currentCharityCause, 
                570.00));
        donations.add(currentDonor, newDonations);
        
        newDonations = new ArrayList<>();
        currentDonor = (Donor)donItr.next();
//        currentCharityCause = (CharityCause)charityItr.next();
        newDonations.add(new Donation(currentDonor, currentCharityCause, 
                70.00));
        newDonations.add(new Donation(currentDonor, currentCharityCause, 
                570.00));
        donations.add(currentDonor, newDonations);
    }
    
    public ArrayMap<Donor, ArrayList<Donation>> getDonations(){
        return donations;
    }
    
    public void syncDonations(ArrayMap<Donor, ArrayList<Donation>> 
            newArrayMap){
        this.donations = newArrayMap;
    }
}
