package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author furkankykc
 */
    
import Entity.User;
import Utility.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.security.NoSuchAlgorithmException;
public class LoginDAO {

	public static boolean validate(User user) throws NoSuchAlgorithmException {
		Connection con ;
		PreparedStatement ps ;
//                password = Utility.Sifrele.ssh(password);
                User u = null;
                if(user==null||user.getUserName()==null||user.getPassword()==null) return false;
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("Select * from users where username = ? and password = ?");
                        
                        ps.setString(1, user.getUserName());
                        ps.setString(2, user.getPassword());
                        ResultSet rs = ps.executeQuery();
                       if (rs.next()) {
				//result found, means valid inputs
				return true;
			}
                        
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
		}
		return false;
	}
        public void create(User a) throws NoSuchAlgorithmException {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into users (username,password) values ('"+a.getUserName()+ "', '"+a.getPassword()+"')");
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());	
                         
		}
	}
		public void update(User a) throws NoSuchAlgorithmException {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update users set username='"+a.getUserName()+"', password='"+a.getPassword()+"' where id="+a.getId());
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}

}
