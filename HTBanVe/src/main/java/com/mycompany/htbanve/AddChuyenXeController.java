/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import com.mycompany.htbanve.pojo.BienSoXe;
import com.mycompany.htbanve.pojo.GiaVe;
import com.mycompany.htbanve.pojo.GioKH;
import com.mycompany.htbanve.pojo.LoaiXe;
import com.mycompany.htbanve.pojo.SDTNV;
import com.mycompany.htbanve.service.Utils;
import com.mycompany.htbanve.pojo.TenCX;
import com.mycompany.htbanve.pojo.TenNV;
import com.mycompany.htbanve.service.JdbcUtils;
import com.mysql.cj.MysqlConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private TextField txtKeyQLCX;
    @FXML 
    private TextField txtBienSX;
    @FXML
    private TextField txtLoaiXe;
    @FXML
    private TextField txtGioKH;
    @FXML
    private TextField txtGiaVe;
    @FXML
    private TextField txtTenNV;
    @FXML
    private TextField txtSDTNV;
    @FXML
    private TableView<TenCX> tbvQLCX;
    @FXML
    private TableColumn<TenCX, Integer> colid;
    @FXML
    private TableColumn<TenCX, String> colNameCX;
    ObservableList<TenCX> list1;
    

    public void QuayLai() throws IOException{
        App.setRoot("TrangChu");
    }
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            // TODO
//            //load tencx
//           this.loadDLQLCX();
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
        colid.setCellValueFactory(new PropertyValueFactory<TenCX,Integer>("idtencx"));
        colNameCX.setCellValueFactory(new PropertyValueFactory<TenCX,String>("idNameCX"));
        
        list1 = JdbcUtils.getDatabase();
        tbvQLCX.setItems(list1);

    } 
    
    public void addTenCXHandler(ActionEvent event){
        // lay dl xuong
        String idtcx = UUID.randomUUID().toString();
        String idbsx = UUID.randomUUID().toString();
        String idloaixe = UUID.randomUUID().toString();
        String idGioKH = UUID.randomUUID().toString();
        String idGiaVe = UUID.randomUUID().toString();
        String idtnv = UUID.randomUUID().toString();
        String idsdtnv = UUID.randomUUID().toString();
        //lay dl xuong
        TenCX q = new TenCX(idtcx,this.txtTenCX.getText());
        BienSoXe b = new BienSoXe(idbsx, this.txtBienSX.getText());
        LoaiXe c = new LoaiXe(idloaixe, this.txtLoaiXe.getText());
        GioKH g = new GioKH(idGioKH,this.txtGioKH.getText());
        GiaVe gv = new GiaVe(idGiaVe, this.txtGiaVe.getText());
        TenNV nv = new TenNV(idtnv, this.txtTenNV.getText());
        SDTNV sdt = new SDTNV(idsdtnv, this.txtSDTNV.getText());
        

        try {
            Utils.addTenCX(q,b,c,g,gv,nv,sdt);         
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Add imformation successful!");
            alert.show();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Add information failed: "+e.getMessage());
            alert.show();
        }
    }
        
    public void loadDLQLCX() throws SQLException{
//        TableColumn clTenCX = new TableColumn("Tên chuyến xe");
//        clTenCX.setCellValueFactory(new PropertyValueFactory("NameCX"));
//        TableColumn clBienSoXe = new TableColumn("Biển số xe");
//        clBienSoXe.setCellValueFactory(new PropertyValueFactory("namebiensoxe"));
//        
//        
//        this.tbvQLCX.getColumns().addAll(clTenCX);
//        this.tbvQLCX.setItems(FXCollections.observableArrayList(Utils.getTenCX("")));
    }
    
}
