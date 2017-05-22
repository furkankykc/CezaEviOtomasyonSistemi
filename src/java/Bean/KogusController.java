/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.ArrayList;
import Entity.Kogus;
import DAO.kogusDao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author furkankykc
 */
@ManagedBean(name="kogus")
@SessionScoped
public class KogusController {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

	private Kogus a = null;
	private ArrayList<Kogus> aList = null;
	private kogusDao aDAO = null;

	public String detail(Kogus a) {
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
	
	public String updateForm(Kogus a) {
		this.a = a;
		return "update";
	}
	
	public String updateKogus() {
		this.getaDAO().update(this.a);
		this.aList = this.getaDAO().list();
		refreshList();
                return "list";
	}
	
	public String createKogus() {
		this.getaDAO().create(this.a);
		this.aList = this.getaDAO().list();
		refreshList();
                return "list";
	}
	
	public Kogus getA() {
		if ( this.a == null ){
			this.a = new Kogus();
                        
                }
		return a;
	}

	public void setA(Kogus a) {
		this.a = a;
	}

	public ArrayList<Kogus> getaList() {
		if ( this.aList == null ) {
			this.aList = new ArrayList();
			this.aList = getaDAO().list();
		}
		return this.aList;
	}

	public void setaList(ArrayList<Kogus> aList) {
		this.aList = aList;
	}

	public kogusDao getaDAO() {
		if ( this.aDAO == null )
			this.aDAO = new kogusDao();
		return aDAO;
	}

	public void setaDAO(kogusDao aDAO) {
		this.aDAO = aDAO;
	}
        public void refreshList(){
            this.aList=getaDAO().list();
        }
}


