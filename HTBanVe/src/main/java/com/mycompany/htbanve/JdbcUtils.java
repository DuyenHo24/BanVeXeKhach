/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS-LAPTOP
 */
public class JdbcUtils {
    private static Connection conn;
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost/htbanve",
                        "root","123456789");
            } catch (SQLException ex) {
                Logger.getLogger(JdbcUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static Connection getConnection(){
        return conn;
    }
}
