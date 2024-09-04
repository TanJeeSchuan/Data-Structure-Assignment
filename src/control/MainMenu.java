/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.MainUI;

/**
 *
 * @author Tan Jee Schuan
 */
public class MainMenu {
    private MainUI mainMenuUI;
    private CharityCauseMaintainanceControl charityCauseMaintainanceControl;
    private DonationManagementControl donationManagementControl;
    private DonorSystemControl donorSystemControl;
    private EventSystemControl eventSystemControl;
    
    public MainMenu(){
        mainMenuUI = new MainUI();
        charityCauseMaintainanceControl = new CharityCauseMaintainanceControl();
        donationManagementControl = new DonationManagementControl();
        donorSystemControl = new DonorSystemControl();
        eventSystemControl = new EventSystemControl();
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
                    donorSystemControl.startUI();
                    break;
                case 2:
                    break;
                case 3:
                    donationManagementControl.startUI();
                    break;
                case 4:
                    charityCauseMaintainanceControl.startUI();
                    break;
                case 5:
                    eventSystemControl.startUI();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}
