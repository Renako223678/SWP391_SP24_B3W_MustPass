package dao;

import dto.SubCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBContext;

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
    }
    
}
