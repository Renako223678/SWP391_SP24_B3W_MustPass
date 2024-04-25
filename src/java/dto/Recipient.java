package dto;

public class Recipient {
    private int recipientID;
    private String destAddress;
    private String recipientName;
    private String phoneNumber;
    private int status;
    private int userID;

    public Recipient() {
    }

    public Recipient(int recipientID, String destAddress, String recipientName, String phoneNumber, int status,
            int userID) {
        this.recipientID = recipientID;
        this.destAddress = destAddress;
        this.recipientName = recipientName;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.userID = userID;
    }

    public Recipient(String destAddress, String recipientName, String phoneNumber, int status, int userID) {
        this.destAddress = destAddress;
        this.recipientName = recipientName;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.userID = userID;
    }

    public int getRecipientID() {
        return recipientID;
    }

    public void setRecipientID(int recipientID) {
        this.recipientID = recipientID;
    }

    public String getDestAddress() {
        return destAddress;
    }

    public void setDestAddress(String destAddress) {
        this.destAddress = destAddress;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

}
