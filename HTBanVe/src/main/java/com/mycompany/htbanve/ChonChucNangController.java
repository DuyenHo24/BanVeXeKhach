/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author ASUS-LAPTOP
 */
public class ChonChucNangController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML 
    public void SwitchtoQLVX() throws IOException{
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
