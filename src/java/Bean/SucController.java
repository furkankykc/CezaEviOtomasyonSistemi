/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.ArrayList;
import Entity.Suc;
import DAO.sucDao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author furkankykc
 */
@ManagedBean(name="suc")
@SessionScoped
public class SucController {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

	private Suc a = null;
	private ArrayList<Suc> aList = null;
	private sucDao aDAO = null;

	public String detail(Suc a) {
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
	
	public String updateForm(Suc a) {
		this.a = a;
		return "update";
	}
	
	public String updateSuc() {
		this.getaDAO().update(this.a);
		this.aList = this.getaDAO().list();
		refreshList();return "list";
	}
	
	public String createSuc() {
		this.getaDAO().create(this.a);
		this.aList = this.getaDAO().list();
		refreshList();return "list";
	}
	
	public Suc getA() {
		if ( this.a == null ){
			this.a = new Suc();
                        
                }
		return a;
	}

	public void setA(Suc a) {
		this.a = a;
	}

	public ArrayList<Suc> getaList() {
		if ( this.aList == null ) {
			this.aList = new ArrayList();
			this.aList = getaDAO().list();
		}
		return this.aList;
	}

	public void setaList(ArrayList<Suc> aList) {
		this.aList = aList;
	}

	public sucDao getaDAO() {
		if ( this.aDAO == null )
			this.aDAO = new sucDao();
		return aDAO;
	}

	public void setaDAO(sucDao aDAO) {
		this.aDAO = aDAO;
	}
        public void refreshList(){
            this.aList=getaDAO().list();
        }
}


