/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import com.mycompany.htbanve.service.JdbcUtils;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS-LAPTOP
 */
public class ChonChucNangController implements Initializable {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    /**
     * Initializes the controller class.
     * @param event
     * @throws java.io.IOException
     * @throws java.sql.SQLException
     */
    @FXML 
    public void SwitchtoQLVX(ActionEvent event) throws IOException, SQLException{
        String a =(LocalDate.now().toString());
        String b =(LocalTime.now().toString().substring(0, 5));
        conn = JdbcUtils.getConnection();
        String sql = "Select * from qlbv where QLBVngaykh = ? ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,a);
            rs = pst.executeQuery();
        if(rs.next()){
            String sql1 = "Select * from qlbv where QLBVgiokh = ? ";
            try {
                pst = conn.prepareStatement(sql1);
                pst.setString(1,b);
                rs = pst.executeQuery();
            if(rs.next()){
                String sql3 = "DELETE FROM qlcx where QLCXngaykh = ? and QLCXgiokh = ?";
                try {
                    pst = conn.prepareStatement(sql3);
                    pst.setString(1, a);
                    pst.setString(2, b);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Các chuyến xe đã khởi hành đã bị xóa khởi hệ thống!\n Hệ thống đã cập nhập! ");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "e");
                }
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "e");
            }
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "e");
        }
        App.setRoot("QuanLyVeXe");     
    }
        
    @FXML
    public void SwitchtoAddCX() throws IOException {
        App.setRoot("AddChuyenXe");
    }
    @FXML
    public void SwitchtoLogin() throws IOException {
        App.setRoot("Login");
    }
    @FXML
    public void SwitchtoTC() throws IOException {
        App.setRoot("TrangChu");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
