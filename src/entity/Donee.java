/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Tan Jee Schuan
 */
public class Donee implements Comparable<Donee>{
    private static int currentDoneeId = 1;
    private int doneeId;
    private String name;
    private String contactNumber;
    private String address;

    public Donee(String name, String contactNumber, String address) {
        this.doneeId = currentDoneeId;
        this.name = name;
        this.contactNumber = contactNumber;
        this.address = address;
        
        currentDoneeId++;
    }

    public int getDoneeId() {
        return doneeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public int compareTo(Donee o) {
        return this.doneeId - o.doneeId;
    }
}
