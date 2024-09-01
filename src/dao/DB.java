/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Tan Jee Schuan
 */
public class DB {
    private static DB instance = null;
    
    public CharityCauseDAO charityCauseDAO;
    public DoneeDAO doneeDAO;
    public DonorDAO donorDAO;
    public EventDAO eventDAO;
    
    private DB(){
        charityCauseDAO = new CharityCauseDAO();
        doneeDAO = new DoneeDAO();
        donorDAO = new DonorDAO();
        eventDAO = new EventDAO();
    }
    
    public static DB getInstance(){
        if(instance == null)
            instance = new DB();
        
        return instance;
    }
}
