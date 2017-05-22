/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.ArrayList;
import Entity.Yemek;
import DAO.yemekDao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author furkankykc
 */
@ManagedBean(name="yemek")
@SessionScoped
public class YemekController {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

	private Yemek a = null;
	private ArrayList<Yemek> aList = null;
	private yemekDao aDAO = null;

	public String detail(Yemek a) {
		this.a = a;
		return "detail";
	}
	
	public String delete(int id) {
		this.getaDAO().delete(id);
		refreshList();return "list";
	}
	
	public String createForm() {
		this.a = null;
		return "create";
	}
	
	public String updateForm(Yemek a) {
		this.a = a;
		return "update";
	}
	
	public String updateYemek() {
		this.getaDAO().update(this.a);
		this.aList = this.getaDAO().list();
		refreshList();return "list";
	}
	
	public String createYemek() {
		this.getaDAO().create(this.a);
		this.aList = this.getaDAO().list();
		refreshList();return "list";
	}
	
	public Yemek getA() {
		if ( this.a == null ){
			this.a = new Yemek();
                        
                }
		return a;
	}

	public void setA(Yemek a) {
		this.a = a;
	}

	public ArrayList<Yemek> getaList() {
		if ( this.aList == null ) {
			this.aList = new ArrayList();
			this.aList = getaDAO().list();
		}
		return this.aList;
	}

	public void setaList(ArrayList<Yemek> aList) {
		this.aList = aList;
	}

	public yemekDao getaDAO() {
		if ( this.aDAO == null )
			this.aDAO = new yemekDao();
		return aDAO;
	}

	public void setaDAO(yemekDao aDAO) {
		this.aDAO = aDAO;
	}
        public void refreshList(){
            this.aList=getaDAO().list();
        }
}


