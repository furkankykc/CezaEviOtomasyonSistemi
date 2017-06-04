/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.ArrayList;
import Entity.Rutbe;
import DAO.rutbeDao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author furkankykc
 */
@ManagedBean(name="rutbe")
@SessionScoped
public class RutbeController {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

	private Rutbe a = null;
	private ArrayList<Rutbe> aList = null;
	private rutbeDao aDAO = null;

	public String detail(Rutbe a) {
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
	
	public String updateForm(Rutbe a) {
		this.a = a;
		return "update";
	}
	
	public String updateRutbe() {
		this.getaDAO().update(this.a);
		this.aList = this.getaDAO().list();
		refreshList();return "list";
	}
	
	public String createRutbe() {
		this.getaDAO().create(this.a);
		this.aList = this.getaDAO().list();
		refreshList();return "list";
	}
	
	public Rutbe getA() {
		if ( this.a == null ){
			this.a = new Rutbe();
                        
                }
		return a;
	}

	public void setA(Rutbe a) {
		this.a = a;
	}

	public ArrayList<Rutbe> getaList() {
		if ( this.aList == null ) {
			this.aList = new ArrayList();
			this.aList = getaDAO().list();
		}
		return this.aList;
	}

	public void setaList(ArrayList<Rutbe> aList) {
		this.aList = aList;
	}

	public rutbeDao getaDAO() {
		if ( this.aDAO == null )
			this.aDAO = new rutbeDao();
		return aDAO;
	}

	public void setaDAO(rutbeDao aDAO) {
		this.aDAO = aDAO;
	}
         public void refreshList(){
            this.aList=getaDAO().list();
        }
}


