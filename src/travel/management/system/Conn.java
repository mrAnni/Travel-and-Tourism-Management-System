/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;

import java.sql.*;  

public class Conn{
    Connection c = null;
    Statement s;
    public Conn() throws SQLException{  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql://localhost:3307/tms","root","123456"); 
            
            s =c.createStatement();  
            
           
        }catch(ClassNotFoundException | NullPointerException e){ 
            System.out.println(e);
        }  
    }  
}