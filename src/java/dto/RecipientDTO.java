package dto;

public class RecipientDTO {
    private long recipientId;
    private String destinationAddress;
    private String recipientName;
    private String phoneNumber;
    private long userId;

    public RecipientDTO() {
    }

    public RecipientDTO(long recipientId, String destinationAddress, String recipientName, String phoneNumber, long userId) {
        this.recipientId = recipientId;
        this.destinationAddress = destinationAddress;
        this.recipientName = recipientName;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
    }

    public long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(long recipientId) {
        this.recipientId = recipientId;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "RecipientId: " + recipientId + "\nDestination Address: " + destinationAddress 
                + "\nRecipient Name: " + recipientName + "\nPhone Number: " + phoneNumber 
                + "\nUserId: " + userId;
    }
    
}
