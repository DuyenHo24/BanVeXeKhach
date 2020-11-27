/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import com.mycompany.htbanve.pojo.TenCX;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS-LAPTOP
 */
public class AddChuyenXeController implements Initializable {
    @FXML
    private TextField txtTenCX;
    @FXML
    public void QuayLai() throws IOException{
        App.setRoot("TrangChu");
    }
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void addTenCXHandler(ActionEvent event){
        String idtcx = UUID.randomUUID().toString();
        TenCX q = new TenCX(idtcx,this.txtTenCX.getText());
        try {
            Utils.addTenCX(q);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Add tencx successful!");
            alert.show();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Add tencx failed: "+e.getMessage());
            alert.show();
        }
    }
    
}
