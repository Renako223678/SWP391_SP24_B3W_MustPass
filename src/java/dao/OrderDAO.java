package dao;

import dto.OrderDTO;
import dto.RecipientDTO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

public class OrderDAO {
    public List<OrderDTO> getListOrder(long searchId) throws SQLException{
        List<OrderDTO> listOrder = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT [OrderId], [Description], [OrderDate], [ShipFee], [UsedLotusBub],"
                + "[TotalPrice], [FinalPrice], [Status], [UserId], [RecipientId]"
                + "FROM [Orders] WHERE [UserId] like ?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1,searchId);
            rs = ps.executeQuery();
            while(rs.next()){
                long orderId = rs.getLong("OrderId");
                String des = rs.getString("Description");
                Date orderDate = rs.getDate("OrderDate");
                BigDecimal shipFee = rs.getBigDecimal("ShipFee");
                int lotusBub = rs.getInt("UsedLotusBub");
                BigDecimal totalPrice = rs.getBigDecimal("TotalPrice");
                BigDecimal finalPrice = rs.getBigDecimal("FinalPrice");
                byte status = rs.getByte("Status");
                long userId = rs.getLong("UserId");
                long recipientId = rs.getLong("RecipientId");
                OrderDTO order = new OrderDTO(orderId, des, orderDate, shipFee, lotusBub, totalPrice, finalPrice, status, userId, recipientId);
                listOrder.add(order);
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
        
        return listOrder;
    }
    
}