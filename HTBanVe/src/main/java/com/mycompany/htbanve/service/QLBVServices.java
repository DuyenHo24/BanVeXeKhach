/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;

import com.mycompany.htbanve.pojo.QLBV;
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
 * @author ASUS
 */
public class QLBVServices {
    public static List<QLBV> getDataQLBV() throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("Select * From qlbv");
        List<QLBV> results = new ArrayList<>();
        while(rs.next()) {
            QLBV c = new QLBV(rs.getString("QLBVid"),rs.getString("QLBVtencx"), rs.getString("QLBVbsx"), rs.getString("QLBVgiokh")
                    , rs.getString("QLBVgiave"), rs.getString("QLBVtennv"), rs.getString("QLBVsdtnv")
                    , rs.getString("QLBVloaixe"), rs.getString("QLBVtenkh"), rs.getString("QLBVsdtkh")
                    , rs.getString("QLBVngaykh"),rs.getString("QLBVghe"));  
            results.add(c);
        }
        return results;
    }
    public static ObservableList<QLBV> getDataQLBV2(){
        Connection conn = JdbcUtils.getConnection();
        ObservableList<QLBV> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from qlbv");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                 list.add(new QLBV(rs.getString("QLBVid"),rs.getString("QLBVtencx"), rs.getString("QLBVbsx"), rs.getString("QLBVgiokh")
                         , rs.getString("QLBVgiave"), rs.getString("QLBVtennv"), rs.getString("QLBVsdtnv")
                         , rs.getString("QLBVloaixe"), rs.getString("QLBVtenkh"), rs.getString("QLBVsdtkh")
                         , rs.getString("QLBVngaykh"),rs.getString("QLBVghe")));  

            }
        } catch (Exception e) {
        }
        return list;
    }
}
