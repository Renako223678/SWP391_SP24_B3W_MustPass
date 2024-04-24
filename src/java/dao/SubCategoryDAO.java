package dao;

import dto.SubCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBContext;
import static util.DBContext.getConnection;

public class SubCategoryDAO {
    Connection conn= null;
    PreparedStatement ps =null;
    ResultSet rs = null;
    
    public List<SubCategory> getListSubCategoryByCategoryId(int id) {
        List<SubCategory> listSub = new ArrayList<>();
        String query = "Select * from SubCategory where CategoryId = ?";
        try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    listSub.add(new SubCategory(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
                }
            
        } 
        catch (Exception e) {
            
        }
        return listSub;
    };
    
    public List<SubCategory> getAllListSubCategory() {
        List<SubCategory> listSub = new ArrayList<>();
        String query = "Select * from SubCategory";
        try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    listSub.add(new SubCategory(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
                }
            
        } 
        catch (Exception e) {
            
        }
        return listSub;
    }
      public SubCategory deleteSubCategory(String id) {
        try {
            String sql = "delete from SubCategory where ID =? ";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
      public SubCategory detailSubCategory(String id) throws ClassNotFoundException, SQLException {
        SubCategory ac = null;
        try {
            String sql = "select * from SubCategory where ID=? ";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String SubName = rs.getString("SubName");
                String Description = rs.getString("Description");
                int Status = rs.getInt("Status");
                int CategoryId = rs.getInt("CategoryId");
                ac = new SubCategory(ID, SubName, Description, Status, CategoryId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ac;
    }
      
        public SubCategory updateSubCategory(SubCategory edittedItem) {
        try {
            String sql = "update SubCategory set SubName=?, Description=?, Status=?, CategoryId=? where ID=?";
 
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, edittedItem.getSubName());
            stmt.setString(2, edittedItem.getDescription());
            stmt.setInt(3, edittedItem.getStatus());
            stmt.setInt(4, edittedItem.getCategoryId());
            stmt.setInt(5, edittedItem.getSubcategoryID());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
         public SubCategory createSubCategory(SubCategory newItem) {
        try {
            String sql = "insert into SubCategory(SubName,Description,Status,CategoryId) "
                    + "values(?,?,?,?)";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, newItem.getSubName());
            stmt.setString(2, newItem.getDescription());
            stmt.setInt(3, newItem.getStatus());
            stmt.setInt(4, newItem.getCategoryId());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
