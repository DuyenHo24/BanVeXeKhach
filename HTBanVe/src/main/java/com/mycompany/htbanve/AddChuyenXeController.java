/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import com.mycompany.htbanve.pojo.QLCXs;
import com.mycompany.htbanve.service.JdbcUtils;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private TableColumn<QLCXs, String> colgiave;
    @FXML
    private TableColumn<QLCXs, String> coltennv;
    @FXML
    private TableColumn<QLCXs, String> colsdtnv;
    @FXML
    private TextField txtid;
    @FXML
    private TextField txttencx;
    @FXML
    private TextField txtbsx;
    @FXML
    private TextField txtngaykh;
    @FXML
    private TextField txtgiokh;
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
    PreparedStatement pst;
    

    public void QuayLai() throws IOException{
        App.setRoot("TrangChu");
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UpdateQLCX();
    } 
    public void AddQLCX(){
        conn = JdbcUtils.ConnectDb();
        //date
        if ("".equals(txttencx.getText()) || "".equals(txtbsx.getText()) || "".equals(txtgiokh.getText()) || "".equals(txtngaykh.getText()) || "".equals(txtgiave.getText()) 
                || "".equals(txttennv.getText()) || "".equals(txtsdtnv.getText()) || "".equals(txtloaixe.getText()))
        {
            JOptionPane.showMessageDialog(null, "Chua nhap du thong tin","about",JOptionPane.INFORMATION_MESSAGE);
        }
        else{     
            String sql = "INSERT INTO qlcx (QLCXtencx,QLCXbsx,QLCXgiokh,QLCXngaykh,QLCXgiave,QLCXtennv,QLCXsdtnv,QLCXloaixe)values(?,?,?,?,?,?,?,?)";
            try {
                pst = conn.prepareStatement(sql);
                
                pst.setString(1,txttencx.getText());
                pst.setString(2,txtbsx.getText());
                pst.setString(3,txtgiokh.getText());
                //date
                pst.setString(4,txtngaykh.getText());
                pst.setString(5,txtgiave.getText());
                pst.setString(6,txttennv.getText());
                pst.setString(7,txtsdtnv.getText());
                pst.setString(8,txtloaixe.getText());
                pst.execute();

                JOptionPane.showMessageDialog(null, "QLCXs add succes");
                UpdateQLCX();
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }        
    }
    @FXML
    void getSelected(MouseEvent event){
        index = tbvQLCX.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
        txtid.setText(colid.getCellData(index).toString());
        txttencx.setText(colNameCX.getCellData(index).toString());
        txtbsx.setText(colbsx.getCellData(index).toString());
        txtloaixe.setText(colloaixe.getCellData(index).toString());
        //date
        txtngaykh.setText(colngaykh.getCellData(index).toString());
        txtgiokh.setText(colgiokh.getCellData(index).toString());
        txtgiave.setText(colgiave.getCellData(index).toString());
        txttennv.setText(coltennv.getCellData(index).toString());
        txtsdtnv.setText(colsdtnv.getCellData(index).toString());
        
    }
    public void UpdateQLCX(){
        colid.setCellValueFactory(new PropertyValueFactory<QLCXs,Integer>("idQLCX"));
        colNameCX.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("tenCX"));
        colbsx.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("bsx"));
        colloaixe.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("loaixe"));
        colgiokh.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("giokh"));
        //date
        colngaykh.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("ngaykh"));
        colgiave.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("giave"));
        coltennv.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("tennv"));
        colsdtnv.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("sdtnv"));
        
        list1 = JdbcUtils.getDataQLCXs();
        tbvQLCX.setItems(list1);
    }
    public void Edit(){
        try {
            conn = JdbcUtils.ConnectDb();
            String value1 = txtid.getText();
            String value2 = txttencx.getText();
            String value3 = txtbsx.getText();
            String value4 = txtloaixe.getText();
//            LocalDate value4 = txtngaykh.getValue();
            String value5 = txtngaykh.getText();
            String value6 = txtgiokh.getText();
            String value7 = txtgiave.getText();
            String value8 = txttennv.getText();
            String value9 = txtsdtnv.getText();
            String sql = "UPDATE qlcx set idQLCX= '"+value1+"', QLCXtencx= '"+value2+"',QLCXbsx= '"+value3+"',QLCXloaixe= '"+
                    value4+"',QLCXngaykh= '"+value5+"',QLCXgiokh= '"+value6+"',QLCXgiave= '"+
                    value7+"',QLCXtennv= '"+value8+"',QLCXsdtnv= '"+value9+"' where idQLCX = '"+value1+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "update");
            UpdateQLCX();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void DeleteQLCX(){
        conn = JdbcUtils.ConnectDb();
        String sql = "DELETE FROM qlcx where idQLCX = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtid.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "delete");
            UpdateQLCX();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
