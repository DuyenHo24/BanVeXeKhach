/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import com.mycompany.htbanve.pojo.QLCX;
import com.mycompany.htbanve.service.JdbcUtils;
import com.mycompany.htbanve.service.QLBVServices;
import com.mycompany.htbanve.service.QLCXsServices;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    @FXML private TextField txtgiokh;
    @FXML private TextField txttennv;
    @FXML private TextField txtsdtnv;
    @FXML private TextField txtloaixe;
    @FXML private TextField txtgiave;
    @FXML private TextField txtid;
    @FXML private TextField txtngaykh;
    @FXML private TextField txttenkh;
    @FXML private TextField txtsdtkh;
    @FXML private TextField txtghe;
    @FXML private TextField txtMaGhe;
    @FXML private TableView<QLCX> tbvQLCX;
    @FXML private TableColumn<QLCX, Integer> colid;
    @FXML private TableColumn<QLCX, String> colNameCX;
    @FXML private TableColumn<QLCX, String> colbsx;
    @FXML private TableColumn<QLCX, String> colloaixe;
    @FXML private TableColumn<QLCX, String> colngaykh;
    @FXML private TableColumn<QLCX, String> colgiokh;
    @FXML private TableColumn<QLCX, String> colgiave;
    @FXML private TableColumn<QLCX, String> coltennv;
    @FXML private TableColumn<QLCX, String> colghe;
    @FXML private TableColumn<QLCX, String> colsdtnv;
    @FXML private TextField filterField;
    @FXML private TableColumn<QLCX, String> colidphanbiet;
    
    ObservableList<QLCX> dataList;
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
        ObservableList<QLCX> data = FXCollections.observableArrayList(QLCXsServices.getDataQLCX());
        tbvQLCX.setItems(data);     
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNameCX.setCellValueFactory(new PropertyValueFactory<>("tencx"));
        colbsx.setCellValueFactory(new PropertyValueFactory<>("bsx"));
        colloaixe.setCellValueFactory(new PropertyValueFactory<>("loaixe"));
        colgiokh.setCellValueFactory(new PropertyValueFactory<>("giokh"));
        colngaykh.setCellValueFactory(new PropertyValueFactory<>("ngaykh"));
        colgiave.setCellValueFactory(new PropertyValueFactory<>("giave"));
        coltennv.setCellValueFactory(new PropertyValueFactory<>("tennv"));
        colsdtnv.setCellValueFactory(new PropertyValueFactory<>("sdtnv"));
        colghe.setCellValueFactory(new PropertyValueFactory<>("ghe"));
        colidphanbiet.setCellValueFactory(new PropertyValueFactory<>("idphanbiet"));

    }
    // Lay du lieu tu table view vao textfield
    @FXML
    void getSelected (MouseEvent event){
        index = tbvQLCX.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
        txtid.setText(colidphanbiet.getCellData(index));
        txttencx.setText(colNameCX.getCellData(index));
        txtbsx.setText(colbsx.getCellData(index));
        txtloaixe.setText(colloaixe.getCellData(index));
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
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile("^\\d{10}");
        boolean kt = pattern.matcher(txtsdtkh.getText()).matches();
        if ("".equals(txtid.getText()) || "".equals(txttencx.getText()) || "".equals(txtbsx.getText()) 
                || "".equals(txtgiokh.getText()) || "".equals(txtngaykh.getText()) || "".equals(txtgiave.getText()) 
                || "".equals(txttennv.getText()) || "".equals(txtsdtnv.getText()) || "".equals(txtloaixe.getText()) 
                || "".equals(txttenkh.getText()) || "".equals(txtsdtkh.getText()) || "".equals(txtghe.getText()))
        {            
            JOptionPane.showMessageDialog(null, "Chua nhap du thong tin","about",JOptionPane.INFORMATION_MESSAGE);
        }else if(kt == false){
            JOptionPane.showMessageDialog(null, "Nhap sai số điện thoại: " + txtsdtkh.getText());
        }else if("0".equals(txtghe.getText())){
            JOptionPane.showMessageDialog(null, "Chuyến xe đã hết ghế trống\n Mời bạn chọn chuyến xe khác");                     
        }else
        {                 
            try {
                String rm = UUID.randomUUID().toString();   
                QLBVServices.addVe(rm,txttencx.getText() , txtbsx.getText(),txtgiokh.getText(), txtngaykh.getText(), txtgiave.getText()
                        , txtloaixe.getText(), txttenkh.getText(), txtsdtkh.getText(), txttennv.getText(), txtsdtnv.getText()
                        , txtMaGhe.getText(), txtid.getText());           
                try {
                    Integer a = (Integer.parseInt(txtghe.getText()) - 1);
                    String value1 = a.toString();
                    String value2 = txtid.getText();
                   QLBVServices.GiamGhe(value1, value2);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                JOptionPane.showMessageDialog(null, "Quý khách đã đặt vé thành công \n"
                        + " Lưu ý : Hãy đến quầy nhân viên để nhận vé trong 30p trước giờ khởi hành !!! \n"
                        + "!!!!Quá 30p trước giờ khởi hành vé sẽ bị hủy!!!!\n"
                        + "Chân thành cảm ơn quý khách!!!");
                UpdateQLCX();
                FindCX();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }        
    }
    @FXML
    void FindCX() throws SQLException {
        dataList = QLCXsServices.getDataQLCX();
        tbvQLCX.setItems(dataList);
        FilteredList<QLCX> filteredData = new FilteredList<>(dataList, b -> true);
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
        SortedList<QLCX> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tbvQLCX.comparatorProperty());
        tbvQLCX.setItems(sortedData);
    }
}
