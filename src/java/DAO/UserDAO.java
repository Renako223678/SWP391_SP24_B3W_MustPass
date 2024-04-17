/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class UserDAO {
   
    public static Account checkLogin(String email, String password) throws ClassNotFoundException, SQLException {
        Account user = null;
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
                    user = new Account(userid, email, password, fullName, numberlotus, roleID);
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
}
