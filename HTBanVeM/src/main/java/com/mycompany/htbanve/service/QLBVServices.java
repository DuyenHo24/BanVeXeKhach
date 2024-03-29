/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;

import com.mycompany.htbanve.pojo.QLBV;
import com.sun.org.apache.xpath.internal.operations.Equals;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

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
                    , rs.getString("QLBVngaykh"),rs.getString("QLBVghe"),rs.getString("idphanbiet"));  
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
                         , rs.getString("QLBVngaykh"),rs.getString("QLBVghe"),rs.getString("idphanbiet")));  

            }
        } catch (SQLException e) {
            
        }
        return list;
    }
    public static boolean updateQLBV(String value1, String value2, String value3, String value4) throws SQLException{
        Connection conn = JdbcUtils.getConnection();
        String sql = "UPDATE qlbv set QLBVtenkh= '"+value1+"',QLBVsdtkh= '"+value2+"',QLBVghe='"+value3+"' where QLBVid = '"+value4+"' ";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.execute();
        return true;
    }
    public static boolean addVe(String value1, String value2, String value3, String value4
            ,String value5,String value6,String value7,String value8,String value9,String value10
            ,String value11, String value12,String value13) throws SQLException{
        Connection conn = JdbcUtils.getConnection();
        String sql = "INSERT INTO qlbv (QLBVid,QLBVtencx,QLBVbsx,QLBVgiokh,QLBVngaykh"
                    + ",QLBVgiave,QLBVloaixe,QLBVtenkh,QLBVsdtkh,QLBVtennv,QLBVsdtnv,QLBVghe,idphanbiet)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);                
            pst.setString(1, value1 );
            pst.setString(2,value2);
            pst.setString(3,value3);
            pst.setString(4,value4);
            pst.setString(5,value5);
            pst.setString(6,value6);
            pst.setString(7,value7);
            pst.setString(8,value8);
            pst.setString(9,value9);
            pst.setString(10,value10);
            pst.setString(11,value11);
            pst.setString(12,value12);
            pst.setString(13,value13);
            pst.execute(); 
            return true;
    }
    public static boolean GiamGhe(String value1, String value2) throws SQLException{
        Connection conn = JdbcUtils.getConnection();
        String sql2 = "UPDATE qlcx set QLCXghe= '"+value1+"' where idphanbiet = '"+value2+"' ";
        PreparedStatement pst = conn.prepareStatement(sql2);
        pst.execute(); 
        return true;
    }
    public static boolean KiemtraNgayGio(String a, String b) throws SQLException{
        Connection conn = JdbcUtils.getConnection();
        String sql = "Select * from qlbv where QLBVngaykh = ? ";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,a);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            String sql1 = "Select * from qlbv where QLBVgiokh = ? ";
                PreparedStatement pst1 = conn.prepareStatement(sql1);
                pst1.setString(1,b);
                ResultSet rs1 = pst1.executeQuery();
            if(rs1.next()){
                String sql3 = "DELETE FROM qlcx where QLCXngaykh = ? and QLCXgiokh = ?";
                    PreparedStatement pst2 = conn.prepareStatement(sql3);
                    pst2.setString(1, a);
                    pst2.setString(2, b);
                    pst2.execute();
                String sql4 = "DELETE FROM qlbv where QLBVngaykh = ? and QLBVgiokh = ?";
                    PreparedStatement pst3 = conn.prepareStatement(sql4);
                    pst3.setString(1,a);
                    pst3.setString(2,b);
                    pst3.execute();
            }
           
        }
        return true;
    }
    public static boolean XoaVe(String a,String b) throws SQLException{
        Connection conn = JdbcUtils.getConnection();
        String sql = "DELETE FROM qlbv where QLBVid = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, a);
        pst.execute();
        JOptionPane.showMessageDialog(null, "delete");
        try {
                String sql1 = "select QLCXghe from qlcx"; 
                PreparedStatement pst1 = conn.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();              
                if(rs1.next()){ 
                    Integer d = (Integer.parseInt(rs1.getString(1))) + 1;
                    String value1 = d.toString();
                    String value2 = b;
                    String sql3 = "UPDATE qlcx set QLCXghe= '"+value1+"' where idphanbiet = '"+value2+"' ";
                    PreparedStatement pst2 = conn.prepareStatement(sql3);
                    pst2.execute(); 
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        return true;
    }
}
