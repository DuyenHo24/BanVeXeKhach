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
public class GioKH {
    private String idGioKH;
    private String nameGioKH;
    public GioKH(String id, String name){
        this.idGioKH= id;
        this.nameGioKH = name;
    }

    @Override
    public String toString() {
        return this.nameGioKH; //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * @return the idGioKH
     */
    public String getIdGioKH() {
        return idGioKH;
    }

    /**
     * @param idGioKH the idGioKH to set
     */
    public void setIdGioKH(String idGioKH) {
        this.idGioKH = idGioKH;
    }

    /**
     * @return the nameGioKH
     */
    public String getNameGioKH() {
        return nameGioKH;
    }

    /**
     * @param nameGioKH the nameGioKH to set
     */
    public void setNameGioKH(String nameGioKH) {
        this.nameGioKH = nameGioKH;
    }
   
}
