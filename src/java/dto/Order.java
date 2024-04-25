/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Timestamp;
import java.sql.Timestamp;

/**
 *
 * @author DELL
 */
public class Order {
    private int orderId;
    private String description;
    private Timestamp orderDate;
    private int shipFee;
    private int usedLotusBub;
    private int totalPrice;
    private int finalPrice;
    private int status;
    private int userId;
    private int recipientId;

    public Order() {
    }

    public Order(int orderId, String description, Timestamp orderDate, int shipFee, int usedLotusBub, int totalPrice, int finalPrice, int status, int userId, int recipientId) {
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

    public Order(String description, Timestamp orderDate, int shipFee, int usedLotusBub, int totalPrice, int finalPrice, int status, int userId, int recipientId) {
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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public int getShipFee() {
        return shipFee;
    }

    public void setShipFee(int shipFee) {
        this.shipFee = shipFee;
    }

    public int getUsedLotusBub() {
        return usedLotusBub;
    }

    public void setUsedLotusBub(int usedLotusBub) {
        this.usedLotusBub = usedLotusBub;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }
    
}
