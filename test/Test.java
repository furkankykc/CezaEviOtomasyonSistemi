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
          GardiyanController gc = new GardiyanController();
          RutbeController rc = new RutbeController();
          Gardiyan g = gc.getA();
          g.setRutbe(1);
          Rutbe r = rc.getaDAO().get(g.getRutbe_id());
          System.out.println("Test.main()"+r);
          
    

    
    
    
    
    
    
    }
}