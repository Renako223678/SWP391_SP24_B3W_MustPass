package dto;

import java.math.BigDecimal;

public class OrderDetailDTO {
    private long orderId;
    private long userId;
    private BigDecimal unitPrice;
    private int quantity;
    private BigDecimal totalPrice;
    private byte status;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(long orderId, long userId, BigDecimal unitPrice, int quantity, BigDecimal totalPrice, byte status) {
        this.orderId = orderId;
        this.userId = userId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderId: " + orderId + "\nUserId: " + userId + "\nUnitPrice: " + unitPrice 
                + "\nQuantity: " + quantity + "\nTotal Price=" + totalPrice + "\nStatus=" + status;
    }
    
}
