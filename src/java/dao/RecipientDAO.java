package dao;

import dto.Recipient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBContext;

public class RecipientDAO {
    Connection conn= null;
    PreparedStatement ps =null;
    ResultSet rs = null;
    public List<dto.Recipient> getRecipientByUserID(int userID){
        List<Recipient> listRecipient = new ArrayList<>();
        String query = "Select * from Recipient where UserId = ?";
        try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setInt(1, userID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    listRecipient.add(new dto.Recipient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                        rs.getInt(6)));
                }
                return listRecipient;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }
    public void createRecipient(Recipient newItem) {
        try {
            // Câu truy vấn để chèn dữ liệu vào bảng Recipient
            String sql = "INSERT INTO Recipient (destAddress, recipientName, phoneNumber, status, userID) "
                    + "VALUES (?, ?, ?, ?, ?)";
            
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, newItem.getDestAddress());
            ps.setString(2, newItem.getRecipientName());
            ps.setString(3, newItem.getPhoneNumber());
            ps.setInt(4, newItem.getStatus());
            ps.setInt(5, newItem.getUserID());
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error creating Recipient: " + e.getMessage());
        }
        
        // Nếu có lỗi, trả về null hoặc xử lý ngoại lệ khác
    }
    
    public Recipient getRecipientByOrderID(int orderID){
        String query = "SELECT r.recipientID, r.destAddress, r.recipientName, r.phoneNumber "
                     + "FROM Orders o "
                     + "JOIN Recipient r ON o.RecipientId = r.recipientID "
                     + "WHERE o.orderID = ?";
        try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setInt(1, orderID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return new dto.Recipient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                        rs.getInt(6));
                }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }
}
