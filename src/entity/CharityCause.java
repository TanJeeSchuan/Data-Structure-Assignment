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
    public static int currentCauseId = 0;
    public int causeId;
    public String causeName;
    public SortedArrayList<Donee> donees;
    //refactor into ADT
    //orderedList
    
    public CharityCause(String causeName){
        this.causeId = currentCauseId;
        this.causeName = causeName;
        
        donees = new SortedArrayList<Donee>();
        
        currentCauseId++;
    }
    
    public CharityCause(String causeName, List<Donee> doneeList){
        this.causeId = currentCauseId;
        this.causeName = causeName;
        
        donees = new SortedArrayList(doneeList.toArray());
        currentCauseId++;
    }

    public static int getCurrentCauseId() {
        return currentCauseId;
    }

    public static void setCurrentCauseId(int currentCauseId) {
        CharityCause.currentCauseId = currentCauseId;
    }

    public String getCauseName() {
        return causeName;
    }

    public void setCauseName(String causeName) {
        this.causeName = causeName;
    }

    public SortedArrayList<Donee> getDonees() {
        return donees;
    }

    public void setDonees(SortedArrayList<Donee> donees) {
        this.donees = donees;
    }
    
    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }

        if (!(o instanceof CharityCause)) {
            return false;
        }
         
        CharityCause c = (CharityCause) o;
        
        return c.causeId == this.causeId;
    }

    @Override
    public int compareTo(CharityCause o) {
        return this.causeId - o.causeId;
    }
    
    @Override
    public String toString(){
        return ""+ causeId + " " + causeName;
    }
}

