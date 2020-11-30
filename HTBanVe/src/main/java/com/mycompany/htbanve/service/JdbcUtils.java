/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;

import com.mycompany.htbanve.pojo.QLCXs;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import java.sql.Connection;

/**
 *
 * @author ASUS-LAPTOP
 */
public class JdbcUtils {
     Connection conn = null;
     public static Connection ConnectDb(){
         
        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/htbanve",
                            "root","123456789");
                JOptionPane.showMessageDialog(null,"Connection Established");
                return conn;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                return null;
            }
    
    }
   
    public static ObservableList<QLCXs> getDataQLCXs(){
        Connection conn = ConnectDb();
        ObservableList<QLCXs> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = conn.prepareStatement( "SELECT * FROM htbanve.qlcx");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new QLCXs(Integer.parseInt(rs.getString("idQLCX")),rs.getString("QLCXtencx"),rs.getString("QLCXbsx"),rs.getString("QLCXloaixe"),rs.getString("QLCXgiokh"),rs.getString("QLCXngaykh"),rs.getString("QLCXghe"),rs.getString("QLCXgiave"),rs.getString("QLCXtennv"),rs.getString("QLCXstdnv")));
                
            }
        } catch (SQLException e){       
        }
        return list;
    }
}
