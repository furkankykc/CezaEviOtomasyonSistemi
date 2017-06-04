/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.ArrayList;
import Entity.Suclu;
import DAO.sucluDao;
import Entity.Kogus;

import Entity.Suc;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author furkankykc
 */
@ManagedBean(name="suclu")
@SessionScoped
public class SucluController {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

	private Suclu a = null;
	private ArrayList<Suclu> aList = null;
	private sucluDao aDAO = null;

        public ArrayList<Kogus> getKogus(){
            KogusController kc = new KogusController();
            return kc.getaList();
        }
        public ArrayList<Suc> getSuc(){
            SucController sc = new SucController();
            return sc.getaList();
        }
        
	public String detail(Suclu a) {
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
	
	public String updateForm(Suclu a) {
		this.a = a;
		return "update";
	}
	
	public String updateSuclu() {
		this.getaDAO().update(this.a);
		this.aList = this.getaDAO().list();
                refreshList();
		return "list";
	}
	
	public String createSuclu() {
		this.getaDAO().create(this.a);
		refreshList();
		return "list";
	}
	
	public Suclu getA() {
		if ( this.a == null ){
			this.a = new Suclu();
                        
                }
		return a;
	}

	public void setA(Suclu a) {
		this.a = a;
	}

	public ArrayList<Suclu> getaList() {
		if ( this.aList == null ) {
			this.aList = new ArrayList();
			this.aList = getaDAO().list();
		}
		return this.aList;
	}
        public ArrayList<Suclu> getaList4Suc_id(int suc_id) {
		if ( this.aList == null ) {
			this.aList = new ArrayList();
			this.aList = getaDAO().SucluList4Suc_id(suc_id);
		}
		return this.aList;
	}
        public ArrayList<Suclu> getaList4Kogus_id(int kogus_id) {
		if ( this.aList == null ) {
			this.aList = new ArrayList();
			this.aList = getaDAO().SucluList4Kogus_id(kogus_id);
		}
		return this.aList;
	}

	public void setaList(ArrayList<Suclu> aList) {
		this.aList = aList;
	}

	public sucluDao getaDAO() {
		if ( this.aDAO == null )
			this.aDAO = new sucluDao();
		return aDAO;
	}

	public void setaDAO(sucluDao aDAO) {
		this.aDAO = aDAO;
	}
        public void refreshList(){
            this.aList=getaDAO().list();
        }
}


