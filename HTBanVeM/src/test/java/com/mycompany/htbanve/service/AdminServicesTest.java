/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;

import com.mycompany.htbanve.pojo.Admin;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
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
public class AdminServicesTest {
    
    public AdminServicesTest() {
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

    /**
     * Test of getDataAdmin method, of class AdminServices.
     */
    @Test
    public void testGetDataAdmin() {
        try {
            List<Admin> result = AdminServices.getDataAdmin();
            Assert.assertEquals(9, result.size());
            System.err.println("Test Successfully");
        } catch (SQLException ex) {
            System.err.println("Test Unsuccessfully");
        }
    }

    /**
     * Test of addTKAdmin method, of class AdminServices.
     */
    @Test
    public void testAddTKAdmin(){
        try{
        String a = "Tung20001";
        String b = "12345";
        String c = "Tung2000@gmail.com";
        boolean kq = AdminServices.addTKAdmin(a, b, c);
            Assert.assertTrue(kq);
            JOptionPane.showMessageDialog(null, "Add tai khoan thanh cong");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    
    }
    
}
