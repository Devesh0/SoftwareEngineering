/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystem;

/**
 *
 * @author hudsons8
 */
import java.sql.* ;  // for standard JDBC programsimport java.sql.Connection;
import java.util.*;
import java.io.*;

public class BookingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

            //sample code to demo the databaase connection and sql statements            
            String connectionURL = "jdbc:derby://localhost:1527/BookSession";
            String uName = "MP";
            String uPass= "123";
        
            //ConnectionURL, username and password should be specified in getConnection()       
            try {             
                    Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
                    System.out.println("Connect to database..."); 

                    if (conn != null){ 
                        

                        ManagerUI ui = new ManagerUI(conn);
                        ui.displayMenu();     
                        
                        conn.close();
                        System.out.println("Connection is closed.");
                        
                        System.exit(1);
                    
                    } else {
                        System.out.println("null");  
                    }
            } catch (SQLException ex) {             
                System.out.println("Connection failed.");         
            }          
    }
}
    
