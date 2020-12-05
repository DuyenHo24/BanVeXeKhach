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
import java.util.ResourceBundle;
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
 *
 * @author ASUS
 */
public class MuaVeController implements Initializable {

    @FXML private TextField txttencx;
    @FXML private TextField txtbsx;
    @FXML private TextField txtgiokh;@FXML
    private TextField txttennv;
    @FXML private TextField txtsdtnv;
    @FXML private TextField txtloaixe;
    @FXML private TextField txtgiave;
    @FXML private TextField txtid;
    @FXML private TextField txtngaykh;
    @FXML private TextField txttenkh;
    @FXML private TextField txtsdtkh;
    @FXML private TextField txtghe;
    @FXML private TextField txtMaGhe;
    @FXML private TableView<QLCXs> tbvQLCX;
    @FXML private TableColumn<QLCXs, Integer> colid;
    @FXML private TableColumn<QLCXs, String> colNameCX;
    @FXML private TableColumn<QLCXs, String> colbsx;
    @FXML private TableColumn<QLCXs, String> colloaixe;
    @FXML private TableColumn<QLCXs, String> colngaykh;
    @FXML private TableColumn<QLCXs, String> colgiokh;
    @FXML private TableColumn<QLCXs, String> colgiave;
    @FXML private TableColumn<QLCXs, String> coltennv;
    @FXML private TableColumn<QLCXs, String> colghe;
    @FXML private TableColumn<QLCXs, String> colsdtnv;
    @FXML private TextField filterField;
    
    ObservableList<QLCXs> dataList;
    int index = -1;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            UpdateQLCX();
            FindCX();
        } catch (SQLException ex) {
            Logger.getLogger(MuaVeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void QuayLaiTC() throws IOException{
        App.setRoot("TrangChu");
    }
    // Load dl len table view
    public void UpdateQLCX() throws SQLException{
        ObservableList<QLCXs> data = FXCollections.observableArrayList(QLCXsServices.getDataQLCX());
        tbvQLCX.setItems(data);
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
        colghe.setCellValueFactory(new PropertyValueFactory<>("ghe"));
    }
    // Lay du lieu tu table view vao textfield
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
        txtghe.setText(colghe.getCellData(index));
        
    }
    // them ve vao csdl
    public void AddQLBV(){
         conn = JdbcUtils.getConnection();
        //date
        // dieu kien k cho phep de trong o dl
        if ("".equals(txtid.getText()) || "".equals(txttencx.getText()) || "".equals(txtbsx.getText()) 
                || "".equals(txtgiokh.getText()) || "".equals(txtngaykh.getText()) || "".equals(txtgiave.getText()) 
                || "".equals(txttennv.getText()) || "".equals(txtsdtnv.getText()) || "".equals(txtloaixe.getText()) 
                || "".equals(txttenkh.getText()) || "".equals(txtsdtkh.getText()) || "".equals(txtghe.getText()))
        {
            
            JOptionPane.showMessageDialog(null, "Chua nhap du thong tin","about",JOptionPane.INFORMATION_MESSAGE);
        }
        else if("0".equals(txtghe.getText())){
            JOptionPane.showMessageDialog(null, "Chuyến xe đã hết ghế trống\n Mời bạn chọn chuyến xe khác");            
                  
        }else
        {                 
            String sql = "INSERT INTO qlbv (QLBVtencx,QLBVbsx,QLBVgiokh,QLBVngaykh"
                    + ",QLBVgiave,QLBVloaixe,QLBVtenkh,QLBVsdtkh,QLBVtennv,QLBVsdtnv,QLBVghe)values(?,?,?,?,?,?,?,?,?,?,?)";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1,txttencx.getText());
                pst.setString(2,txtbsx.getText());
                pst.setString(3,txtgiokh.getText());
                //date
                pst.setString(4,txtngaykh.getText());
                pst.setString(5,txtgiave.getText());
                pst.setString(6,txtloaixe.getText());
                pst.setString(7,txttenkh.getText());
                pst.setString(8,txtsdtkh.getText());
                pst.setString(9,txttenkh.getText());
                pst.setString(10,txtsdtkh.getText());
                pst.setString(11,txtMaGhe.getText()); 
                pst.execute();
                try {
                    Integer a = (Integer.parseInt(txtghe.getText()) - 1);
                    String value1 = a.toString();
                    String value2 = txttencx.getText();
                    String sql1 = "UPDATE qlcx set QLCXghe= '"+value1+"' where QLCXtencx = '"+value2+"' ";
                    pst = conn.prepareStatement(sql1);
                    pst.execute(); 
                } catch (Exception e) {
                }
         

                JOptionPane.showMessageDialog(null, "Quý khách đã đặt vé thành công \n"
                        + " Lưu ý : Hãy đến quầy nhân viên để nhận vé trong 30p !!! \n"
                        + "!!!!Quá 30p vé sẽ bị hủy!!!!\n"
                        + "Chân thành cảm ơn quý khách!!!");
                UpdateQLCX();
                FindCX();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }        
    }
        @FXML
        void FindCX() throws SQLException {
            dataList = QLCXsServices.getDataQLCX();
            tbvQLCX.setItems(dataList);
            FilteredList<QLCXs> filteredData = new FilteredList<>(dataList, b -> true);
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
                                        }else if (person.getTennv().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                                return true; 
                                        }else 
                                           if ( person.getSdtnv().toLowerCase().indexOf(lowerCaSeFilter) != -1)
                                               return true;
                                           
                                               else
                                                    return false;

                });                                                                             
            });
            SortedList<QLCXs> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(tbvQLCX.comparatorProperty());
            tbvQLCX.setItems(sortedData);

        }
}
