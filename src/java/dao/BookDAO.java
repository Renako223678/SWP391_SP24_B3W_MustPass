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
import static util.DBContext.getConnection;

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
        String query = "Select * from Books ORDER BY BookId DESC";
        try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    listBook.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9),rs.getInt(10), rs.getInt(11), rs.getInt(12),
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
                        rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9),rs.getInt(10), rs.getInt(11), rs.getInt(12),
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
                        rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9),rs.getInt(10), rs.getInt(11), rs.getInt(12),
                        rs.getInt(13), rs.getInt(14)));
                }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return listBook;
    }
    
    public Book getBookID(String id){
        String query = "Select * from Books where BookId = ?";
        try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9),rs.getInt(10), rs.getInt(11), rs.getInt(12),
                        rs.getInt(13), rs.getInt(14));
                }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }
    
      public Book updateBook(Book edittedItem) {
        try {
            String sql = "update Books set BookName=?, Description=?, AuthorName=?, PublishingCompany=?,"
                    +  "IssusingCompany=?, TranslatorName=?, PublishYear=?, Quantity=?, SubCategoryId=?, UnitPrice=?, CategoryID=?, Status=?, TotalFeedback=?  where BookId=? ";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, edittedItem.getBookName());
            stmt.setString(2, edittedItem.getDescription());
            stmt.setString(3, edittedItem.getAuthorName());
            stmt.setString(4, edittedItem.getPublishingCompany());
            stmt.setString(5, edittedItem.getIssusingCompany());
            stmt.setString(6, edittedItem.getTranslatorName());
            stmt.setInt(7, edittedItem.getPublishDate());
            stmt.setInt(8, edittedItem.getQuantity());
            stmt.setInt(9, edittedItem.getSubCategoryId());
            stmt.setFloat(10, edittedItem.getUnitPrice());
            stmt.setInt(11, edittedItem.getCategoryId());
            stmt.setInt(12, edittedItem.getStatus());
            stmt.setInt(13, edittedItem.getTotalFeedback());
            stmt.setInt(14, edittedItem.getBookId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
   
            return edittedItem;
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
         
    //Create  
  public Book createBook(Book newItem) throws ClassNotFoundException {
    try {
        String sql = "INSERT INTO Books (BookName, Description, AuthorName, PublishingCompany, IssusingCompany, TranslatorName, PublishYear, Quantity, SubCategoryId, UnitPrice, CategoryID, Status, TotalFeedback) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setString(1, newItem.getBookName());
        stmt.setString(2, newItem.getDescription());
        stmt.setString(3, newItem.getAuthorName());
        stmt.setString(4, newItem.getPublishingCompany());
        stmt.setString(5, newItem.getIssusingCompany());
        stmt.setString(6, newItem.getTranslatorName());
        stmt.setInt(7, newItem.getPublishDate());
        stmt.setInt(8, newItem.getQuantity());
        stmt.setInt(9, newItem.getSubCategoryId());
        stmt.setFloat(10, newItem.getUnitPrice());
        stmt.setInt(11, newItem.getCategoryId());
        stmt.setInt(12, newItem.getStatus());
        stmt.setInt(13, newItem.getTotalFeedback());
        stmt.executeUpdate();
    } catch (SQLException e) {
        // Log or throw the exception for proper error handling
        e.printStackTrace();
    }
    return null;
}

   
   
   public Book deleteBook(String id) {
        try {
            String sql = "delete from Books where BookId =? ";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}