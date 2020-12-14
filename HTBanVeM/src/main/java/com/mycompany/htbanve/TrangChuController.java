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
    public void SwitchtoLogin() throws IOException{
        App.setRoot("Login");
    }
    @FXML
    public void SwitchtoKH() throws IOException{
        App.setRoot("MuaVe");
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
//        String a = LocalDate.now().toString();
//        tesst.setText(a);
    }

}
