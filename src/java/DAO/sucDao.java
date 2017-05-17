/*
 * To change this license hesuclu_ider, choose License Hesuclu_iders in Project Properties.
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
import Entity.Suc;

/**
 *
 * @author furkankykc
 */
public class sucDao {
    	private Suc suc = null;
	private ArrayList<Suc> sucList = null;
	
	public Suc get(int id) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from suc where id="+id);
			rs.next();
			this.suc = new Suc(rs.getInt("id"), rs.getString("ad"), rs.getString("suc_tanimi"));
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.suc;
	}
	
	public ArrayList<Suc> list() {
		this.sucList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from suc");
			while ( rs.next() ) {
				this.sucList.add(new Suc(rs.getInt("id"), rs.getString("ad"), rs.getString("suc_tanimi")));
				System.out.println("-----------------");
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.sucList;
	}
	
	
	public void delete(int id) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from suc where id="+id);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void update(Suc a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update suc set ad='"+a.getAd()+"', suc_tanimi='"+a.getSuc_tanimi()+"' where id="+a.getId());
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void create(Suc a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into suc (ad,suc_tanimi) values ('"+a.getAd()+"', '"+a.getSuc_tanimi()+"')");
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public ArrayList<Suc> SucList() {
		this.sucList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from suc");
			while ( rs.next() ) {
				this.sucList.add(new Suc(rs.getString("ad"), rs.getString("suc_tanimi")));
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.sucList;
	}
	
}
