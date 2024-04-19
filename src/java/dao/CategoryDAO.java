package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import utils.DBUtils;

public class CategoryDAO {
    public boolean createCategory(int categoryId, String categoryName, int subId, int status) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        
        String sql = "INSERT INTO [Catogory]{[ID], [CategoryName], [SubID], [Status]}"
                + "VALUES{?, ?, ?, ?}";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, categoryId);
            ps.setString(2, categoryName);
            ps.setLong(3, subId);
            ps.setInt(4, subId);
            check = ps.executeUpdate() > 0 ? true : false;
        }catch(Exception e){
            e.printStackTrace();
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
    
    public boolean deleteCategory(String categoryName) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        
        String sql = "DELETE FROM [Catogory] WHERE [CatogoryName] = ?";
        try{
            conn = DBUtils.getConnection();
            if(conn != null){
                ps = conn.prepareStatement(sql);
                ps.setString(1, categoryName);
                check = ps.executeUpdate() > 0 ? true : false;
            }
        }catch(Exception e){
            e.printStackTrace();
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
