/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;

import com.mycompany.htbanve.pojo.BienSoXe;
import com.mycompany.htbanve.pojo.GiaVe;
import com.mycompany.htbanve.pojo.GioKH;
import com.mycompany.htbanve.pojo.LoaiXe;
import com.mycompany.htbanve.pojo.SDTNV;
import com.mycompany.htbanve.pojo.TenCX;
import com.mycompany.htbanve.pojo.TenNV;
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
    
    public static void addTenCX(TenCX tencx, BienSoXe bsx, LoaiXe lx, GioKH gkh, GiaVe gv, TenNV nv,SDTNV sdt) 
            throws SQLException{
        Connection conn = JdbcUtils.getConnection();
        String sql1 = "INSERT INTO tencx(idTenCX, NameCX) VALUES(?,?)";
        String sql2 = "INSERT INTO biensoxe(idbiensoxe, namebiensoxe) VALUES(?,?)";
        String sql3 = "INSERT INTO loaixe(idLoaiXe, NameLoaiXe) VALUES(?,?)";
        String sql4 = "INSERT INTO giokh(idGioKH, NameGioKH) VALUES(?,?)";
        String sql5 = "INSERT INTO giave(idGiaVe, NameGiaVe) VALUES(?,?)";
        String sql6 = "INSERT INTO tennv(idTenNV, NameTenNV) VALUES(?,?)";
        String sql7 = "INSERT INTO sdtnv(idSDTNV, NameSDTNV) VALUES(?,?)";
        conn.setAutoCommit(false);       
        
        PreparedStatement stm = conn.prepareStatement(sql1);
        PreparedStatement stm2 = conn.prepareStatement(sql2);
        PreparedStatement stm3 = conn.prepareStatement(sql3);
        PreparedStatement stm4 = conn.prepareStatement(sql4);
        PreparedStatement stm5 = conn.prepareStatement(sql5);
        PreparedStatement stm6 = conn.prepareStatement(sql6);
        PreparedStatement stm7 = conn.prepareStatement(sql7);
        
        stm.setString(1, tencx.getIdTenCX());
        stm.setString(2, tencx.getNameCX());
                
        stm2.setString(1, bsx.getIdBienSoXe());
        stm2.setString(2, bsx.getNameBienSoXe());
        
        stm3.setString(1, lx.getIdLoaiXe());
        stm3.setString(2, lx.getNameLoaiXe());
        
        stm4.setString(1, gkh.getIdGioKH());
        stm4.setString(2, gkh.getNameGioKH());
        
        stm5.setString(1, gv.getIdGiaVe());
        stm5.setString(2, gv.getNameGiave());
        
        stm6.setString(1, nv.getIdTenNV());
        stm6.setString(2, nv.getNameNV());
        
        stm7.setString(1, sdt.getIdSDTNV());
        stm7.setString(2, sdt.getnSDTNV());
        
        stm.executeUpdate();
        stm2.executeUpdate();
        stm3.executeUpdate();
        stm4.executeUpdate();
        stm5.executeUpdate();
        stm6.executeUpdate();
        stm7.executeUpdate();
        conn.commit();
    }
}
