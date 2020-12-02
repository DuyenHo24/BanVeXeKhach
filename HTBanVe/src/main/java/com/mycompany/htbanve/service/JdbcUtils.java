/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;

import com.mycompany.htbanve.pojo.QLCXs;
import java.sql.DriverManager;

import java.sql.SQLException;


import javax.swing.JOptionPane;
import java.sql.Connection;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS-LAPTOP
 */
public class JdbcUtils {
    private static Connection conn;
      static
      {        
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/htbanve",
                            "root","123456789");
                JOptionPane.showMessageDialog(null,"Connection Established");
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, e);
            }catch(SQLException ex){
                Logger.getLogger(JdbcUtils.class.getName()).log(Level.SEVERE,null,ex);
            }
    
    }
   
    public static Connection getConnection(){
//        Connection conn = ConnectDb();
//        ObservableList<QLCXs> list = FXCollections.observableArrayList();
//        try{
//            PreparedStatement ps = conn.prepareStatement( "SELECT * FROM htbanve.qlcx");
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                list.add(new QLCXs(Integer.parseInt(rs.getString("idQLCX")),rs.getString("QLCXtencx"),rs.getString("QLCXbsx"),rs.getString("QLCXloaixe"),rs.getString("QLCXgiokh"),rs.getString("QLCXngaykh"),rs.getString("QLCXgiave"),rs.getString("QLCXtennv"),rs.getString("QLCXstdnv")));
//                
//            }
//        } catch (SQLException e){       
//        }
        return conn;
    }
    
}
