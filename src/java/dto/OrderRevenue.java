/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author THUAN
 */
public class OrderRevenue {
   
    private Timestamp orderDate;
    private int totalRevenue;

    public OrderRevenue(Timestamp orderDate, int totalRevenue) {
        this.orderDate = orderDate;
        this.totalRevenue = totalRevenue;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public int getTotalRevenue() {
        return totalRevenue;
    }
}


