/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import com.mycompany.htbanve.pojo.PrintTicket;
import com.mycompany.htbanve.pojo.QLBV;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 *
 * @author ASUS
 */
public class PrintTicketController {
    @FXML Label idLabel;
    @FXML Label tencxLabel;
    @FXML Label bsxLabel;
    @FXML Label ngaykhLabel;
    @FXML Label giokhLabel;
    @FXML Label gheLabel;
    @FXML Label giaLabel;
    @FXML Label tenkhLabel;
    @FXML Label sdtLabel;
    @FXML Label tennvLabel;
    @FXML Label ngayinLabel;
    
//    public void setPrint(PrintTicket pt){
          
//        tencxLabel.setText(ql.getTencx());
//        bsxLabel.setText(pt.getBsx());
//        ngaykhLabel.setText(pt.getNgaykh());
//        giokhLabel.setText(pt.getGiokh());
//        gheLabel.setText(pt.getGhe());
//        giaLabel.setText(pt.getGia());
//        tenkhLabel.setText(pt.getTenkh());
//        sdtLabel.setText(pt.getSdt());
//        tennvLabel.setText(pt.getTennv());
//        ngayinLabel.setText(pt.getNgayin());
//    }
    public void QuayLaiQLBV() throws IOException {
        App.setRoot("QuanLyVeXe");
    } 
}
