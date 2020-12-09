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
public class QLCXsServicesTest {
    
    public QLCXsServicesTest() {
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
            Assert.assertEquals(3, result.size());
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
            Assert.assertEquals(3, result.size());
            System.err.println("Test Successfully");
        } catch (Exception ex) {
            System.err.println("Test Unsuccessfully");
        }
    }
    
}
