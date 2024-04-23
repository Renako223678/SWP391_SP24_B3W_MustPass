
package dao;

import dto.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBContext;
import static util.DBContext.getConnection;

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
     public List<Order> getALLOrder(){
        List<Order> listOrder = new ArrayList<>();
        String query = "Select * from Orders ORDER BY OrderDate DESC";
        try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    listOrder.add(new Order(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getFloat(4), rs.getInt(5), rs.getFloat(6),
                            rs.getFloat(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
                }
                
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return listOrder;
    }
     
     public Order updateOrders(Order edittedItem) {
        try {
            String sql = "update Orders set Description=?, OrderDate=?, ShipFee=?, UsedLotusBub=?, TotalPrice=?, FinalPrice=?,"
                    +  "UserId=?, RecipientId=?, Status=?  where OrderId=? ";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, edittedItem.getDescription());
            stmt.setDate(2, edittedItem.getOrderDate());
            stmt.setFloat(3, edittedItem.getShipFee());
            stmt.setInt(4, edittedItem.getUsedLotusBub());
            stmt.setFloat(5, edittedItem.getTotalPrice());
            stmt.setFloat(6, edittedItem.getFinalPrice());
            stmt.setInt(7, edittedItem.getUserId());
            stmt.setInt(8, edittedItem.getRecipientId());
            stmt.setInt(9, edittedItem.getStatus());
              stmt.setInt(10, edittedItem.getOrderId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     public Order detailOrders(String id) throws ClassNotFoundException, SQLException {
        Order ac = null;
        try {
            String sql = "select * from Orders where OrderId=? ";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int OrderId = rs.getInt("OrderId");
                String Description = rs.getString("Description");
                Date OrderDate = rs.getDate("OrderDate");
                float ShipFee = rs.getFloat("ShipFee");
                int UsedLotusBub = rs.getInt("UsedLotusBub");
                float TotalPrice = rs.getFloat("TotalPrice");
                float FinalPrice = rs.getFloat("FinalPrice");
                int UserId = rs.getInt("UserId");
                int RecipientId = rs.getInt("RecipientId");
                int Status = rs.getInt("Status");
                ac = new Order(OrderId, Description, OrderDate, ShipFee, UsedLotusBub, TotalPrice, FinalPrice, Status, UserId, RecipientId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ac;
    }
}

