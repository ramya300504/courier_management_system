package Entities;
import java.util.Date;

public class Courier {

    private int courierID;
    private String senderName;
    private String  senderAddress;
    private String receiverName;
    private String receiverAddress;
    private double weight;
    private String status;
    private static String trackingNumber;
    private Date deliveryDate;
    private static int trackingcount=1354784974;

    public Courier()
    {}

    public Courier(int courierID, String senderName, String senderAddress,
                   String receiverName, String receiverAddress, double weight,
                   String status, String trackingNumber, Date deliveryDate) {
        this.courierID = courierID;
        this.senderName = senderName;
        this.senderAddress = senderAddress;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.weight = weight;
        this.status = status;
        this.deliveryDate = deliveryDate;

        trackingcount++;
        this.trackingNumber="TN"+trackingcount;
    }

    public int getCourierID() {
        return courierID;
    }

    public void setCourierID(int courierID) {
        this.courierID = courierID;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    @Override
    public String toString()
    {
        return courierID + ", " + senderName + ", " + senderAddress + ", " + receiverName +
                ", " + receiverAddress + ", " + weight + ", " + status + ", " + trackingNumber +
                ", " + deliveryDate;
    }
}
