/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import com.mycompany.htbanve.pojo.TenCX;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ASUS-LAPTOP
 */
public class Utils {
    public static List<TenCX> getTenCX() throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM tencx");
        
        List<TenCX> results = new ArrayList<>();
        while(rs.next()){
            TenCX c = new TenCX(rs.getString("idTenCX"),rs.getString("NameCX"));
            results.add(c);
            
        }
        return results;
    }
    
    public static void addTenCX(TenCX tencx) throws SQLException{
        Connection conn = JdbcUtils.getConnection();
        String sql1 = "INSERT INTO tencx(idTenCX, NameCX) VALUES(?,?)";
        
        conn.setAutoCommit(false);       
        //add tencx
        PreparedStatement stm = conn.prepareStatement(sql1);  
        stm.setString(1, tencx.getIdTenCX());
        stm.setString(2, tencx.getNameCX());
                
        stm.executeUpdate();
        conn.commit();
    }
}
