package entity;

/**
 *
 * @author Tan Jia Ning
 */
public class Donor implements Comparable<Donor>{
    private static int currentDonorId = 1;
    private int donorId;
    private String name;
    private String email;
    //etc
    //dict

    public Donor(String name, String email) {
        this.donorId = currentDonorId;
        this.name = name;
        this.email = email;
        
        currentDonorId++;
    }

    public int getDonorId() {
        return donorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Donor))
            return false;
        return this.name.equals(((Donor)o).name);
    }
    
    @Override
    public int compareTo(Donor o) {
        return this.donorId - o.donorId;
    }
    
    @Override
    public String toString(){
        return "Donor Id: " + donorId + "\nDonor name: " + name + "\nDonor Email: " + email;
    }
}
