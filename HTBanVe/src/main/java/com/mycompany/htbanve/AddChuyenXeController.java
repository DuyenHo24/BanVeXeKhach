/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import com.mycompany.htbanve.pojo.BienSoXe;
import com.mycompany.htbanve.service.Utils;
import com.mycompany.htbanve.pojo.TenCX;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ASUS-LAPTOP
 */
public class AddChuyenXeController implements Initializable {
    @FXML
    private TextField txtTenCX;
    @FXML
    private TextField txtBSX;
    @FXML
    private TextField txtKeyQLCX;
    @FXML 
    private TableView<TenCX> tbvtencxQLCX;
    @FXML
    public void QuayLai() throws IOException{
        App.setRoot("TrangChu");
    }
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            //load tencx
            this.loadTenCX();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    } 
    
    public void addTenCXHandler(ActionEvent event){
        String idtcx = UUID.randomUUID().toString();
        String idbsx = UUID.randomUUID().toString();
        TenCX q = new TenCX(idtcx,this.txtTenCX.getText());
        BienSoXe b = new BienSoXe(idbsx, this.txtBSX.getText());
        try {
            Utils.addTenCX(q,b);
            this.tbvtencxQLCX.getItems().clear();
            this.tbvtencxQLCX.setItems(FXCollections.observableArrayList(Utils.getTenCX("")));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Add tencx successful!");
            alert.show();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Add tencx failed: "+e.getMessage());
            alert.show();
        }
    }
    public void loadTenCX() throws SQLException{
        TableColumn clTenCX = new TableColumn("Tên chuyến xe");
        clTenCX.setCellValueFactory(new PropertyValueFactory("NameCX"));
        
        this.tbvtencxQLCX.getColumns().addAll(clTenCX);
        this.tbvtencxQLCX.setItems(FXCollections.observableArrayList(Utils.getTenCX("")));
    }
    
}
