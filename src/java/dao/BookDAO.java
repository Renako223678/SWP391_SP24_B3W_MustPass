package dao;

import dto.BookDTO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

public class BookDAO {
    public List<BookDTO> searchBook(String name) throws SQLException{
        List<BookDTO> bookList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT [BookId], [BookName], [Description], [AuthorName], [PublishingCompany],"
                + "[IssusingCompany], [TranslatorName], [PublishDate], [Quantity],"
                + "[UnitPrice], [CatogoryID], [Status], [TotalFeedback]"
                + "FROM [Books] WHERE [BookName] like ?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            while(rs.next()){
                long bookId = rs.getLong("BookId");
                String bookName = rs.getString("BookName");
                String des = rs.getString("Description");
                String authorName = rs.getString("AuthorName");
                String publishing = rs.getString("PublishingCompany");
                String issuing = rs.getString("IssusingCompany");
                String translator = rs.getString("TranslatorName");
                Date publishDate = rs.getDate("PublishDate");
                int quantity = rs.getInt("Quantity");
                BigDecimal unitPrice = rs.getBigDecimal("UnitPrice");
                int categoryId = rs.getInt("CatogoryID");
                Byte status = rs.getByte("Status");
                int totalFeedback = rs.getInt("TotalFeedback");
                BookDTO book = new BookDTO(bookId, bookName, des, authorName, publishing, 
                        issuing, translator, publishDate, quantity, unitPrice, categoryId, 
                        status, totalFeedback);
                bookList.add(book);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return bookList;
    }
    
    public boolean addBook(long bookId, String bookName, String description, String author,
            String publishingCompany, String issuingCompany, String translator, 
            Date publishDate, int quantity, BigDecimal unitPrice, byte status) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        
        String sql = "INSERT INTO [Books]([BookId], [BookName], [Description], [AuthorName], "
                + "[PublishingCompany], [IssusingCompany], [TranslatorName], [PublishDate], [Quantity]"
                + "[UnitPrice], [Status], [TotalFeedback])"
                + "SELECT ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
                + "FROM [Catogory]"
                + "WHERE [Books].[CatogoryID] = [Catogory].[ID]";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, bookId);
            ps.setString(2, bookName);
            ps.setString(3, description);
            ps.setString(4, author);
            ps.setString(5, publishingCompany);
            ps.setString(6, issuingCompany);
            ps.setString(7, translator);
            ps.setDate(8, publishDate);
            ps.setInt(9, quantity);
            ps.setBigDecimal(10, unitPrice);
            ps.setByte(11, status);
            check = ps.executeUpdate() > 0 ? true : false;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return check;
    }
    
    public boolean updateBook(String bookName, String des, String publishingCompany,
            String issuingCompany, String translator, Date publishDate,
            BigDecimal unitPrice, int categoryId, byte status) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        
        String sql = "UPDATE [Books] SET [Description] = ?, [PublishingCompany] = ?,"
                + "[IssusingCompany] = ?, [TranslatorName] = ?, [PublishDate] = ?,"
                + "[UnitPrice] = ?, [CatogoryID] = ?, [Status] = ?"
                + "WHERE [BookName] = ?";
        try{
            conn = DBUtils.getConnection();
            if(conn != null){
                ps = conn.prepareStatement(sql);
                ps.setString(1, des);
                ps.setString(2, publishingCompany);
                ps.setString(3, issuingCompany);
                ps.setString(4, translator);
                ps.setDate(5, publishDate);
                ps.setBigDecimal(6, unitPrice);
                ps.setInt(7, categoryId);
                ps.setByte(8, status);
                ps.setString(9, bookName);
                check = ps.executeUpdate() > 0 ? true : false;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return check;
    }
    
    public boolean deleteBook(long bookId) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        
        String sql = "DELETE FROM [Books] WHERE [BookId] = ?";
        try{
            conn = DBUtils.getConnection();
            if(conn != null){
                ps = conn.prepareStatement(sql);
                ps.setLong(1, bookId);
                check = ps.executeUpdate() > 0 ? true : false;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return check;
    }
}
