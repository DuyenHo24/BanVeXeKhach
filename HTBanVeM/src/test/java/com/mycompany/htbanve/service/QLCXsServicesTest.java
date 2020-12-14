/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;

import com.mycompany.htbanve.pojo.QLCX;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author ASUS-LAPTOP
 */
public class QLCXsServicesTest {
    
    public QLCXsServicesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
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
    public void testGetDataQLCXs() throws Exception {
        try {
            List<QLCX> result = QLCXsServices.getDataQLCXs();
            Assert.assertEquals(4, result.size());
            System.err.println("Test Successfully");
        } catch (SQLException ex) {
            System.err.println("Test Unsuccessfully");
        }
    }

    /**
     * Test of getDataQLCX method, of class QLCXsServices.
     */
    @Test
    public void testGetDataQLCX() {
        try {
            ObservableList<QLCX> result = QLCXsServices.getDataQLCX();
            Assert.assertEquals(4, result.size());
            System.err.println("Test Successfully");
        } catch (Exception ex) {
            System.err.println("Test Unsuccessfully");
        }
    }
    /**
     * Test of addCX method, of class QLCXsServices.
     */
    @Test
    public void testAddCX() throws Exception {
        try{         
            String a = "6";
            String b = "b";
            String c = "c";
            String d = "d";
            String e = "e";
            String f = "f";
            String g = "g";
            String h = "h";
            String i = "j";
            String k = "k";
            boolean kq = QLCXsServices.addCX(a, b, c, d, e, f, g, h, i, k);
            Assert.assertTrue(kq);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Test
    public void testEditCX() throws Exception {
        String  b = null,c= null,d=null,e = null ,f= null,g= null,h=null,j=null,k=null;
        try{
            String value1 = "5";
            String value2 = "hw";
            String value3 = "he";
            String value4 = "hr";
            String value5 = "ht";
            String value6 = "hy";
            String value7 = "hu";
            String value8 = "hi";
            String value9 = "ho";
            String value10 = "hp";
            boolean kq = QLCXsServices.EditCX(value1, value2, value3, value4, value5, value6, value7, value8, value9, value10);
            Assert.assertTrue(kq);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Test
    public void testDeleteCX() throws Exception {
        int b = 0;
        try{
            String a = "2";
            boolean kq = QLCXsServices.DeleteCX(a);
        Assert.assertTrue(kq);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
}
