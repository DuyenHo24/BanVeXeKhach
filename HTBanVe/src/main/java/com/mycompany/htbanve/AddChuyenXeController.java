/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import com.mycompany.htbanve.pojo.QLCXs;
import com.mycompany.htbanve.service.JdbcUtils;
import com.mycompany.htbanve.service.QLCXsServices;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    @FXML
    private TextField filterField;
    
    ObservableList<QLCXs> list1;
    ObservableList<QLCXs> dataList;
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
//            FindCX();
        } catch (SQLException ex) {
            Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public void AddQLCX(){
         conn = JdbcUtils.getConnection();
        //date
        if ("".equals(txtid.getText()) || "".equals(txttencx.getText()) || "".equals(txtbsx.getText()) || "".equals(txtgiokh.getText()) || "".equals(txtngaykh.getText()) || "".equals(txtgiave.getText()) 
                || "".equals(txttennv.getText()) || "".equals(txtsdtnv.getText()) || "".equals(txtloaixe.getText()))
        {
            
            JOptionPane.showMessageDialog(null, "Chua nhap du thong tin","about",JOptionPane.INFORMATION_MESSAGE);
        }
        else{     
            String sql = "INSERT INTO qlcx (idQLCX,QLCXtencx,QLCXbsx,QLCXgiokh,QLCXngaykh,QLCXgiave,QLCXtennv,QLCXsdtnv,QLCXloaixe)values(?,?,?,?,?,?,?,?,?)";
            try {
                pst = conn.prepareStatement(sql);
                pst .setInt(1, Integer.parseInt(txtid.getText()));
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
//                FindCX();
            } catch (Exception e) {
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
        txttencx.setText(colNameCX.getCellData(index));
        txtbsx.setText(colbsx.getCellData(index));
        txtloaixe.setText(colloaixe.getCellData(index));
        //date
        txtngaykh.setText(colngaykh.getCellData(index));
        txtgiokh.setText(colgiokh.getCellData(index));
        txtgiave.setText(colgiave.getCellData(index));
        txttennv.setText(coltennv.getCellData(index));
        txtsdtnv.setText(colsdtnv.getCellData(index));
        
    }
    public void UpdateQLCX() throws SQLException{
        this.tbvQLCX.getItems().addAll(QLCXsServices.getDataQLCXs());
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNameCX.setCellValueFactory(new PropertyValueFactory<>("tencx"));
        colbsx.setCellValueFactory(new PropertyValueFactory<>("bsx"));
        colloaixe.setCellValueFactory(new PropertyValueFactory<>("loaixe"));
        colgiokh.setCellValueFactory(new PropertyValueFactory<>("giokh"));
        //date
        colngaykh.setCellValueFactory(new PropertyValueFactory<>("ngaykh"));
        colgiave.setCellValueFactory(new PropertyValueFactory<>("giave"));
        coltennv.setCellValueFactory(new PropertyValueFactory<>("tennv"));
        colsdtnv.setCellValueFactory(new PropertyValueFactory<>("sdtnv"));

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
            String sql = "UPDATE qlcx set idQLCX= '"+value1+ "', QLCXtencx= '"+value2+"',QLCXbsx= '"+value3+"',QLCXloaixe= '"+
                    value4+"',QLCXngaykh= '"+value5+"',QLCXgiokh= '"+value6+"',QLCXgiave= '"+
                    value7+"',QLCXtennv= '"+value8+"',QLCXsdtnv= '"+value9+"' where idQLCX = '"+value1+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "update");
            tbvQLCX.getItems().clear();
            UpdateQLCX();
//            FindCX();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void DeleteQLCX(){
        conn = JdbcUtils.getConnection();
        String sql = "DELETE FROM qlcx where idQLCX = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtid.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "delete");
            tbvQLCX.getItems().clear();
            UpdateQLCX();
//            FindCX();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
//    @FXML
//    void FindCX() throws SQLException{
//        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
//        colNameCX.setCellValueFactory(new PropertyValueFactory<>("tencx"));
//        colbsx.setCellValueFactory(new PropertyValueFactory<>("bsx"));
//        colloaixe.setCellValueFactory(new PropertyValueFactory<>("loaixe"));
//        colgiokh.setCellValueFactory(new PropertyValueFactory<>("giokh"));
//        //date
//        colngaykh.setCellValueFactory(new PropertyValueFactory<>("ngaykh"));
//        colgiave.setCellValueFactory(new PropertyValueFactory<>("giave"));
//        coltennv.setCellValueFactory(new PropertyValueFactory<>("tennv"));
//        colsdtnv.setCellValueFactory(new PropertyValueFactory<>("sdtnv"));
//        
//        dataList =  (ObservableList<QLCXs>) QLCXsServices.getDataQLCXs();
//        tbvQLCX.setItems(dataList);
//        FilteredList<QLCXs> filteredData = new FilteredList<>(dataList, b -> true);
//        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate((QLCXs person) -> {
//                                    if (newValue == null || newValue.isEmpty()){
//                                        return true;
//                                    }
//                                    String lowerCaSeFilter = newValue.toLowerCase();
//                                    
//                                    if (person.getTencx().toLowerCase().indexOf(lowerCaSeFilter) != -1){
//                                        return true;
//                                    } else if (person.getBsx().toLowerCase().indexOf(lowerCaSeFilter) != -1){
//                                        return true;
//                                    }else if (person.getGiokh().toLowerCase().indexOf(lowerCaSeFilter) != -1){
//                                            return true;
//                                    }else if (person.getNgaykh().toLowerCase().indexOf(lowerCaSeFilter) != -1){
//                                            return true;
//                                    }else if (person.getGiave().toLowerCase().indexOf(lowerCaSeFilter) != -1){
//                                            return true;        
//                                    }else if (person.getTennv().toLowerCase().indexOf(lowerCaSeFilter) != -1){
//                                            return true; 
//                                    }else 
//                                       if ( person.getSdtnv().toLowerCase().indexOf(lowerCaSeFilter) != -1)
//                                           return true;
//                                           else
//                                                return false;
//                                                   
//            });                                                                             
//        });
//        SortedList<QLCXs> sortedData = new SortedList<>(filteredData);
//        sortedData.comparatorProperty().bind(tbvQLCX.comparatorProperty());
//        tbvQLCX.setItems(sortedData);
//        
//    }
}
    

