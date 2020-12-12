/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;

import com.mycompany.htbanve.pojo.QLCX;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS-LAPTOP
 */
public class QLCXsServices {
      
        
    public static List<QLCX> getDataQLCXs() throws SQLException{
        Connection conn = JdbcUtils.getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("Select * from qlcx");
        
        List<QLCX> results = new ArrayList<>();
        while(rs.next()){
            QLCX c = new QLCX(Integer.parseInt(rs.getString("idQLCX")),rs.getString("QLCXtencx"),rs.getString("QLCXbsx")
                    ,rs.getString("QLCXloaixe"),rs.getString("QLCXgiokh"),rs.getString("QLCXngaykh"),rs.getString("QLCXgiave")
                    ,rs.getString("QLCXtennv"),rs.getString("QLCXsdtnv"),rs.getString("QLCXghe"),rs.getString("idphanbiet"));  
            results.add(c);
        }
        return results;
    }
    public static ObservableList<QLCX> getDataQLCX(){
        Connection conn = JdbcUtils.getConnection();
        ObservableList<QLCX> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from qlcx");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                 list.add(new QLCX(Integer.parseInt(rs.getString("idQLCX")),rs.getString("QLCXtencx")
                         ,rs.getString("QLCXbsx"),rs.getString("QLCXloaixe"),rs.getString("QLCXgiokh")
                         ,rs.getString("QLCXngaykh"),rs.getString("QLCXgiave"),rs.getString("QLCXtennv")
                         ,rs.getString("QLCXsdtnv"),rs.getString("QLCXghe"),rs.getString("idphanbiet")));  

            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    
}


