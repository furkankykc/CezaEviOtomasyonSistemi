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
import Entity.Revir_kaydi;

/**
 *
 * @author furkankykc
 */
public class revir_kaydiDao {
    	private Revir_kaydi revir_kaydi = null;
	private ArrayList<Revir_kaydi> revir_kaydiList = null;
	
	public Revir_kaydi get(int id) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from revir_kaydi where id="+id);
			rs.next();
			this.revir_kaydi = new Revir_kaydi(rs.getInt("id"), rs.getInt("suclu_id"), rs.getString("doktor_adi"), rs.getString("sikayet"));
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.revir_kaydi;
	}
	
	public ArrayList<Revir_kaydi> list() {
		this.revir_kaydiList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from revir_kaydi");
			while ( rs.next() ) {
				this.revir_kaydiList.add(new Revir_kaydi(rs.getInt("id"), rs.getInt("suclu_id"), rs.getString("doktor_adi"), rs.getString("sikayet")));
				System.out.println("-----------------");
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.revir_kaydiList;
	}
	
	
	public void delete(int id) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from revir_kaydi where id="+id);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void update(Revir_kaydi a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update revir_kaydi set suclu_id='"+a.getSuclu_id()+"', mahalle='"+a.getDoktor_adi()+"', sikayet='"+a.getSikayet()+"' where id="+a.getId());
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void create(Revir_kaydi a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into revir_kaydi (suclu_id, mahalle,sikayet) values ('"+a.getSuclu_id()+"', '"+a.getDoktor_adi()+"', '"+a.getSikayet()+"')");
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public ArrayList<Revir_kaydi> Revir_kaydiList() {
		this.revir_kaydiList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from revir_kaydi");
			while ( rs.next() ) {
				this.revir_kaydiList.add(new Revir_kaydi(rs.getInt("suclu_id"), rs.getString("doktor_adi"), rs.getString("sikayet")));
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.revir_kaydiList;
	}
	
}
