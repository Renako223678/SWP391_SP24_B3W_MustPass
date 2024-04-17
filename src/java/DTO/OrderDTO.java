package dto;

import java.math.BigDecimal;
import java.sql.Date;

public class OrderDTO {
    private long orderId;
    private String description;
    private Date orderDate;
    private BigDecimal shipFee;
    private int usedLotusBub;
    private BigDecimal totalPrice;
    private BigDecimal finalPrice;
    private byte status;
    private long userId;
    private long recipientId;

    public OrderDTO() {
    }

    public OrderDTO(long orderId, String description, Date orderDate, BigDecimal shipFee, int usedLotusBub, BigDecimal totalPrice, BigDecimal finalPrice, byte status, long userId, long recipientId) {
        this.orderId = orderId;
        this.description = description;
        this.orderDate = orderDate;
        this.shipFee = shipFee;
        this.usedLotusBub = usedLotusBub;
        this.totalPrice = totalPrice;
        this.finalPrice = finalPrice;
        this.status = status;
        this.userId = userId;
        this.recipientId = recipientId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getShipFee() {
        return shipFee;
    }

    public void setShipFee(BigDecimal shipFee) {
        this.shipFee = shipFee;
    }

    public int getUsedLotusBub() {
        return usedLotusBub;
    }

    public void setUsedLotusBub(int usedLotusBub) {
        this.usedLotusBub = usedLotusBub;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(long recipientId) {
        this.recipientId = recipientId;
    }

    @Override
    public String toString() {
        return "OrderId: " + orderId + "\nDescription: " + description 
                + "\nOrder Date: " + orderDate + "\nShip Fee: " + shipFee 
                + "\nUsed Lotus Bub: " + usedLotusBub + "\nTotal Price: " + totalPrice 
                + "\nFinal Price: " + finalPrice + "\nStatus: " + status 
                + "\nUserId: " + userId + "\nRecipientId: " + recipientId;
    }
    
}
