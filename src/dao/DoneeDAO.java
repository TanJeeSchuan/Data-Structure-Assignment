/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.ArraySet;
import adt.LinkedSet;
import entity.Donee;

/**
 *
 * @author Tan Jee Schuan
 */
public class DoneeDAO {
    private LinkedSet<Donee> doneeSet;
    
    public DoneeDAO(){
        doneeSet = new LinkedSet();
        //populatea set
        
        doneeSet.add(new Donee("John Williams", "4859137204", "523 Pine St, Georgetown"));
        doneeSet.add(new Donee("Emily Brown", "9723401587", "192 Oak St, Riverside"));
        doneeSet.add(new Donee("Alex Smith", "6341072984", "312 Maple St, Madison"));
        doneeSet.add(new Donee("Katie Davis", "8235910642", "89 Cedar St, Greenville"));
        doneeSet.add(new Donee("Chris Johnson", "5164793021", "47 Elm St, Fairview"));
        doneeSet.add(new Donee("Jane Jones", "7810543926", "273 Birch St, Springfield"));
        doneeSet.add(new Donee("Alex Williams", "2456109387", "652 Cedar St, Riverside"));
        doneeSet.add(new Donee("Katie Smith", "9028417653", "830 Maple St, Georgetown"));
        doneeSet.add(new Donee("Emily Davis", "4319085723", "310 Oak St, Fairview"));
        doneeSet.add(new Donee("Chris Brown", "5692478130", "145 Pine St, Madison"));
    }
    
    public LinkedSet getDonees(){
        return doneeSet;
    }
    
        public void addDonee(Donee newDonee) {
        doneeSet.add(newDonee);
    }

    public void removeDonee(Donee selectedDonee) {
        doneeSet.remove(selectedDonee);
    }
}
