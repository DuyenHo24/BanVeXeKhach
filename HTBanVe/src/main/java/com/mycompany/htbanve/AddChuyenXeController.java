/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import com.mycompany.htbanve.pojo.QLCXs;
import com.mycompany.htbanve.service.JdbcUtils;
import com.mycompany.htbanve.service.QLCXsServices;
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
    
//    @FXML
//    private TableView<QLCXs> tbvQLCX;
//    @FXML
//    private TableColumn<QLCXs, Integer> colid;
//    @FXML
//    private TableColumn<QLCXs, String> colNameCX;
//    @FXML
//    private TableColumn<QLCXs, String> colbsx;
//    @FXML
//    private TableColumn<QLCXs, String> colloaixe;
//    @FXML
//    private TableColumn<QLCXs, String> colgiokh;
//    @FXML
//    private TableColumn<QLCXs, String> colngaykh;
//    @FXML
//    private TableColumn<QLCXs, String> colghe;
//    @FXML
//    private TableColumn<QLCXs, String> colgiave;
//    @FXML
//    private TableColumn<QLCXs, String> coltennv;
//    @FXML
//    private TableColumn<QLCXs, String> colstdnv;
    
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
    @FXML TableView<QLCXs> table;

    

    public void QuayLai() throws IOException{
        App.setRoot("TrangChu");
    }
    /**
     * Initializes the controller class.
     */
    
    public static void loadCX(TableView<QLCXs> tbv) throws SQLException{
        
         TableColumn colma = new TableColumn("Mã chuyến xe");
         colma.setCellValueFactory(new PropertyValueFactory("id"));
         TableColumn colName = new TableColumn("Tên chuyến xe");
         colName.setCellValueFactory(new PropertyValueFactory("tencx"));
         TableColumn colbsx = new TableColumn("Biển số xe");
         colbsx.setCellValueFactory(new PropertyValueFactory("bsx"));
         TableColumn collx = new TableColumn("Loại xe");
         collx.setCellValueFactory(new PropertyValueFactory("loaixe"));
         TableColumn colgkh = new TableColumn("Giờ khởi hành");
         colgkh.setCellValueFactory(new PropertyValueFactory("giokh"));
         TableColumn colnkh = new TableColumn("Ngày khởi hành");
         colnkh.setCellValueFactory(new PropertyValueFactory("ngaykh"));
         TableColumn colgia = new TableColumn("Giá vé");
         colgia.setCellValueFactory(new PropertyValueFactory("giave")); 
         TableColumn colghe = new TableColumn("Ghế");
         colghe.setCellValueFactory(new PropertyValueFactory("ghe")); 
         TableColumn coltennv = new TableColumn("Tên nhân viên");
         coltennv.setCellValueFactory(new PropertyValueFactory("tennv"));
         TableColumn colsdt= new TableColumn("SDT");
         colsdt.setCellValueFactory(new PropertyValueFactory("sdtnv"));
         
         tbv.getColumns().addAll(colma, colName,colbsx,collx,
                                 colgkh,colnkh,colgia,colghe,coltennv,colsdt);
         
        tbv.setItems(FXCollections.observableArrayList(QLCXsServices.getDataQLCXs()));
     }
    
    public void themCX(ActionEvent event){
       QLCXs cx = new QLCXs(0, this.txttencx.getText(), this.txtBSX.getText()
               , this.txtloaixe.getText(), this.txtgiokh.getText(), 
               "", this.txtgiave.getText(), this.txtghe.getText(), 
               this.txttennv.getText(), this.txtsdtnv.getText());
        
        try {
            QLCXsServices.Add_QLCX(cx);
        } catch (SQLException ex) {
            Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
//        colid.setCellValueFactory(new PropertyValueFactory<QLCXs,Integer>("idQLCX"));
//        colNameCX.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("tenCX"));
//        colbsx.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("bsx"));
//        colloaixe.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("loaixe"));
//        colgiokh.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("giokh"));
//        colngaykh.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("ngaykh"));
//        colghe.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("ghe"));
//        colgiave.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("giave"));
//        coltennv.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("tennv"));
//        colstdnv.setCellValueFactory(new PropertyValueFactory<QLCXs,String>("sdtnv"));
//               
//       // list1 = JdbcUtils.getDataQLCXs();
//        tbvQLCX.setItems(list1);
    } 
}
