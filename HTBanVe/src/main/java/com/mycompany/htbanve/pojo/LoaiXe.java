/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.pojo;

/**
 *
 * @author ASUS
 */
public class LoaiXe {
    private String idLoaiXe;
    private String nameLoaiXe;
    public LoaiXe(String id, String name){
        this.idLoaiXe = id;
        this.nameLoaiXe = name;
    }

    @Override
    public String toString() {
        return this.nameLoaiXe; //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * @return the idLoaiXe
     */
    public String getIdLoaiXe() {
        return idLoaiXe;
    }

    /**
     * @param idLoaiXe the idLoaiXe to set
     */
    public void setIdLoaiXe(String idLoaiXe) {
        this.idLoaiXe = idLoaiXe;
    }

    /**
     * @return the nameLoaiXe
     */
    public String getNameLoaiXe() {
        return nameLoaiXe;
    }

    /**
     * @param nameLoaiXe the nameLoaiXe to set
     */
    public void setNameLoaiXe(String nameLoaiXe) {
        this.nameLoaiXe = nameLoaiXe;
    }
    
}
