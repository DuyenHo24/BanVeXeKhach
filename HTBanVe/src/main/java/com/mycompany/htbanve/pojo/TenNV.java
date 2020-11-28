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
public class TenNV {
    private String idTenNV;
    private String nameNV;
    public TenNV(String id, String name){
        this.idTenNV = id;
        this.nameNV = name;
    }

    @Override
    public String toString() {
        return this.nameNV; //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * @return the idTenNV
     */
    public String getIdTenNV() {
        return idTenNV;
    }

    /**
     * @param idTenNV the idTenNV to set
     */
    public void setIdTenNV(String idTenNV) {
        this.idTenNV = idTenNV;
    }

    /**
     * @return the nameNV
     */
    public String getNameNV() {
        return nameNV;
    }

    /**
     * @param nameNV the nameNV to set
     */
    public void setNameNV(String nameNV) {
        this.nameNV = nameNV;
    }
}
