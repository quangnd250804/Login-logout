/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.DBContext to edit this template
 */
package connect;

 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.util.logging.Level;
 import java.util.logging.Logger;
/**
 *
 * @author ADM
 */
public class DBContext implements DatabaseInfor{

    public DBContext() {
    }
    
    public Connection getConnection(){
        Connection con = null;
        try {           
            Class.forName(driverName);
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    } 
    
    public void close(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException{
        if(rs!=null&&!rs.isClosed()){
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
}
