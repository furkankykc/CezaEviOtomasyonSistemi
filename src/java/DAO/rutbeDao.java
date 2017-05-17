/*
 * To change this license herutbe_adier, choose License Herutbe_adiers in Project Properties.
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
import Entity.Rutbe;

/**
 *
 * @author furkankykc
 */
public class rutbeDao {
    	private Rutbe rutbe = null;
	private ArrayList<Rutbe> rutbeList = null;
	
	public Rutbe get(int id) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from rutbe where id="+id);
			rs.next();
			this.rutbe = new Rutbe(rs.getInt("id"), rs.getString("rutbe_adi"));
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.rutbe;
	}
	
	public ArrayList<Rutbe> list() {
		this.rutbeList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from rutbe");
			while ( rs.next() ) {
				this.rutbeList.add(new Rutbe(rs.getInt("id"), rs.getString("rutbe_adi")));
				System.out.println("-----------------");
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.rutbeList;
	}
	
	
	public void delete(int id) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from rutbe where id="+id);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void update(Rutbe a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update rutbe set rutbe_adi='"+a.getAd()+"' where id="+a.getId());
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void create(Rutbe a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into rutbe (rutbe_adi) values ('"+a.getAd()+"')");
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public ArrayList<Rutbe> RutbeList() {
		this.rutbeList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from rutbe");
			while ( rs.next() ) {
				this.rutbeList.add(new Rutbe(rs.getInt("id"), rs.getString("rutbe_adi")));
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.rutbeList;
	}
	
}
