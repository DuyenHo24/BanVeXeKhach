/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import com.mycompany.htbanve.service.AdminServices;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS-LAPTOP
 */
public class LoginController implements Initializable {
     @FXML
    private AnchorPane panelogin;

    @FXML
    private TextField txttentk;

    @FXML
    private PasswordField txtpass;

    @FXML
    private Button txtxnlogin;

    @FXML
    private AnchorPane panedangki;

    @FXML
    private TextField txtdktk;

    @FXML
    private TextField txtdkpass;

    @FXML
    private TextField txtdkemail;

    @FXML
    private Button btxndk;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    @FXML 
    public void SwitchtoTC() throws IOException{
        App.setRoot("TrangChu");
    }
    public void LoginpaneShow(){
        panelogin.setVisible(true);
        panedangki.setVisible(false);
        
    }
    public void SignuppnaneShow(){
        panelogin.setVisible(false);
        panedangki.setVisible(true);
        
    }

    @FXML
    public void AdminLogin(ActionEvent event){
        conn = AdminServices.ConnectionAdmin();
        String sql = "Select * from admin where Admintk = ? and Adminpass = ? ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,txttentk.getText());
            pst.setString(2, txtpass.getText());
            rs = pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
                App.setRoot("ChonChucNang");
            }else
                JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void addAdmin(ActionEvent event){
        conn = AdminServices.ConnectionAdmin();
        String sql = "Insert into admin (Admintk,Adminpass,Adminemail) value (?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtdktk.getText());
            pst.setString(2, txtdkpass.getText());
            pst.setString(3, txtdkemail.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Đăng kí thành công!");
            
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }
}