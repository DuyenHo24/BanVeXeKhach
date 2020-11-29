/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;

import com.mycompany.htbanve.pojo.BienSoXe;
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
    public static List<TenCX> getTenCX(String keyword) throws SQLException{
        String sql = "SELECT * FROM tencx";
        if(!keyword.isEmpty())
            sql += "WHERE NameCX like ?";
        
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        if(!keyword.isEmpty())
            stm.setString(1,String.format("%%%s%%",keyword));
        ResultSet rs = stm.executeQuery();
        List<TenCX> tencxs = new ArrayList<>();
        while(rs.next()){
            TenCX q = new TenCX(rs.getString("idtencx"),
                    rs.getString("NameCX"));
            tencxs.add(q);
        }
        return tencxs;
        
    }
    public static void addTenCX(TenCX tencx,BienSoXe bsx) throws SQLException{//THEM BIEN
        Connection conn = JdbcUtils.getConnection();
        //addtencx
        String sql1 = "INSERT INTO tencx(idTenCX, NameCX) VALUES(?,?)";
        //addbsx
        String sql2 = "INSERT INTO biensoxe(idbiensoxe, biensoxecol) VALUES(?,?)";
        conn.setAutoCommit(false);       
        //add tencx
        PreparedStatement stm = conn.prepareStatement(sql1);  
        //add biensoxe
        PreparedStatement stm2 = conn.prepareStatement(sql2);
        //add tencx
        stm.setString(1, tencx.getIdTenCX());
        stm.setString(2, tencx.getNameCX());
        //add bien so xe
        stm2.setString(1, bsx.getIdBienSoXe());
        stm2.setString(2, bsx.getBienSoXeCol());
                //add tencx
        stm.executeUpdate();
        //add bsx
        stm2.executeUpdate();
        conn.commit();
    }
}
