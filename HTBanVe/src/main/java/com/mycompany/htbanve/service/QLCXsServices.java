/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;

import com.mycompany.htbanve.pojo.QLCXs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS-LAPTOP
 */
public class QLCXsServices {
        
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
