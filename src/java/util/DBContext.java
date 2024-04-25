/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VU
 */
public class DBContext {

    private Connection conn = null;

//    public DBContext() {
//        try {
//            String IP = "localhost";
//            String instanceName = "SQLVU";
//            String port = "1433";
//            String uid = "sa";
//            String pwd = "12345";
//            String db = "Onlinebookstore1";
//            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//            String url = "jdbc:sqlserver://" + IP + "\\" + instanceName + ":" + port
//                    + ";databasename=" + db + ";user=" + uid + ";password=" + pwd;
//            Class.forName(driver);
//            conn = DriverManager.getConnection(url);
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
    
     public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection conn= null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url= "jdbc:sqlserver://localhost:1433;databaseName=BookStore";
        conn= DriverManager.getConnection(url, "sa", "12345");
        return conn;
    }

   
    public  Connection getConn() {
        return conn;
    }

    public void setConn() {
        this.conn = conn;

    }

    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
    


}
