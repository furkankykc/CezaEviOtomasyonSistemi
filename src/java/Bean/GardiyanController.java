/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.ArrayList;
import Entity.Gardiyan;
import DAO.gardiyanDao;
import Entity.Rutbe;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author furkankykc
 */
@ManagedBean(name="gardiyan")
@SessionScoped
public class GardiyanController {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

	private Gardiyan a = null;
	private ArrayList<Gardiyan> aList = null;
	private gardiyanDao aDAO = null;
        
        
        public ArrayList<Rutbe> getRutbe(){
            RutbeController rc = new RutbeController();
            return rc.getA();
        }
        public gardiyanDao getaDAO() {
            if ( this.aDAO == null )
                    this.aDAO = new gardiyanDao();
            return aDAO;
	}

	public void setaDAO(gardiyanDao aDAO) {
		this.aDAO = aDAO;
	}
	public String detail(Gardiyan a) {
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
		return "create";
	}
	
	public String updateForm(Gardiyan a) {
		this.a = a;
                refreshList();
		return "update";
	}
	
	public String updateGardiyan() {
		this.getaDAO().update(this.a);
		this.aList = this.getaDAO().list();
		return "list";
	}
	
	public String createGardiyan() {
		this.getaDAO().create(this.a);
		this.aList = this.getaDAO().list();
		return "list";
	}
	
	public Gardiyan getA() {
		if ( this.a == null ){
			this.a = new Gardiyan();
                }
		return a;
	}

	public void setA(Gardiyan a) {
		this.a = a;
	}

	public ArrayList<Gardiyan> getaList() {
				if ( this.aList == null ) {
			this.aList = new ArrayList();
			this.aList = getaDAO().list();
		}
		return this.aList;
	}
        
	public void setaList(ArrayList<Gardiyan> aList) {
		this.aList = aList;
	}
        public void refreshList(){
            this.aList=getaDAO().list();
        }

}


