package entity;

/**
 *
 * @author Soh Ching Liang
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
    public boolean equals(Object o ){
        return this.doneeId == ((Donee)o).doneeId;
    }
    
    @Override
    public int compareTo(Donee o) {
        return this.doneeId - o.doneeId;
    }
    
    @Override
    public String toString(){
        return "Donee Id: " + doneeId + ", Donee name: " + name + 
                ", Contact Number: " + contactNumber + ", Address: " 
                + address;
    }
}
