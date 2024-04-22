package dao;

import dto.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBContext;
import static util.DBContext.getConnection;


public class CategoryDAO {
    Connection conn= null;
    PreparedStatement ps =null;
    ResultSet rs = null;
    public List<Category> getAllListCategory() {
        List<Category> listCategory = new ArrayList<>();
        String query = "Select * from Category";
        try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    listCategory.add(new Category(rs.getInt(1), rs.getString(2), rs.getInt(3)));
                }
        } 
        catch (Exception e) {
            
        }
        return listCategory;
    }
    
    
    //detail category
    public Category detailCategory(String id) throws ClassNotFoundException, SQLException {
        Category ac = null;
        try {
            String sql = "select * from Category where ID=? ";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int _id = rs.getInt("ID");
                String _categoryName = rs.getString("CatogoryName");
                int _status = rs.getInt("Status");
                ac = new Category(_id, _categoryName, _status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ac;
    }
      //Update Category
    public Category updateCategory(Category edittedItem) {
        try {
            String sql = "update Category set CategoryName=?, Status=? where ID=?";
 
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, edittedItem.getCategoryName());
            stmt.setInt(2, edittedItem.getStatus());
            stmt.setInt(3, edittedItem.getCategoryID());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // Create category
    public Category createCategory(Category newItem) {
        try {
            String sql = "insert into Category(CategoryName,Status) "
                    + "values(?,?)";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setString(1, newItem.getCategoryName());
            stmt.setInt(2, newItem.getStatus());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
