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
import Entity.Suclu;

/**
 *
 * @author furkankykc
 */
public class sucluDao {
    	private Suclu suclu = null;
	private ArrayList<Suclu> sucluList = null;
	
	public Suclu get(int id) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from suclu where id="+id);
			rs.next();
			this.suclu = new Suclu(rs.getInt("id"),rs.getString("ad"), rs.getInt("suc_id"), rs.getInt("tc"), rs.getInt("kogus_id"), rs.getString("kan_grubu"),rs.getDate("giris_tarih"),rs.getDate("cikis_tarih"));
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.suclu;
	}
	
	public ArrayList<Suclu> list() {
		this.sucluList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from suclu");
			while ( rs.next() ) {
				this.sucluList.add(new Suclu(rs.getInt("id"),rs.getString("ad"), rs.getInt("suc_id"), rs.getInt("tc"), rs.getInt("kogus_id"), rs.getString("kan_grubu"),rs.getDate("giris_tarih"),rs.getDate("cikis_tarih")));
				System.out.println("-----------------");
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.sucluList;
	}
	
	
	public void delete(int id) {
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from suclu where id="+id);
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void update(Suclu a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update suclu set ad='"+a.getAd()+"', suc_id='"+a.getSuc_id()+"', tc='"+a.getTc()+"', kogus_id='"+a.getKogus_id()+"', kan_grubu='"+a.getKan_grubu()+"', giris_tarih='"+a.getGiris_tarih()+"', cikis_tarih='"+a.getCikis_tarih()+"' where id="+a.getId());
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public void create(Suclu a) {
		Connection con = ConnectionManager.getConnection();
		
		try {
			Statement st = con.createStatement();
			st.executeUpdate("insert into suclu (ad, suc_id, tc, kogus_id, kan_grubu) values ('"+a.getAd()+"', '"+a.getSuc_id()+"', '"+a.getTc()+"', '"+a.getKogus_id()+"', '"+a.getKan_grubu()+"')");
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
	}
	
	
	public ArrayList<Suclu> SucluList() {
		this.sucluList = new ArrayList();
		Connection con = ConnectionManager.getConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from suclu");
			while ( rs.next() ) {
				this.sucluList.add(new Suclu(rs.getInt("id"),rs.getString("ad"), rs.getInt("suc_id"), rs.getInt("tc"), rs.getInt("kogus_id"), rs.getString("kan_grubu"),rs.getDate("giris_tarih"),rs.getDate("cikis_tarih")));
			}
		} catch ( SQLException ex ) {
			System.out.println(ex.getMessage());		
		}
		return this.sucluList;
	}
	
}
