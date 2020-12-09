/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.service;

import com.mycompany.htbanve.pojo.QLBV;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class QLBVServicesTest {
    
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
            Assert.assertEquals(2, result.size());
            System.err.println("Test Successfully");
        } catch (SQLException ex) {
            System.err.println("Test Unsuccessfully");
        }
    }

    @Test
    public void testGetDataQLBV2() {
        try {       
            ObservableList<QLBV> result = QLBVServices.getDataQLBV2();
            Assert.assertEquals(2, result.size());
            System.err.println("Test Successfully");
        } catch (Exception e) {
            System.err.println("Test Unsuccessfully");
        }
    }
    
}
