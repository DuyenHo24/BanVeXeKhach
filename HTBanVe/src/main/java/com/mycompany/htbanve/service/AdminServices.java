/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS-LAPTOP
 */
public class AdminServices {
    Connection conn = null;
    public static Connection ConnectionAdmin(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/htbanve","root","123456789");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
