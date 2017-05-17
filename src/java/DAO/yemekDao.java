/*
 * To change this license header, choose License Headers in Project Properties.
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
import Entity.Yemek;

/**
 *
 * @author furkankykc
 */
public class yemekDao {
    	private Yemek yemek = null;
	private ArrayList<Yemek> yemekList = null;
	
	public Yemek get(int id) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from yemek where id="+id);
			rs.next();
			this.yemek = new Yemek(rs.getInt("id"), rs.getString("ad"), rs.getInt("kalori"));
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.yemek;
	}
	
	public ArrayList<Yemek> list() {
		this.yemekList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from yemek");
			while ( rs.next() ) {
				this.yemekList.add(new Yemek(rs.getInt("id"), rs.getString("ad"), rs.getInt("kalori")));
				System.out.println("-----------------");
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.yemekList;
	}
	
	
	public void delete(int id) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from yemek where id="+id);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void update(Yemek a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update yemek set ad='"+a.getAd()+"', kalori='"+a.getKalori()+"' where id="+a.getId());
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void create(Yemek a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into yemek (ad, kalori) values ('"+a.getAd()+"', '"+a.getKalori()+"')");
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public ArrayList<Yemek> YemekList() {
		this.yemekList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from yemek");
			while ( rs.next() ) {
				this.yemekList.add(new Yemek(rs.getInt("id"), rs.getString("ad"), rs.getInt("kalori")));
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.yemekList;
	}
	
}
