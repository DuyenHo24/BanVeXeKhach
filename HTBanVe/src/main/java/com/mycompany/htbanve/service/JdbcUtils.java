/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ASUS-LAPTOP
 */
public class JdbcUtils {
     Connection conn = null;

    public static Connection ConnectDb() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/htbanve",
                    "root", "htmd_240700");
            JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }


}
