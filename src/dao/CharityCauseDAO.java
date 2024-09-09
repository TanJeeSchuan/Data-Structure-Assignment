package dao;

import adt.ArrayList;
import adt.LinkedSet;
import entity.CharityCause;
import entity.Donee;
import java.util.Iterator;

/**
 *
 * @author Tan Jee Schuan
 */
public class CharityCauseDAO {
    private ArrayList<CharityCause> charityCauseList;
    
    public CharityCauseDAO(DoneeDAO doneeDAO){
        charityCauseList = new ArrayList<>();
        
        LinkedSet<Donee> doneeSet = doneeDAO.getDonees();
        Iterator itr = doneeSet.iterator();
        
        CharityCause tempCharityCause = 
                new CharityCause("Feeding the Homeless");
        tempCharityCause.donees.add((Donee) itr.next());
        tempCharityCause.donees.add((Donee) itr.next());
        charityCauseList.add(tempCharityCause);
        
        tempCharityCause = new CharityCause("Supporting Education");
        tempCharityCause.donees.add((Donee) itr.next());
        tempCharityCause.donees.add((Donee) itr.next());
        charityCauseList.add(tempCharityCause);
        
        tempCharityCause = new CharityCause("Animal Welfare");
        tempCharityCause.donees.add((Donee) itr.next());
        tempCharityCause.donees.add((Donee) itr.next());
        charityCauseList.add(tempCharityCause);
        
        tempCharityCause = new CharityCause("Environmental Conservation");
        tempCharityCause.donees.add((Donee) itr.next());
        tempCharityCause.donees.add((Donee) itr.next());
        charityCauseList.add(tempCharityCause);
        
        tempCharityCause = new CharityCause("Disaster Relief");
        tempCharityCause.donees.add((Donee) itr.next());
        tempCharityCause.donees.add((Donee) itr.next());
        charityCauseList.add(tempCharityCause);
    }
    
    public void addCharityCause(CharityCause charityCause){
        charityCauseList.add(charityCause);
    }
    
    public ArrayList<CharityCause> getCharityCauses(){
        return charityCauseList;
    }

    public void removeCause(CharityCause selectedCause) {
        charityCauseList.remove(selectedCause);
    }
}
