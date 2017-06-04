/*
 * To change this license hetcer, choose License Hetcers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utility.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Entity.Gardiyan;
import Entity.Kogus;
import Entity.User;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author furkankykc
 */
public class gardiyanDao {
    	private Gardiyan gardiyan = null;
	private ArrayList<Gardiyan> gardiyanList = null;
	
	public Gardiyan get(int id) {
	Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from gardiyan where id="+id);
			rs.next();
			this.gardiyan = new Gardiyan(rs.getInt("id"),rs.getString("ad") ,rs.getInt("tc"), rs.getInt("rutbe_id"));
                        System.out.println("DAO.gardiyanDao.get():"+ rs.getString("ad"));
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.gardiyan;
	}
	
	public ArrayList<Gardiyan> list() {
		this.gardiyanList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from gardiyan");
			while ( rs.next() ) {
				this.gardiyanList.add(new Gardiyan(rs.getInt("id"),rs.getString("ad"),rs.getInt("tc"),rs.getInt("rutbe_id")));
				
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.gardiyanList;
	}
        public ArrayList<Gardiyan> list4Rutbe_id(int rutbe_id) {
		this.gardiyanList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from gardiyan where rutbe_id = "+rutbe_id);
			while ( rs.next() ) {
				this.gardiyanList.add(new Gardiyan(rs.getInt("id"),rs.getString("ad"),rs.getInt("tc"),rs.getInt("rutbe_id")));
				
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.gardiyanList;
	}
	
	
	public void delete(int id) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from gardiyan where id="+id);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
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
	
	public void update(Gardiyan a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update gardiyan set tc='"+a.getTc()+"', rutbe_id='"+a.getRutbe_id()+"', ad='"+a.getAd()+"' where id="+a.getId());
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void create(Gardiyan a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into gardiyan (ad,tc, rutbe_id) values ('"+a.getAd()+ "', '"+a.getTc()+"', '"+a.getRutbe_id()+"')");
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	

}
