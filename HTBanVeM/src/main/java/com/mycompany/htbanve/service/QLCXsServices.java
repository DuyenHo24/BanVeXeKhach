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
import java.util.UUID;
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
    public static boolean addCX(String a, String b, String c, String d, String e, String f, String g, String h, String i, String k) throws SQLException{
        Connection conn = JdbcUtils.getConnection();
        String sql = "INSERT INTO qlcx (idQLCX,QLCXtencx,QLCXbsx,QLCXgiokh,QLCXngaykh,QLCXgiave"
                    + ",QLCXtennv,QLCXsdtnv,QLCXloaixe,QLCXghe,idphanbiet)values(?,?,?,?,?,?,?,?,?,?,?)";
        String rd = UUID.randomUUID().toString();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst .setInt(1, Integer.parseInt(a));
        pst.setString(2,b);
        pst.setString(3,c);
        pst.setString(4,d);
        pst.setString(5,e);
        pst.setString(6,f);
        pst.setString(7,g);
        pst.setString(8,h);
        pst.setString(9,i);
        pst.setString(10,k);
        pst.setString(11,rd);               
        pst.execute();
        return true;
    }
    public static boolean EditCX(String value1, String value2, String value3, String value4
            ,String value5,String value6,String value7,String value8,String value9,String value10) throws SQLException{
        Connection conn = JdbcUtils.getConnection();
        String sql = "UPDATE qlcx set idQLCX= '"+value1+ "', QLCXtencx= '"+value2+"',QLCXbsx= '"+value3+"',QLCXloaixe= '"+
                value4+"',QLCXngaykh= '"+value5+"',QLCXgiokh= '"+value6+"',QLCXgiave= '"+
                value7+"',QLCXtennv= '"+value8+"',QLCXsdtnv= '"+value9+"',QLCXghe='"+value10+"' where idQLCX = '"+value1+"'";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.execute();
        return true;
    }
    public static boolean DeleteCX(String a) throws SQLException{
        Connection conn = JdbcUtils.getConnection();
        String sql = "DELETE FROM qlcx where idQLCX = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, a);
        pst.execute();
        return true;
    }
    
}


