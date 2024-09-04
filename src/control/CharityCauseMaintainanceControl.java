/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.ArrayList;
import boundary.CharityCauseMaintainanceUI;
import dao.DB;
import entity.CharityCause;

/**
 *
 * @author Tan Jee Schuan
 */
public class CharityCauseMaintainanceControl {
    private CharityCauseMaintainanceUI charityCauseMaintainanceUI;
    private DB db = DB.getInstance();
    
    public CharityCauseMaintainanceControl(){
        charityCauseMaintainanceUI = new CharityCauseMaintainanceUI();
    }
    
    public void startUI(){
        boolean isEnd = false;
        
        while(!isEnd){
            isEnd = false;
        
            charityCauseMaintainanceUI.showUI();
            int choice = charityCauseMaintainanceUI.getSelection();
    
            switch (choice) {
                case 0:
                    isEnd = true;
                    break;
                case 1:
                    addNewCause();
                    break;
                case 2:
                    modifyCause();
                    break;
                case 3:
                    displayAllCauses();
                    break;
                case 4:
                    deleteCause();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    
    private void addNewCause() {
        charityCauseMaintainanceUI.showAddCharityUI();
        String causeName = charityCauseMaintainanceUI.getCauseDetails();
        DB.getInstance().charityCauseDAO.addCharityCause(new CharityCause(causeName));
    }
    
    private void modifyCause(){
        //show selection
        
        ArrayList<CharityCause> causes = db.charityCauseDAO.getCharityCauses();
        charityCauseMaintainanceUI.showCharityCauseHeader();
//        for(CharityCause cause: causes){
//            charityCauseMaintainanceUI.showCharityCauseSelection("%-10d%-30s%-20s".formatted(cause.causeId, cause.causeName, cause.donees.size()));
//        }
        
        int selectedIndex = charityCauseMaintainanceUI.getCauseSelection();
        CharityCause selectedCause = (CharityCause)causes.get(selectedIndex);
        charityCauseMaintainanceUI.showModificationUI(selectedCause.toString());
        
        int choice = charityCauseMaintainanceUI.inputModificationChoice();
        switch (choice) {
            case 0:
                break;
            case 1:
                modifyCauseName(selectedCause);
                break;
            case 2:
                modifyCauseDonees(selectedCause);
                break;
            default:
                throw new AssertionError();
        }
        
    }
    
    private void displayAllCauses(){
        charityCauseMaintainanceUI.showCharityCauseDonees(db.charityCauseDAO.getCharityCauses());
    }

    private void modifyCauseName(CharityCause selectedCause) {
        selectedCause.causeName = charityCauseMaintainanceUI.getNewCauseName();
    }

    private void modifyCauseDonees(CharityCause selectedCause) {
        
        charityCauseMaintainanceUI.showCharityCauseDonees(selectedCause.donees);
        
        int choice = charityCauseMaintainanceUI.getAddOrRemoveDonee();
        switch (choice) {
            case 0:
                break;
            case 1:
                //add donor
                charityCauseMaintainanceUI.showDonees(db.doneeDAO.getDonees());
                break;
            case 2:
                charityCauseMaintainanceUI.showCharityCauseDonees(selectedCause.donees);
                int removedIndex = charityCauseMaintainanceUI.getRemovedDoneeIndex();
                selectedCause.donees.remove(selectedCause.donees.get(removedIndex));
                break;
            default:
                throw new AssertionError();
        }

    }

    private void deleteCause() {
        ArrayList<CharityCause> causes = db.charityCauseDAO.getCharityCauses();
        charityCauseMaintainanceUI.showCharityCauseHeader();
        for(CharityCause cause: causes){
            charityCauseMaintainanceUI.showCharityCauseSelection("%-10d%-30s%-20s".formatted(cause.causeId, cause.causeName, cause.donees.size()));
        }
        
        int selectedIndex = charityCauseMaintainanceUI.getCauseSelection();
        CharityCause selectedCause = (CharityCause)causes.get(selectedIndex);
        
        ((CharityCause)db.charityCauseDAO.getCharityCauses().get(selectedIndex)).donees.remove(db.charityCauseDAO.getCharityCauses().get(selectedIndex));
        charityCauseMaintainanceUI.showCharityCauseSelection(selectedCause.toString() + " Deleted");
    }
}
