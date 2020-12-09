/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import com.mycompany.htbanve.pojo.QLCX;
import com.mycompany.htbanve.service.JdbcUtils;
import com.mycompany.htbanve.service.QLCXsServices;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.MouseEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author ASUS-LAPTOP
 */
public class AddChuyenXeControllerTest {
    
    public AddChuyenXeControllerTest() {
    }
    
   private static Connection connect;
    
    @BeforeEach
    public static void setUp() throws SQLException {
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
     * Test of UpdateQLCX method, of class AddChuyenXeController.
     */
    @Test
    public void testUpdateQLCX() throws Exception {
        AddChuyenXeController instance = new AddChuyenXeController();
        instance.UpdateQLCX();
        Assert.assertNotNull(instance);
        Assert.assertNotEquals("Tencx", instance);
    }

    /**
     * Test of AddQLCX method, of class AddChuyenXeController.
     */
//    @Test
//    public void testAddQLCX() {
//        AddChuyenXeController instance = new AddChuyenXeController();
//        QLCX cx = new QLCX(1, "HN->SG", "85134HAS", "VIP", "15:33", "2020/12/9", "1200000", "Tung", "03361654684", "10"); 
//        
//    }

    /**
     * Test of Edit method, of class AddChuyenXeController.
     */
    @Test
    public void testEdit() {
        System.out.println("Edit");
        AddChuyenXeController instance = new AddChuyenXeController();
        instance.Edit();
    }

    /**
     * Test of DeleteQLCX method, of class AddChuyenXeController.
     */
    @Test
    public void testDeleteQLCX() {
        System.out.println("DeleteQLCX");
        AddChuyenXeController instance = new AddChuyenXeController();
        instance.DeleteQLCX();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of FindCX method, of class AddChuyenXeController.
     */
    @Test
    public void testFindCX() throws Exception {
        System.out.println("FindCX");
        AddChuyenXeController instance = new AddChuyenXeController();
        instance.FindCX();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
