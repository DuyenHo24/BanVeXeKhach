/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import com.mycompany.htbanve.service.AdminServices;
import com.mycompany.htbanve.service.JdbcUtils;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private AnchorPane panedangki;
    @FXML
    private TextField txtdktk;
    @FXML
    private TextField txtdkpass;
    @FXML
    private TextField txtdkemail;
    @FXML
    private TextField txtMaht;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
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
    public void AdminLogin(ActionEvent event) throws IOException{
        try {
            conn = JdbcUtils.getConnection();
            String sql = "Select * from admin where Admintk = ? and Adminpass = ? ";
            pst = conn.prepareStatement(sql);
            pst.setString(1,txttentk.getText());
            pst.setString(2, txtpass.getText());
            rs = pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
                App.setRoot("ChonChucNang");
            }else
                JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu");    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @FXML
    public void addAdmin(ActionEvent event){
        String EMAIL_PATTERN = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        boolean kt = Pattern.matches(EMAIL_PATTERN, txtdkemail.getText());
        conn = JdbcUtils.getConnection();
        if("".equals(txttentk.getText()) || "".equals(txtpass.getText()))
        {
            JOptionPane.showMessageDialog(null, "Không thể để trống tài khoản và mật khẩu");
        }else
        if("KTPM".equals(txtMaht.getText())){            
            if(kt == false){
                JOptionPane.showConfirmDialog(null, "Nhập sai quy định email!");
                }else if(txtdktk.getText().length() < 6 || txtdkpass.getText().length() < 6 || txtdktk.getText().length() > 45 || txtdkpass.getText().length() > 45){
                    JOptionPane.showConfirmDialog(null, "Tài khoản và mật khẩu phải hơn 6 kí tự");
                    }else
                        {          
                                try {
                                    AdminServices.addTKAdmin(txtdktk.getText(), txtdkpass.getText(), txtdkemail.getText());
                                    JOptionPane.showMessageDialog(null, "Đăng kí thành công!");
                                    panelogin.setVisible(true);
                                    panedangki.setVisible(false);
                                    txtMaht.clear();
                                    txtdkpass.clear();
                                    txtdktk.clear();
                                    txtdkemail.clear();
                                } catch (SQLException e) {
                                    JOptionPane.showConfirmDialog(null, "Tên đăng nhập đã có");
                                }
                        }
        }else{
            JOptionPane.showMessageDialog(null, "Sai mã hệ thống!");
        }
    }
}
