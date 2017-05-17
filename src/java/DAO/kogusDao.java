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
import Entity.Kogus;

/**
 *
 * @author furkankykc
 */
public class kogusDao {
    	private Kogus kogus = null;
	private ArrayList<Kogus> kogusList = null;
	
	public Kogus get(int id) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from kogus where id="+id);
			rs.next();
			this.kogus = new Kogus(rs.getInt("id"),rs.getInt("kat"), rs.getInt("numara"), rs.getInt("binaNo"));
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.kogus;
	}
	
	public ArrayList<Kogus> list() {
		this.kogusList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from kogus");
			while ( rs.next() ) {
				this.kogusList.add(new Kogus(rs.getInt("id"),rs.getInt("kat"), rs.getInt("numara"), rs.getInt("binaNo")));
				System.out.println("-----------------");
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.kogusList;
	}
	
	
	public void delete(int id) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from kogus where id="+id);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void update(Kogus a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update kogus set kat='"+a.getKat()+"', numara='"+a.getNumara()+"' where id="+a.getId());
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void create(Kogus a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into kogus (kat, numara, binaNo) values ('"+a.getKat()+"', '"+a.getNumara()+"', '"+a.getBinaNo()+"')");
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public ArrayList<Kogus> KogusList() {
		this.kogusList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from kogus");
			while ( rs.next() ) {
				this.kogusList.add(new Kogus(rs.getInt("id"),rs.getInt("kat"), rs.getInt("numara"), rs.getInt("binaNo")));
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.kogusList;
	}
	
}
