/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author furkankykc
 */
public class User {
    private int id;
    private String userName = null;
    private String password = null;

    public User(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public User(){
        this.id = 0;
        this.password = "";
        this.userName = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword()  {
        try{
            return Utility.Sifrele.ssh(password);
        }catch(NoSuchAlgorithmException ex){
            return null;
        }
    }
//        return Utility.Sifrele.ssh(password);
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName=" + userName + '}';
    }
    
}
