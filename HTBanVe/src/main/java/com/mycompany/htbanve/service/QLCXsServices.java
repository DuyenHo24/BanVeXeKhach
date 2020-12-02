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
import java.util.List;
import javafx.collections.FXCollections;

/**
 *
 * @author ASUS
 */
public class QLCXsServices {

    public static List<QLCXs> getDataQLCXs() {
        Connection conn = JdbcUtils.ConnectDb();
        List<QLCXs> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM htbanve.qlcx");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new QLCXs(Integer.parseInt(rs.getString("idQLCX")), rs.getString("QLCXtencx"), rs.getString("QLCXbsx"), rs.getString("QLCXloaixe"), rs.getString("QLCXgiokh"), rs.getString("QLCXngaykh"), rs.getString("QLCXghe"), rs.getString("QLCXgiave"), rs.getString("QLCXtennv"), rs.getString("QLCXstdnv")));

            }
        } catch (SQLException e) {
        }
        return list;
    }

    public static void Add_QLCX(QLCXs cx) throws SQLException {
        Connection conn = JdbcUtils.ConnectDb();
        String sql = "insert into qlcx(id, tencx, bsx, loaixe, giokh, ngaykh, giave, ghe, tennv)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        conn.setAutoCommit(false);
        PreparedStatement pst = conn.prepareStatement(sql);
        
        pst.setInt(1, cx.getId());
        pst.setString(2, cx.getTencx());
        pst.setString(3, cx.getBsx());
        pst.setString(4, cx.getLoaixe());
        pst.setString(5, cx.getGiokh());
        pst.setString(6, cx.getNgaykh());
        pst.setString(7, cx.getGiave());
        pst.setString(8, cx.getGhe());
        pst.setString(9, cx.getTencx());
        pst.setString(10, cx.getSdtnv());
        
        pst.executeUpdate();

        conn.commit();
    }
    
    }
