/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import com.mycompany.htbanve.pojo.QLBV;
import com.mycompany.htbanve.service.JdbcUtils;
import com.mycompany.htbanve.service.QLBVServices;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class QuanLyVeXeController implements Initializable {


    @FXML
    private TextField txttencx;

    @FXML
    private TextField txtbsx;

    @FXML
    private TextField txtloaixe;

    @FXML
    private TextField txtngaykh;

    @FXML
    private TextField txtgiokh;

    @FXML
    private TextField txtgiave;

    @FXML
    private TextField txttennv;

    @FXML
    private TextField txtsdtnv;
    @FXML
    private TextField txttenkh;
    @FXML
    private TextField txtsdtkh;
    @FXML
    private TextField txtsoghe;
    @FXML
    private TextField txtidrandom;
    @FXML
    private TextField txtngayht;
    @FXML
    private TextField txtgioht;
    @FXML
    private TableView<QLBV> tbvQLBV;
    @FXML
    private TableColumn<QLBV, String> colNameCX;
    @FXML
    private TableColumn<QLBV, String> colbsx;
    @FXML
    private TableColumn<QLBV, String> colloaixe;
    @FXML
    private TableColumn<QLBV, String> colngaykh;
    @FXML
    private TableColumn<QLBV, String> colgiokh;
    @FXML
    private TableColumn<QLBV, String> colgiave;
    @FXML
    private TableColumn<QLBV, String> coltennv;
    @FXML
    private TableColumn<QLBV, String> colsdtnv;
    @FXML
    private TableColumn<QLBV, String> coltenkh;
    @FXML
    private TableColumn<QLBV, String> colghe;
    @FXML
    private TableColumn<QLBV, String> colsdtkh;
    @FXML
    private TextField filterField;
    @FXML
    private TableColumn<QLBV, String> colidrandom;
    
    int index = -1;
    ObservableList<QLBV> dataList;
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
        try {
            // lay ham bo vao main tu dong load
            ktHTVX();
            UpdateQLBV();
            FindCX();
            
        } catch (SQLException ex) {
            Logger.getLogger(MuaVeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public void QuayLaiTC() throws IOException{
        App.setRoot("ChonChucNang");
    }
    // Load dl len table view
    public void UpdateQLBV() throws SQLException{
        ObservableList<QLBV> data = FXCollections.observableArrayList(QLBVServices.getDataQLBV2());
        tbvQLBV.setItems(data);
        colidrandom.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNameCX.setCellValueFactory(new PropertyValueFactory<>("tencx"));
        colbsx.setCellValueFactory(new PropertyValueFactory<>("bsx"));
        colloaixe.setCellValueFactory(new PropertyValueFactory<>("loaixe"));
        colgiokh.setCellValueFactory(new PropertyValueFactory<>("giokh"));
        colngaykh.setCellValueFactory(new PropertyValueFactory<>("ngaykh"));
        colgiave.setCellValueFactory(new PropertyValueFactory<>("giave"));
        coltennv.setCellValueFactory(new PropertyValueFactory<>("tennv"));
        colsdtnv.setCellValueFactory(new PropertyValueFactory<>("sdtnv"));
        coltenkh.setCellValueFactory(new PropertyValueFactory<>("tenkh"));
        colsdtkh.setCellValueFactory(new PropertyValueFactory<>("sdtkh"));
        colghe.setCellValueFactory(new PropertyValueFactory<>("ghe"));
    }
    // Lay du lieu tu table view vao textfield
    @FXML
    void getSelected (MouseEvent event){
        index = tbvQLBV.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
        txtidrandom.setText(colidrandom.getCellData(index));
        txttencx.setText(colNameCX.getCellData(index));
        txtbsx.setText(colbsx.getCellData(index));
        txtloaixe.setText(colloaixe.getCellData(index));
        txtngaykh.setText(colngaykh.getCellData(index));
        txtgiokh.setText(colgiokh.getCellData(index));
        txtgiave.setText(colgiave.getCellData(index));
        txttenkh.setText(coltenkh.getCellData(index));
        txtsdtkh.setText(colsdtkh.getCellData(index));
        txttennv.setText(coltennv.getCellData(index));
        txtsdtnv.setText(colsdtnv.getCellData(index));
        txtsoghe.setText(colghe.getCellData(index));
        
    }
    public void Edit(){
        if ( "".equals(txttenkh.getText()) || "".equals(txtsdtkh.getText()) 
                || "".equals(txtsoghe.getText()) )
        {           
            JOptionPane.showMessageDialog(null, "Chua nhap du thong tin","about",JOptionPane.INFORMATION_MESSAGE);
        }
        else{     
        try {
            conn = JdbcUtils.getConnection();
            String value3 = txtidrandom.getText();
            String value1 = txttenkh.getText();
            String value2 = txtsdtkh.getText();
            String value4 = txtsoghe.getText();          
            String sql = "UPDATE qlbv set QLBVtenkh= '"+value1+"',QLBVsdtkh= '"+value2+"',QLBVghe='"+value4+"' where QLBVid = '"+value3+"' ";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "update");
            UpdateQLBV();
            FindCX();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
    }
    public void DeleteQLBV(){
        conn = JdbcUtils.getConnection();
        String sql = "DELETE FROM qlbv where QLBVid = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtidrandom.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "delete");
            UpdateQLBV();
            FindCX();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @FXML
    void FindCX() throws SQLException {
        dataList = QLBVServices.getDataQLBV2();
        tbvQLBV.setItems(dataList);
        FilteredList<QLBV> filteredData = new FilteredList<>(dataList, b -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredData.setPredicate(person -> {
                                    if (newValue == null || newValue.isEmpty()){
                                        return true;
                                    }
                                    String lowerCaSeFilter = newValue.toLowerCase();

                                    if (person.getTencx().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                        return true;
                                    } else if (person.getBsx().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                        return true;
                                    }else if (person.getLoaixe().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true;
                                    }else if (person.getGiokh().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true;
                                    }else if (person.getNgaykh().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true;
                                    }else if (person.getGiave().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true;
                                    }else if (person.getTenkh().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true; 
                                    }else if (person.getSdtkh().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true; 
                                    }else if (person.getTennv().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true;
                                    }else if (person.getGhe().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true;
                                    }else 
                                       if ( person.getSdtnv().toLowerCase().indexOf(lowerCaSeFilter) != -1)
                                           return true;

                                           else
                                                return false;

            });                                                                             
        });
        SortedList<QLBV> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tbvQLBV.comparatorProperty());
        tbvQLBV.setItems(sortedData);

    }
    public void ktHTVX(){
       txtngayht.setText(LocalDate.now().toString());
       String a = txtngayht.getText();
       txtgioht.setText(LocalTime.now().toString());
       String b = txtgioht.getText().substring(0, 5);
       if((a.equals(colngaykh.getCellData(index))) && (b.equals(colgiokh.getCellData(index)))){
            conn = JdbcUtils.getConnection();
            String sql = "INSERT INTO qlvedaxuat (QLBVid,QLBVtencx,QLBVbsx,QLBVgiokh,QLBVngaykh"
                    + ",QLBVgiave,QLBVloaixe,QLBVtenkh,QLBVsdtkh,QLBVtennv,QLBVsdtnv,QLBVghe)values(?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
               pst = conn.prepareStatement(sql);
                pst.setString(1,colidrandom.getCellData(index));
                pst.setString(2,colidrandom.getCellData(index));
                pst.setString(3,colidrandom.getCellData(index));
                pst.setString(4,colidrandom.getCellData(index));
                pst.setString(5,colidrandom.getCellData(index));
                pst.setString(6,txtgiave.getText());
                pst.setString(7,txtloaixe.getText());
                pst.setString(8,txttenkh.getText());
                pst.setString(9,txtsdtkh.getText());
                pst.setString(10,txttennv.getText());
                pst.setString(11,txtsdtnv.getText());
                pst.setString(12,txtMaGhe.getText()); 
                pst.execute();
           } catch (Exception e) {
           }
            String sql1 = "INSERT INTO qlcxhethan (idQLCX,QLCXtencx,QLCXbsx,QLCXgiokh,QLCXngaykh,QLCXgiave"
                    + ",QLCXtennv,QLCXsdtnv,QLCXloaixe,QLCXghe)values(?,?,?,?,?,?,?,?,?,?)";
            
            
            String sql2 = "DELETE FROM qlbv where QLBVngaykh = ? and QLBVgiokh = ?";
            String sql3 = "DELETE FROM qlcx where QLCXngaykh = ? and QLCXgiokh = ?";
            try {
                pst = conn.prepareStatement(sql2);
                pst = conn.prepareStatement(sql3);
                pst.setString(1, txtngayht.getText());
                pst.setString(2,txtgioht.getText());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Các chuyến xe đã khởi hành đã bị xóa khởi hệ thống!\n Hệ thống đã cập nhập! ");
                UpdateQLBV();
                FindCX();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }
}
