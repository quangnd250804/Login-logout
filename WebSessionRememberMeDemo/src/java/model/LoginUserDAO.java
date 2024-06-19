/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import connect.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADM
 */
public class LoginUserDAO {
    private final DBContext db;
    
    public LoginUserDAO() throws Exception{
        db = new DBContext();
    }
    
    public LoginUser checkLogin(LoginUser user) throws Exception{
        LoginUser temp = null;
        for(LoginUser u: new LoginUserDAO().getUserList()){
            if(user.getUsername().equals(u.getUsername())&&user.getPassword().equals(u.getPassword())){
                temp = user;
                break;
            }
        }
        return temp;
    }
    
    public ArrayList<LoginUser> getUserList() throws SQLException {
        String sql = "SELECT * FROM UserTBL";
        ArrayList<LoginUser> output = new ArrayList<>();
        Connection con = db.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                String username = rs.getString(2);
                String password = rs.getString(3);
                LoginUser user = new LoginUser(username, password);
                output.add(user);
            }
        } catch (SQLException ex) {
            db.close(con, ps, rs);
            Logger.getLogger(LoginUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
}
