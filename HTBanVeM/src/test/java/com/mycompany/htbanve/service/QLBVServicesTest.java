/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;

import com.mycompany.htbanve.pojo.QLBV;
import com.mycompany.htbanve.pojo.QLCX;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author ASUS-LAPTOP
 */
public class QLBVServicesTest {
    
    public QLBVServicesTest() {
    }
    private static Connection connect;
    
    @BeforeEach
    public static void setUp() {
        connect = JdbcUtils.getConnection();
    }
    
    @AfterEach
    public static void tearDown() {
        try {
            JdbcUtils.getConnection().close();
        } catch (SQLException ex) {
        }
    }
    
    @Test
    public void testGetDataQLBV() throws Exception {
        try {
            List<QLBV> result = QLBVServices.getDataQLBV();
            Assert.assertEquals(4, result.size());
            System.err.println("Test Successfully");
        } catch (SQLException ex) {
            System.err.println("Test Unsuccessfully");
        }
    }

    @Test
    public void testGetDataQLBV2() {
        try {       
            ObservableList<QLBV> result = QLBVServices.getDataQLBV2();
            Assert.assertEquals(4, result.size());
            System.err.println("Test Successfully");
        } catch (Exception e) {
            System.err.println("Test Unsuccessfully");
        }
    }

    @Test
    public void testUpdateQLBV() throws Exception {
        try{
        String value1 = "Lu";
        String value2 = "123456";
        String value3 = "A05";
        String value4 = "20690da8-d2b3-4898-8434-f3bb677a9e53";
        boolean kq= QLBVServices.updateQLBV(value1, value2, value3, value4);
        Assert.assertTrue(kq);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }   
    }

    @Test
    public void testAddVe(){
        
        try{
        String value1 = "a";
        String value2 = "b";
        String value3 = "c";
        String value4 = "d";
        String value5 = "e";
        String value6 = "f";
        String value7 = "g";
        String value8 = "h";
        String value9 = "j";
        String value10 = "k";
        String value11 = "l";
        String value12 = "m";
        String value13 = "n";
        boolean kq = QLBVServices.addVe(value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12, value13);
        Assert.assertTrue(kq);
            JOptionPane.showMessageDialog(null, "Them ve thanh cong");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        } 
    }

    @Test
    public void testGiamGhe() {
        try{
        String value1 = "4";
        String value2 = "c70f85b4-b598-4f41-a540-ae7427da23a6";
        boolean kq = QLBVServices.GiamGhe(value1, value2);
        Assert.assertTrue(kq);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Test
    public void testKiemtraNgayGio(){
        try{
        String a = "2020-12-13";
        String b = "15:30";
        boolean kq=QLBVServices.KiemtraNgayGio(a, b);
        Assert.assertTrue(kq);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }  
    }

    @Test
    public void testXoaVe() throws Exception {
        try{
        String a = "a";
        String b = "52083611-94b5-46bc-ab8a-918442e763cb";
        boolean kq = QLBVServices.XoaVe(a, b);
        Assert.assertTrue(kq);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }  
    }
    
}
    

