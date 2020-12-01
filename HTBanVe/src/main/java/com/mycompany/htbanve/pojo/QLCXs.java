/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.pojo;

/**
 *
 * @author ASUS-LAPTOP
 */
public class QLCXs {
    private int id;
    private String tencx,bsx,giokh,giave,tennv,sdtnv,loaixe;
    private String ngaykh;
    public QLCXs(int id, String tencx, String bsx,String loaixe, String giokh, String ngaykh, String giave, String tennv, String sdtnv) {
        this.id = id;
        this.tencx = tencx;
        this.bsx = bsx;
        this.loaixe = loaixe;
        this.giokh = giokh;
        this.ngaykh = ngaykh;
        this.giave = giave;
        this.tennv = tennv;
        this.sdtnv = sdtnv;
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTencx(String tencx) {
        this.tencx = tencx;
    }

    public void setBsx(String bsx) {
        this.bsx = bsx;
    }

    public void setGiokh(String giokh) {
        this.giokh = giokh;
    }

    public void setNgaykh(String ngaykh) {
        this.ngaykh = ngaykh;
    }

    public void setGiave(String giave) {
        this.giave = giave;
    }


    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public void setSdtnv(String sdtnv) {
        this.sdtnv = sdtnv;
    }
    public String getLoaixe() {
        return loaixe;
    }

    public void setLoaixe(String loaixe) {
        this.loaixe = loaixe;
    }

    public int getId() {
        return id;
    }

    public String getTencx() {
        return tencx;
    }

    public String getBsx() {
        return bsx;
    }

    public String getGiokh() {
        return giokh;
    }

    public String getNgaykh() {
        return ngaykh;
    }

    public String getGiave() {
        return giave;
    }


    public String getTennv() {
        return tennv;
    }

    public String getSdtnv() {
        return sdtnv;
    }
    
}
