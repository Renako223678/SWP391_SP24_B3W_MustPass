/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Feedback;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBContext;
import static util.DBContext.getConnection;

/**
 *
 * @author VU
 */
public class FeedbackDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<Feedback> getAllFeedback() throws ClassNotFoundException, SQLException {
        List<Feedback> listItems = new ArrayList<>();
        try {
            String sql = "select * from FeedBack ORDER BY FeedBackId DESC";
            PreparedStatement stm = getConnection().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int FeedBackId = rs.getInt("FeedBackId");
                int Star = rs.getInt("Star");
                String Description = rs.getString("Description");
                int UserId = rs.getInt("UserId");
                int BookId = rs.getInt("BookId");
                Feedback ac = new Feedback(FeedBackId, Star, Description, UserId, BookId);
                listItems.add(ac);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listItems;
    }
    
     public List<Feedback> getALLOFeedback(){
        List<Feedback> listO = new ArrayList<>();
        String query = "Select * from FeedBack";
        try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    listO.add(new Feedback(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
                }
                
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return listO;
    }
     
    public List<Feedback> getAllFeedbacks() throws SQLException, ClassNotFoundException {
    List<Feedback> listItems = new ArrayList<>();
    String sql = "SELECT * FROM Feedback";
    try (PreparedStatement stm = getConnection().prepareStatement(sql);
         ResultSet rs = stm.executeQuery()) {
        while (rs.next()) {
            int feedbackId = rs.getInt("FeedBackId");
            int star = rs.getInt("Star");
            String description = rs.getString("Description");
            int userId = rs.getInt("UserId");
            int bookId = rs.getInt("BookId");
            Feedback feedback = new Feedback(feedbackId, star, description, userId, bookId);
            listItems.add(feedback);
        }
    } catch (SQLException e) {
        // Log the exception or handle it in an appropriate way
        throw e;
    }
    return listItems;
}
    public Feedback deleteFeedback(String id) {
        try {
            String sql = "delete from Feedback where FeedBackId =? ";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Feedback> getALLFeedbackByBookID(int bookID){
        List<Feedback> listFeedback = new ArrayList<>();
        String query = "Select * from FeedBack where bookID = ?";
        try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setInt(1, bookID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    listFeedback.add(new Feedback(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
                }
                
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return listFeedback;
    }

}
