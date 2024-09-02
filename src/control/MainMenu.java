/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.CharityCauseMaintainanceUI;
import boundary.DonationManagementUI;
import boundary.MainUI;

/**
 *
 * @author Tan Jee Schuan
 */
public class MainMenu {
    private MainUI mainMenuUI;
    private CharityCauseMaintainanceControl charityCauseMaintainanceControl;
    private DonationManagementUI donationManagementControl;
    
    public MainMenu(){
        mainMenuUI = new MainUI();
        charityCauseMaintainanceControl = new CharityCauseMaintainanceControl();
        donationManagementControl = new DonationManagementUI();
    }
    
    public void startUI(){
        boolean isEnd = false;
        
        while(!isEnd){
            isEnd = false;
        
            mainMenuUI.showUI();
            int choice = mainMenuUI.getSelection();
    
            switch (choice) {
                case 0:
                    isEnd = true;
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    donationManagementControl.donationManagementMenu();
                    break;
                case 4:
                    charityCauseMaintainanceControl.startUI();
                    break;
                case 5:
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}
