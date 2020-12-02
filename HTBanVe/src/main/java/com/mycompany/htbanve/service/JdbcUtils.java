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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
    public static List<QLCXs> getDataQLCXs() throws SQLException{
        Connection conn = JdbcUtils.getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("Select * from qlcx");
        
        List<QLCXs> results = new ArrayList<>();
        while(rs.next()){
            QLCXs c = new QLCXs(Integer.parseInt(rs.getString("idQLCX")),rs.getString("QLCXtencx"),rs.getString("QLCXbsx"),rs.getString("QLCXloaixe"),rs.getString("QLCXgiokh"),rs.getString("QLCXngaykh"),rs.getString("QLCXgiave"),rs.getString("QLCXtennv"),rs.getString("QLCXsdtnv"));  
            results.add(c);
        }
        return results;
    }
    public static List<QLCXs> getQLCXs() throws SQLException{
        String sql = "Select * from qlcx";
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<QLCXs> qlcxs = new ArrayList<>();
        while(rs.next()){
            QLCXs c = new QLCXs(Integer.parseInt(rs.getString("idQLCX")),rs.getString("QLCXtencx"),rs.getString("QLCXbsx"),rs.getString("QLCXloaixe"),rs.getString("QLCXgiokh"),rs.getString("QLCXngaykh"),rs.getString("QLCXgiave"),rs.getString("QLCXtennv"),rs.getString("QLCXsdtnv"));
            qlcxs.add(c);
        }
        
        return qlcxs;
    }
    
}
