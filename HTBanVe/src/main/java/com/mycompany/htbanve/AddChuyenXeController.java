/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import com.mycompany.htbanve.pojo.QLCXs;
import com.mycompany.htbanve.service.JdbcUtils;
import com.mysql.cj.MysqlConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS-LAPTOP
 */
public class AddChuyenXeController implements Initializable {
    
    @FXML
    private TableView<QLCXs> tbvQLCX;
    @FXML
    private TableColumn<QLCXs, Integer> colid;
    @FXML
    private TableColumn<QLCXs, String> colNameCX;
    @FXML
    private TableColumn<QLCXs, String> colbsx;
    @FXML
    private TableColumn<QLCXs, String> colloaixe;
    @FXML
    private TableColumn<QLCXs, String> colgiokh;
    @FXML
    private TableColumn<QLCXs, String> colngaykh;
    @FXML
    private TableColumn<QLCXs, String> colghe;
    @FXML
    private TableColumn<QLCXs, String> colgiave;
    @FXML
    private TableColumn<QLCXs, String> coltennv;
    @FXML
    private TableColumn<QLCXs, String> colstdnv;
        @FXML
    private TextField txttencx;
    @FXML
    private TextField txtBSX;
    @FXML
    private TextField txtbsx;
    @FXML
    private DatePicker txtngaykh;
    @FXML
    private TextField txtgiokh;
    @FXML
    private TextField txtghe;
    @FXML
    private TextField txttennv;
    @FXML
    private TextField txtsdtnv;
    @FXML
    private TextField txtloaixe;
    @FXML
    private TextField txtgiave;
    ObservableList<QLCXs> list1;
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    

    public void QuayLai() throws IOException{
        App.setRoot("TrangChu");
    }
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        colid.setCellValueFactory(new PropertyValueFactory<QLCXs,Integer>("idQLCX"));
        colNameCX.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("tenCX"));
        colbsx.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("bsx"));
        colloaixe.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("loaixe"));
        colgiokh.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("giokh"));
        colngaykh.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("ngaykh"));
        colghe.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("ghe"));
        colgiave.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("giave"));
        coltennv.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("tennv"));
        colstdnv.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("sdtnv"));
               
        list1 = JdbcUtils.getDataQLCXs();
        tbvQLCX.setItems(list1);
    } 
    public void Add_QLCX(){
        conn = JdbcUtils.ConnectDb();
        String sql = "insert into qlcx (QLCXtencx,QLCXbsx,QLCXgiokh,QLCXngaykh,QLCXghe,QLCXgiave,QLCXtennv,QLCXsdtnv,QLCXloaixe)values(?,?,?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,txttencx.getText());
            pst.setString(2,txtbsx.getText());
            pst.setString(3,txtgiokh.getText());
            pst.setDate(4,Date.valueOf(txtngaykh.getValue()));
            pst.setString(5,txtghe.getText());
            pst.setString(6,txtgiave.getText());
            pst.setString(7,txttennv.getText());
            pst.setString(8,txtsdtnv.getText());
            pst.setString(9,txtloaixe.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "QLCXs add succes");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
}
