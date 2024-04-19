/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.FeedbackDTO;
import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.DBUtils;

/**
 *
 * @author ADMIN
 */
public class UserDAO {
   
    public static UserDTO checkLogin(String email, String password) throws ClassNotFoundException, SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = utils.DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT TOP (1000) [ID]\n"
                        + "      ,[name]\n"
                        + "      ,[password]\n"
                        + "      ,[roleid]\n"
                        + "  FROM [BookStore].[dbo].[Users]\n"
                        + "  where [userid] = ? and password = ?";;
                ps = conn.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, password);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String fullName = rs.getString("fullname");
                    int userid = rs.getInt("email");
                    int roleID = rs.getInt("roleid");
                    int numberlotus = rs.getInt("Number_of_lotus");
                    user = new UserDTO(userid, email, password, fullName, numberlotus, roleID);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }

        }

        return user;
    }
     public boolean Insert(FeedbackDTO f){
        boolean inserted = false;
        String sql = "INSERT into Feedback VALUES(?,?,?,?,?)";
        try{
            Connection con = DBUtils.getConnection();
            PreparedStatement ptm = con.prepareStatement(sql);
            ptm.setInt(1, f.getFeedbackid()+1);
            ptm.setInt(2, f.getStar());
            ptm.setString(3, f.getDescription());
            ptm.setInt(4, f.getBookid());
            ptm.setInt(5, f.getUserid());
            ptm.executeUpdate();
            inserted = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return inserted;
    }
    
}

