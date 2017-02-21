/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author youssouf
 */
public class Connexion {
    private static String url = "jdbc:mysql://localhost:3306/ecommerce";    
    private static String driverName = "com.mysql.jdbc.Driver";   
    private static String userName = "root";   
    private static String password = "";
    private static Connection con;
    
    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, userName, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.err.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.err.println("Driver not found."); 
        }
        System.err.println("Failed to create the database connection.");
        return con;
    }
}
