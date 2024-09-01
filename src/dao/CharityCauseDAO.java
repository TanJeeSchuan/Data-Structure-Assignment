/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.ArrayList;
import adt.LinkedSet;
import entity.CharityCause;
import entity.Donee;

/**
 *
 * @author Tan Jee Schuan
 */
public class CharityCauseDAO {
    private ArrayList<CharityCause> charityCauseList;
    
    public CharityCauseDAO(){
        charityCauseList = new ArrayList<CharityCause>();
        DoneeDAO doneeDAO = new DoneeDAO();
        
        LinkedSet<Donee> doneeSet = doneeDAO.getDonees();        
        
        CharityCause tempCharityCause = new CharityCause("Feeding the Homeless");
        tempCharityCause.donees.add(doneeSet.iterator().next());
        tempCharityCause.donees.add(doneeSet.iterator().next());
        charityCauseList.add(tempCharityCause);
        
        tempCharityCause = new CharityCause("Supporting Education");
        tempCharityCause.donees.add(doneeSet.iterator().next());
        tempCharityCause.donees.add(doneeSet.iterator().next());
        charityCauseList.add(tempCharityCause);
        
        tempCharityCause = new CharityCause("Animal Welfare");
        tempCharityCause.donees.add(doneeSet.iterator().next());
        tempCharityCause.donees.add(doneeSet.iterator().next());
        charityCauseList.add(tempCharityCause);
        
        tempCharityCause = new CharityCause("Environmental Conservation");
        tempCharityCause.donees.add(doneeSet.iterator().next());
        tempCharityCause.donees.add(doneeSet.iterator().next());
        charityCauseList.add(tempCharityCause);
        
        tempCharityCause = new CharityCause("Disaster Relief");
        tempCharityCause.donees.add(doneeSet.iterator().next());
        tempCharityCause.donees.add(doneeSet.iterator().next());
        charityCauseList.add(tempCharityCause);
    }
    
    public void addCharityCause(CharityCause charityCause){
        charityCauseList.add(charityCause);
    }
    
    public ArrayList<CharityCause> getCharityCauses(){
        return charityCauseList;
    }
}
