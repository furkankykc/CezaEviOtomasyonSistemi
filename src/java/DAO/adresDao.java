/*
 * To change this license hebinaNoer, choose License HebinaNoers in Project Properties.
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
import Entity.Adres;

/**
 *
 * @author furkankykc
 */
public class adresDao {
    	private Adres adres = null;
	private ArrayList<Adres> adresList = null;
	
	public Adres get(int id) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from adres where id="+id);
			rs.next();
			this.adres = new Adres(rs.getInt("id"), rs.getInt("binaNo"), rs.getString("mahalle"));
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.adres;
	}
	
	public ArrayList<Adres> list() {
		this.adresList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from adres");
			while ( rs.next() ) {
				this.adresList.add(new Adres(rs.getInt("id"), rs.getInt("binaNo"), rs.getString("mahalle")));
				System.out.println("-----------------");
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.adresList;
	}
	
	
	public void delete(int id) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from adres where id="+id);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void update(Adres a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update adres set binaNo='"+a.getBinaNo()+"', mahalle='"+a.getMahalle()+"' where id="+a.getId());
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void create(Adres a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into adres (binaNo, mahalle) values ('"+a.getBinaNo()+"', '"+a.getMahalle()+"')");
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public ArrayList<Adres> AdresList() {
		this.adresList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from adres");
			while ( rs.next() ) {
				this.adresList.add(new Adres(rs.getInt("id"), rs.getInt("binaNo"), rs.getString("mahalle")));
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.adresList;
	}
	
}
