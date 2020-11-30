/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;

import com.mycompany.htbanve.pojo.TenCX;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    public static ObservableList<TenCX> getDatabase(){
        Connection conn = getConnection();
        ObservableList<TenCX> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = conn.prepareStatement("Select * from TenCX");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new TenCX(rs.getString("idtencx"),rs.getString("NameCX")));
            }
        } catch (Exception e){       
        }
        return list;
    }
}
