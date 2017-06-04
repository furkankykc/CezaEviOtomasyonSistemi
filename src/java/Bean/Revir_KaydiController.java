/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.ArrayList;
import Entity.Revir_kaydi;
import DAO.revir_kaydiDao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author furkankykc
 */
@ManagedBean(name="revir_kaydi")
@SessionScoped
public class Revir_KaydiController {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
        
	private Revir_kaydi a = null;
	private ArrayList<Revir_kaydi> aList = null;
	private revir_kaydiDao aDAO = null;

	public String detail(Revir_kaydi a) {
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
	
	public String updateForm(Revir_kaydi a) {
		this.a = a;
		return "update";
	}
	
	public String updateRevir_kaydi() {
		this.getaDAO().update(this.a);
		this.aList = this.getaDAO().list();
		return "list";
	}
	
	public String createRevir_kaydi() {
		this.getaDAO().create(this.a);
		this.aList = this.getaDAO().list();
		return "list";
	}
	
	public Revir_kaydi getA() {
		if ( this.a == null )
			this.a = new Revir_kaydi();
		return a;
	}

	public void setA(Revir_kaydi a) {
		this.a = a;
	}

	public ArrayList<Revir_kaydi> getaList() {
		if ( this.aList == null ) {
			this.aList = new ArrayList();
			this.aList = getaDAO().list();
		}
		return this.aList;
	}
        public ArrayList<Revir_kaydi> getaList4Suclu_id(int suclu_id) {
		if ( this.aList == null ) {
			this.aList = new ArrayList();
			this.aList = getaDAO().list4Suclu_id(suclu_id);
		}
		return this.aList;
	}
        public void refreshList(){
            this.aList=getaDAO().list();
        }

	public void setaList(ArrayList<Revir_kaydi> aList) {
		this.aList = aList;
	}

	public revir_kaydiDao getaDAO() {
		if ( this.aDAO == null )
			this.aDAO = new revir_kaydiDao();
		return aDAO;
	}

	public void setaDAO(revir_kaydiDao aDAO) {
		this.aDAO = aDAO;
	}
        
}


