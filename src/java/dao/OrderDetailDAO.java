package dao;

import dto.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBContext;

public class OrderDetailDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void createOrderDetail(OrderDetail orderDetail) {
        String query = "INSERT INTO OrderDetail (bookId, orderId, quantity, unitPrice, totalPrice, status) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, orderDetail.getBookId());
            ps.setInt(2, orderDetail.getOrderId());
            ps.setInt(3, orderDetail.getQuantity());
            ps.setFloat(4, orderDetail.getUnitPrice());
            ps.setFloat(5, orderDetail.getTotalPrice());
            ps.setInt(6, orderDetail.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<OrderDetail> getOrderDetailByOrderID(int orderId) {
        List<OrderDetail> listOrderDetail = new ArrayList<>();
        String query = "Select * from OrderDetail where OrderId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();
            while (rs.next()) {
                OrderDetail orderDetail = new OrderDetail(
                        rs.getInt("OrderDetailId"),
                        rs.getInt("BookId"),
                        rs.getInt("OrderId"),
                        rs.getInt("Quantity"),
                        rs.getFloat("UnitPrice"),
                        rs.getFloat("TotalPrice"),
                        rs.getInt("Status")
                );
                listOrderDetail.add(orderDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOrderDetail;
    }
    
    public List<OrderDetail> getOrderDetailByOrderIDs(String orderId){
        List<OrderDetail> listOrderDetail = new ArrayList<>();
        String query = "SELECT od.*, b.BookName FROM OrderDetail od JOIN Books b ON od.BookId = b.BookId WHERE od.OrderId = ?";
        try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, orderId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    OrderDetail orderDetail = new OrderDetail(
                    rs.getInt("OrderDetailId"), 
                rs.getInt("OrderId"), 
                rs.getInt("BookId"), 
                rs.getInt("Quantity"), 
                rs.getFloat("UnitPrice"), 
                rs.getFloat("TotalPrice"), 
                rs.getInt("Status"),
                rs.getString("BookName")          
                );
                listOrderDetail.add(orderDetail);
                }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return listOrderDetail;
    }
    
}
