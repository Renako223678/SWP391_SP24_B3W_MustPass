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
import java.util.ArrayList;
import java.util.List;
import util.DBContext;

/**
 *
 * @author THUAN
 */
public class AccountDAO extends DBContext {

    //find account
    public Account findAccount(String email) throws ClassNotFoundException, SQLException {
        try {
            String sql = "select * from Users where Email = ?";
            PreparedStatement stm = getConnection().prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //get all account
//    public List<Account> getAllAccount() throws ClassNotFoundException, SQLException {
//        List<Account> listItems = new ArrayList<>();
//        try {
//            String sql = "select * from Account";
//            PreparedStatement stm = getConnection().prepareStatement(sql);
//            ResultSet rs = stm.executeQuery();
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
//                Account ac = new Account(_accountID, _username, _password, _fullname,
//                        _status, _gender, _email, _phone, _address, _date, _roleID);
//                listItems.add(ac);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return listItems;
//    }

    //detail account
//    public Account detailAccount(String id) throws ClassNotFoundException, SQLException {
//        Account ac = null;
//        try {
//            String sql = "select * from Account where accountID=? ";
//            PreparedStatement stmt = getConnection().prepareStatement(sql);
//            stmt.setString(1, id);
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
            String sql = "insert into Users(email,Password,Fullname,number_Of_Lotus,RoleID) "
                    + "values(?,?,?,?,?)";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, newItem.getEmail());
            stmt.setString(2, newItem.getPassword());
            stmt.setString(3, newItem.getFullname());
            stmt.setInt(4, newItem.getNumberOfLotus());
            stmt.setInt(5, newItem.getRoleId());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
//
//    //Update Account
//    public Account updateAccount(Account edittedItem) {
//        try {
//            String sql = "update Account set username=?, password=?, fullname=?, status=?, gender=?,"
//                    + "email=?, phone=?, address=?, createdDate=?, roleID=? where accountID=? ";
//            PreparedStatement stmt = getConnection().prepareStatement(sql);
//            stmt.setString(1, edittedItem.getUsername());
//            stmt.setString(2, edittedItem.getPassword());
//            stmt.setString(3, edittedItem.getFullname());
//            stmt.setBoolean(4, edittedItem.isStatus());
//            stmt.setBoolean(5, edittedItem.isGender());
//            stmt.setString(6, edittedItem.getEmail());
//            stmt.setString(7, edittedItem.getPhone());
//            stmt.setString(8, edittedItem.getAddrees());
//            stmt.setDate(9, edittedItem.getDate());
//            stmt.setInt(10, edittedItem.getRoleID());
//            stmt.setString(11, edittedItem.getAccountID());
//            stmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    
//    //Delete Account
//    public Account deleteAccount(String id) {
//        try {
//            String sql = "delete from Account where accountID =? ";
//            PreparedStatement stmt = getConnection().prepareStatement(sql);
//            stmt.setString(1, id);
//            ResultSet rs = stmt.executeQuery();
//            rs.next();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
