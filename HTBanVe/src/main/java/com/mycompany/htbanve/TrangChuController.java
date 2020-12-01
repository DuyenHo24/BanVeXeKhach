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
public class TrangChuController implements Initializable {

    @FXML
    public void SwitchtoAddCX() throws IOException {
        App.setRoot("AddChuyenXe");
    }
    @FXML
    public void SwitchtoKH() throws IOException{
        App.setRoot("Muave");
    }
    @FXML 
    public void SwitchtoQLVX() throws IOException{
        App.setRoot("QuanLyVeXe");
    }
    @FXML
    public void ExitTC() throws IOException {
        System.exit(0);
    }
        
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
