/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBContext;

/**
 *
 * @author VU
 */
public class AccountDAO extends DBContext {

    //find account
    public Account findAccount(String email, String password) throws ClassNotFoundException, SQLException {
        try {
            String sql = "select * from Users where Email = ? and Password =  ?";
            PreparedStatement stm = getConnection().prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //get all account
    public List<Account> getAllAccount() throws ClassNotFoundException, SQLException {
        List<Account> listItems = new ArrayList<>();
        try {
            String sql = "select * from Users";
            PreparedStatement stm = getConnection().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int _userId = rs.getInt("UserId");
                String _email = rs.getString("Email");
                String _password = rs.getString("Password");
                String _fullname = rs.getString("Fullname");
                int _numberOfLotus = rs.getInt("Number_of_Lotus");
                int _roleID = rs.getInt("RoleID");
                int _status = rs.getInt("Status");
                Account ac = new Account(_userId, _email, _password, _fullname, _numberOfLotus, _roleID, _status);
                listItems.add(ac);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listItems;
    }
    public List<Account> getAllAccountManager() throws ClassNotFoundException, SQLException {
        List<Account> listItems = new ArrayList<>();
        try {
            String sql = "select * from Users WHERE RoleID IN (2, 3, 4)";
            PreparedStatement stm = getConnection().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int _userId = rs.getInt("UserId");
                String _email = rs.getString("Email");
                String _password = rs.getString("Password");
                String _fullname = rs.getString("Fullname");
                int _numberOfLotus = rs.getInt("Number_of_Lotus");
                int _roleID = rs.getInt("RoleID");
                int _status = rs.getInt("Status");
                Account ac = new Account(_userId, _email, _password, _fullname, _numberOfLotus, _roleID, _status);
                listItems.add(ac);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listItems;
    }

    //detail account
    public Account detailAccount(String id) throws ClassNotFoundException, SQLException {
        Account ac = null;
        try {
            String sql = "select * from Users where UserId=? ";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _userId = rs.getInt("UserId");
                String _email = rs.getString("Email");
                String _password = rs.getString("Password");
                String _fullname = rs.getString("Fullname");
                int _numberOfLotus = rs.getInt("Number_of_Lotus");
                int _roleID = rs.getInt("RoleID");
                int _status = rs.getInt("Status");
                ac = new Account(_userId, _email, _password, _fullname, _numberOfLotus, _roleID, _status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ac;
    }
    
    public Account detailAccountInt(int id) throws ClassNotFoundException, SQLException {
        Account ac = null;
        try {
            String sql = "select * from Users where UserId=? ";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _userId = rs.getInt("UserId");
                String _email = rs.getString("Email");
                String _password = rs.getString("Password");
                String _fullname = rs.getString("Fullname");
                int _numberOfLotus = rs.getInt("Number_of_Lotus");
                int _roleID = rs.getInt("RoleID");
                int _status = rs.getInt("Status");
                ac = new Account(_userId, _email, _password, _fullname, _numberOfLotus, _roleID, _status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ac;
    }
    
//    public Account detailProfileAccount(String name) throws ClassNotFoundException, SQLException {
//        Account ac = null;
//        try {
//            String sql = "select * from Account where username=? ";
//            PreparedStatement stmt = getConnection().prepareStatement(sql);
//            stmt.setString(1, name);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                String _accountID = rs.getString("accountID");
//                String _username = rs.getString("username");
//                String _password = rs.getString("password");
//                String _fullname = rs.getString("fullname");
//                boolean _status = rs.getBoolean("status");
//                boolean _gender = rs.getBoolean("gender");
//                String _email = rs.getString("email");
//                String _phone = rs.getString("phone");
//                String _address = rs.getString("address");
//                Date _date = rs.getDate("createdDate");
//                int _roleID = rs.getInt("roleID");
//                ac = new Account(_accountID, _username, _password, _fullname,
//                        _status, _gender, _email, _phone, _address, _date, _roleID);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ac;
//    }
    //Create account
    public Account createAccount(Account newItem) {
        try {
            String sql = "insert into Users(email,Password,Fullname,number_Of_Lotus,RoleID,Status) "
                    + "values(?,?,?,?,?,?)";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, newItem.getEmail());
            stmt.setString(2, newItem.getPassword());
            stmt.setString(3, newItem.getFullname());
            stmt.setInt(4, newItem.getNumberOfLotus());
            stmt.setInt(5, newItem.getRoleId());
            stmt.setInt(6, newItem.getStatus());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
//
//    //Update Account
    public Account updateAccount(Account edittedItem) {
        try {
            String sql = "update Users set Email=?, Password=?, Fullname=?, Number_of_Lotus=?,"
                    +  "RoleID=?, Status=?  where UserId=? ";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, edittedItem.getEmail());
            stmt.setString(2, edittedItem.getPassword());
            stmt.setString(3, edittedItem.getFullname());
            stmt.setInt(4, edittedItem.getNumberOfLotus());
            stmt.setInt(5, edittedItem.getRoleId());
            stmt.setInt(6, edittedItem.getStatus());
            stmt.setInt(7, edittedItem.getUserId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//
//    
//    //Delete Account
    public Account deleteAccount(String id) {
        try {
            String sql = "delete from Users where UserId =? ";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void updateUserLotus() throws ClassNotFoundException, SQLException {
        String sql = "UPDATE [BookStore].[dbo].[Users] " +
                     "SET [Number_of_Lotus] = [Number_of_Lotus] + " +
                     "(SELECT SUM(o.[TotalPrice] / 1000) " +
                     " FROM [BookStore].[dbo].[Orders] o " +
                     " WHERE o.[Status] = 4 AND [Users].[UserId] = o.[UserId] " +
                     " GROUP BY o.[UserId]) " +
                     "WHERE EXISTS ( " +
                     " SELECT 1 " +
                     " FROM [BookStore].[dbo].[Orders] o " +
                     " WHERE o.[Status] = 4 AND [Users].[UserId] = o.[UserId])";
        
        try (Connection conn = new DBContext().getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
