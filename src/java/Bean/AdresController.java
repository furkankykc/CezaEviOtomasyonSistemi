/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.ArrayList;
import Entity.Adres;
import DAO.adresDao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author furkankykc
 */
@ManagedBean(name="adres")
@SessionScoped
public class AdresController {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

	private Adres a = null;
	private ArrayList<Adres> aList = null;
	private adresDao aDAO = null;

	public String detail(Adres a) {
		this.a = a;
		return "detail";
	}
	
	public String delete(int id) {
		this.getaDAO().delete(id);
                refreshList();
		return "list";
	}
	
	public String createForm() {
		this.a = null;
                
                refreshList();
		return "create";
	}
	
	public String updateForm(Adres a) {
		this.a = a;
		return "update";
	}
	
	public String updateAdres() {
		this.getaDAO().update(this.a);
		this.aList = this.getaDAO().list();
		return "list";
	}
	
	public String createAdres() {
		this.getaDAO().create(this.a);
		this.aList = this.getaDAO().list();
		return "list";
	}
	
	public Adres getA() {
		if ( this.a == null )
			this.a = new Adres();
		return a;
	}

	public void setA(Adres a) {
		this.a = a;
	}

	public ArrayList<Adres> getaList() {
		if ( this.aList == null ) {
			this.aList = new ArrayList();
			this.aList = getaDAO().list();
		}
		return this.aList;
	}
        public void refreshList(){
            this.aList=getaDAO().list();
        }

	public void setaList(ArrayList<Adres> aList) {
		this.aList = aList;
	}

	public adresDao getaDAO() {
		if ( this.aDAO == null )
			this.aDAO = new adresDao();
		return aDAO;
	}

	public void setaDAO(adresDao aDAO) {
		this.aDAO = aDAO;
	}
        
}


