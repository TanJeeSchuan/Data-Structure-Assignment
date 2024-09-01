/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.MainInterface;

/**
 *
 * @author Tan Jee Schuan
 */
public class MainMenu {
    private MainInterface mainMenuUI;
    
    public MainMenu(){
        mainMenuUI = new MainInterface();
    }
    
    public void startUI(){
        while(!mainMenuUI.isEnd()){
            mainMenuUI.startUI();
        }
    }
}
