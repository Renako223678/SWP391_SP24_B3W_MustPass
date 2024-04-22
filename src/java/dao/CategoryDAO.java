package dao;

import dto.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBContext;


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
}
