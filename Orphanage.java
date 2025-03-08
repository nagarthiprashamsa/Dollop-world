package cbp;

public class Orphanage {
    private String name;
    private String email;
    private String contactNumber;
    private String orphanageId;

    public Orphanage(String name, String email, String contactNumber, String orphanageId) {
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.orphanageId = orphanageId;
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

    public String getOrphanageId() {
        return orphanageId;
    }
}