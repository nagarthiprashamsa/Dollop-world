package cbp;

public class Donation {
    private String donationId;
    private String donorType;
    private String orphanageId;
    private String item;
    private int quantity;

    public Donation(String donationId, String donorType, String orphanageId, String item, int quantity) {
        this.donationId = donationId;
        this.donorType = donorType;
        this.orphanageId = orphanageId;
        this.item = item;
        this.quantity = quantity;
    }

    public String getDonationId() {
        return donationId;
    }

    public String getDonorType() {
        return donorType;
    }

    public String getOrphanageId() {
        return orphanageId;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}