/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.interfaces.List;
import adt.SortedArrayList;

/**
 *
 * @author Tan Jee Schuan
 */
public class CharityCause implements Comparable<CharityCause>{
    public static int currentCauseId = 1;
    public int causeId;
    public String causeName;
    public SortedArrayList<Donee> donees;
    //refactor into ADT
    //orderedList
    
    public CharityCause(String causeName){
        this.causeId = currentCauseId;
        this.causeName = causeName;
        
        donees = new SortedArrayList();
        
        currentCauseId++;
    }
    
    public CharityCause(String causeName, List<Donee> doneeList){
        this.causeId = currentCauseId;
        this.causeName = causeName;
        
        donees = new SortedArrayList(doneeList.toArray());
        currentCauseId++;
    }

    @Override
    public int compareTo(CharityCause o) {
        return this.causeId - o.causeId;
    }
}

