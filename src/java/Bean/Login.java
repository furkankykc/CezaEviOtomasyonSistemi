package Bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author furkankykc
 */
    
import Utility.SessionUtils;
import DAO.LoginDAO;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import Entity.User;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name= "login")
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;
	
	
	private String msg;
        private User user = null;

//    public String getUsname() {
//        return usname;
//    }
//
//    public void setUsname(String usname) {
//        this.usname = usname;
//    }
//        
//	public String getPwd() {
//		return pwd;
//	}
//
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public User getUser() {
            if(this.user==null)
		this.user= new User();
            return user;
           
	}

	public void setUser(User user) {
		this.user = user;
	}

	//validate login
	public String validateUsernamePassword() throws NoSuchAlgorithmException {
//            user = new User(usname,pwd);
		boolean valid = LoginDAO.validate(user);
                
//            boolean valid = LoginDAO.validate(user);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", user.getUserName());
			return "admin";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd  ",
							"Please enter correct username and Password"));
			return "login";
		}
	}

	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login.xhtml";
	}

}
