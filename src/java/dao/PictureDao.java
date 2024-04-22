/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Picture;
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
public class PictureDao {
    public Picture getPictureByID(int Id) throws SQLException {
        Picture picture = new Picture();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            
            pst = getConnection().prepareStatement("SELECT * FROM Picture WHERE PicID = ?");
            pst.setInt(1, Id);
            rs = pst.executeQuery();
            if (rs.next()) {
                return new Picture(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }
    public List<Picture> getListPicture() throws SQLException {
        List<Picture> listProduct = new ArrayList<Picture>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
                pst = getConnection().prepareStatement("SELECT * FROM Picture");
                rs = pst.executeQuery();
                while (rs.next()) {
                    listProduct.add(new Picture(rs.getInt(1), rs.getString(2), rs.getString(3)));
                }
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return listProduct;
    }
}
