/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.ArrayList;
import entity.CharityCause;
import entity.Donee;

/**
 *
 * @author Tan Jee Schuan
 */
public class CharityCauseDAO {
    private ArrayList<CharityCause> charityCauseList;
    
    public CharityCauseDAO(){
        charityCauseList = new ArrayList<>();
        DoneeDAO doneeDAO = new DoneeDAO();
        
        ArrayList<Donee> doneeList = new ArrayList<Donee>();
        doneeList.add(doneeDAO.getDonees());
                ;
        charityCauseList.add(new CharityCause("Feeding the Homeless"),);
        charityCauseList.add(new CharityCause("Supporting Education"));
        charityCauseList.add(new CharityCause("Animal Welfare"));
        charityCauseList.add(new CharityCause("Environmental Conservation"));
        charityCauseList.add(new CharityCause("Disaster Relief"));
    }
}
