/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.CharityCauseMaintainanceUI;
import dao.DB;

/**
 *
 * @author Tan Jee Schuan
 */
public class CharityCauseMaintainanceControl {
    private CharityCauseMaintainanceUI charityCauseMaintainanceUI;
    
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
                    break;
                case 2:
                    break;
                case 3:
                    displayAllCauses();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    
    public void displayAllCauses(){
        System.out.println(DB.getInstance().charityCauseDAO.getCharityCauses());
    }
}
