/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import adt.SortedArrayList;
import java.util.Comparator;

/**
 *
 * @author Tan Jee Schuan
 */
public class CharityCause {
    int causeId;
    String causeName;
    SortedArrayList<Donee> donee;
    //refactor into ADT
    //orderedList
    
    public CharityCause(){
        donee = new SortedArrayList<>(new Comparator<Donee>(){
            @Override
            public int compare(Donee o1, Donee o2) {
                return o1.doneeId - o2.doneeId;
            }
        });
    }
}

