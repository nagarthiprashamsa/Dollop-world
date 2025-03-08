package cbp;

public class Donor {
    private String name;
    private String email;
    private String contactNumber;
    private String donorId;

    public Donor(String name, String email, String contactNumber, String donorId) {
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.donorId = donorId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getDonorId() {
        return donorId;
    }
}