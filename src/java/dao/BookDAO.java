/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.DBContext;
import dto.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author DELL
 */
public class BookDAO{
    Connection conn= null;
    PreparedStatement ps =null;
    ResultSet rs = null;
//    public Book findProductForCart(String Id, int quantity) throws ClassNotFoundException, SQLException {
//        try {
//            String sql = "select * from Product where productID = ?";
//            PreparedStatement stm = getConnection().prepareStatement(sql);
//            stm.setInt(1, Integer.parseInt(Id));
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                return new Book(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getFloat(4), quantity,
//                        rs.getFloat(6), rs.getString(7), rs.getDate(8), rs.getDate(9), rs.getInt(10), rs.getInt(11));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    public List<Book> getListProductByCategory(String search) throws SQLException {
//        List<Book> listProduct = new ArrayList<>();
//        PreparedStatement pst = null;
//        ResultSet rs = null;
//        try {
//                pst = getConnection().prepareStatement("SELECT * FROM Product WHERE CategoryID = ?");
//                pst.setString(0, search);
//                rs = pst.executeQuery();
//                while (rs.next()) {
//                    listProduct.add(new Book(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getFloat(4), rs.getInt(5),
//                        rs.getFloat(6), rs.getString(7), rs.getDate(8), rs.getDate(9), rs.getInt(10), rs.getInt(11)));
//                }
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        } 
//        return listProduct;
//    }
    public List<Book> getAllListBook() {
        List<Book> listBook = new ArrayList<>();
        String query = "Select * from Books";
        try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    listBook.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getDate(8), rs.getInt(9),rs.getInt(10), rs.getFloat(11), rs.getInt(12),
                        rs.getInt(13), rs.getInt(14)));
                }
            
        } 
        catch (Exception e) {
            
        }
        return listBook;
    }

    public Book getBookByID(int id){
        String query = "Select * from Books where BookId = ?";
        try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getDate(8), rs.getInt(9),rs.getInt(10), rs.getFloat(11), rs.getInt(12),
                        rs.getInt(13), rs.getInt(14));
                }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }
    
    public List<Book> getBookByCateAndSubCate(int cateId, int subCateId){
        List<Book> listBook = new ArrayList<>();
        String query = "Select * from Books where CategoryId=? and SubCategoryId = ?";
        try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setInt(1, cateId);
                ps.setInt(2, subCateId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    listBook.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getDate(8), rs.getInt(9),rs.getInt(10), rs.getFloat(11), rs.getInt(12),
                        rs.getInt(13), rs.getInt(14)));
                }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return listBook;
    }
    

}