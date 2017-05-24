/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author furkankykc
 */
import Bean.*;
import DAO.*;
import Entity.*;
import Utility.ConnectionManager;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Test {
    
    public static void main(String args[]){

          LoginDAO s =new LoginDAO();
          Login login = new Login();
          KogusController kogus =new KogusController();
          Kogus k = kogus.getA();
          k.setBinaNo(23);
          User u = login.getUser();
          u.setUserName("furkan");
          u.setPassword("123456");
          
    

    
    
    
    
    
    
    }
}