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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author ASUS-LAPTOP
 */
public class MuaveController implements Initializable {
    @FXML
    public void QuayLai() throws IOException{
    App.setRoot("TrangChu");
    
}
    @FXML
    private GridPane gridpane;
    @FXML
    private ComboBox<TenCX> cbTenCX;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbTenCX.prefWidthProperty().bind(this.gridpane.widthProperty());
        
        try {
            // load du lieu tencx
            this.cbTenCX.getItems().clear();
            this.cbTenCX.getItems().addAll(Utils.getTenCX());
        } catch (SQLException ex) {
            Logger.getLogger(MuaveController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
