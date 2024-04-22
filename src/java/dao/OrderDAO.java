package dao;

import dto.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBContext;

public class OrderDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public int createOrder(Order order, int userId) {
         int orderId = -1;
        String query = "INSERT INTO orders(description, orderdate, shipfee, usedlotusbub, totalprice, finalprice, status, userid, recipientid) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, order.getDescription());
            ps.setDate(2, order.getOrderDate()); // Chuyển đổi kiểu Date
            ps.setFloat(3, order.getShipFee());
            ps.setInt(4, order.getUsedLotusBub());
            ps.setFloat(5, order.getTotalPrice());
            ps.setFloat(6, order.getFinalPrice());
            ps.setInt(7, order.getStatus());
            ps.setInt(8, userId);
            ps.setInt(9, 1);
            ps.executeUpdate();
             rs = ps.getGeneratedKeys();
            if (rs.next()) {
               orderId = rs.getInt(1); // Lấy ID của đơn hàng mới
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderId;
    }
    public List<Order> getOrderByUserID(int userId){
        List<Order> listOrder = new ArrayList<>();
        String query = "Select * from Orders where UserId = ?";
        try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setInt(1, userId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Order order = new Order(
                    rs.getInt("OrderId"), // Thay vì chỉ số cột, sử dụng tên cột
                    rs.getString("Description"),
                    rs.getDate("OrderDate"),
                    rs.getFloat("ShipFee"),
                    rs.getInt("UsedLotusBub"),
                    rs.getFloat("TotalPrice"),
                    rs.getFloat("FinalPrice"),
                    rs.getInt("Status"),
                    rs.getInt("UserId"),
                    rs.getInt("RecipientId")
                );
                listOrder.add(order);
                }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return listOrder;
    }
}
