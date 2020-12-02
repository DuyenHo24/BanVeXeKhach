/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import com.mycompany.htbanve.pojo.QLCXs;
import com.mycompany.htbanve.service.JdbcUtils;
import com.mycompany.htbanve.service.QLCXsServices;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
        try {
            UpdateQLCX();
        } catch (SQLException ex) {
            Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public void AddQLCX(){
        Connection conn = JdbcUtils.getConnection();
        //date
        if ("".equals(txtid.getText()) ||"".equals(txttencx.getText()) || "".equals(txtbsx.getText()) || "".equals(txtgiokh.getText()) || "".equals(txtngaykh.getText()) || "".equals(txtgiave.getText()) 
                || "".equals(txttennv.getText()) || "".equals(txtsdtnv.getText()) || "".equals(txtloaixe.getText()))
        {
            
            JOptionPane.showMessageDialog(null, "Chua nhap du thong tin","about",JOptionPane.INFORMATION_MESSAGE);
        }
        else{     
            String sql = "INSERT INTO qlcx (QLCXid,QLCXtencx,QLCXbsx,QLCXgiokh,QLCXngaykh,QLCXgiave,QLCXtennv,QLCXsdtnv,QLCXloaixe)values(?,?,?,?,?,?,?,?,?)";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1,txtid.getText());
                pst.setString(2,txttencx.getText());
                pst.setString(3,txtbsx.getText());
                pst.setString(4,txtgiokh.getText());
                //date
                pst.setString(5,txtngaykh.getText());
                pst.setString(6,txtgiave.getText());
                pst.setString(7,txttennv.getText());
                pst.setString(8,txtsdtnv.getText());
                pst.setString(9,txtloaixe.getText());
                pst.execute();

                JOptionPane.showMessageDialog(null, "QLCXs add succes");
                tbvQLCX.getItems().clear();
                UpdateQLCX();
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }        
    }
    @FXML
    void getSelected (MouseEvent event){
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
    public void UpdateQLCX() throws SQLException{
        this.tbvQLCX.getItems().addAll(QLCXsServices.getDataQLCXs());
        colid.setCellValueFactory(new PropertyValueFactory<QLCXs,Integer>("id"));
        colNameCX.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("tencx"));
        colbsx.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("bsx"));
        colloaixe.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("loaixe"));
        colgiokh.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("giokh"));
        //date
        colngaykh.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("ngaykh"));
        colgiave.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("giave"));
        coltennv.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("tennv"));
        colsdtnv.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("sdtnv"));
        TableColumn clAction = new TableColumn();
        clAction.setCellFactory(p -> {
            Button btn = new Button("Delete");
            btn.setOnAction(et ->{
                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                confirm.setContentText("Are you sure to delete this CX?");
//                confirm.showAndWait().ifPresent(res -> {
//                        if (res == ButtonType.OK) {
//                            TableCell cl = (TableCell)((Button)et.getSource()).getParent();
//                            QLCXs q = (QLCXs)cl.getTableRow().getItem();
//                            try {
//                                DeleteQLCX();
//                                AddChuyenXeController.this.tbvQLCX.getItems().clear();
//                                UpdateQLCX();
//                                Alert a = new Alert(Alert.AlertType.INFORMATION);
//                                a.show();
//                            }catch (Exception e) {
//                                System.err.print(e.getMessage());
//                            }}
//                });
            });
            TableCell cell = new TableCell();
            cell.setGraphic(btn);
            return cell;
        });
        this.tbvQLCX.getColumns().addAll(clAction);
        
//        list1 = (ObservableList<QLCXs>) JdbcUtils.getQLCXs();
//        tbvQLCX.setItems(list1);
    }
    public void Edit(){
        try {
            conn = JdbcUtils.getConnection();
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
            tbvQLCX.getItems().clear();
            UpdateQLCX();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
//    public void DeleteQLCX(String id) throws SQLException{
//        Connection conn = JdbcUtils.getConnection();
//        String sql = "DELETE FROM qlcx where idQLCX = ?";
//        conn.setAutoCommit(false);
////        try {
//            pst = conn.prepareStatement(sql);
//            pst.setString(1, getId());
//            pst.executeUpdate();
////            JOptionPane.showMessageDialog(null, "delete");
////            tbvQLCX.getItems().clear();
////            UpdateQLCX();
////        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, e);
////        }
//        conn.commit();
//    }
    
}
