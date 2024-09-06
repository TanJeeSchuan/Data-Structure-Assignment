/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.LinkedSet;
import entity.Donor;

/**
 *
 * @author Tan Jee Schuan
 */
public class DonorDAO {
    private LinkedSet<Donor> donorSet;
    
    public DonorDAO(){
        donorSet = new LinkedSet();
        //populatea set
        donorSet.add(new Donor("John Smith", "john.smith@example.com"));
        donorSet.add(new Donor("Emily Johnson", "emily.johnson@example.com"));
        donorSet.add(new Donor("Michael Brown", "michael.brown@example.com"));
        donorSet.add(new Donor("Sarah Davis", "sarah.davis@example.com"));
        donorSet.add(new Donor("David Wilson", "david.wilson@example.com"));
        donorSet.add(new Donor("Jessica Moore", "jessica.moore@example.com"));
        donorSet.add(new Donor("Daniel Taylor", "daniel.taylor@example.com"));
        donorSet.add(new Donor("Laura Anderson", "laura.anderson@example.com"));
        donorSet.add(new Donor("James Thomas", "james.thomas@example.com"));
        donorSet.add(new Donor("Olivia Martinez", "olivia.martinez@example.com"));
    }
    
    public LinkedSet getDonors(){
        return donorSet;
    }

    public void addDonor(Donor newDonor) {
        donorSet.add(newDonor);
    }

    public void removeDonor(Donor selectedDonor) {
        donorSet.remove(selectedDonor);
    }
}
