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
public class BienSoXe {
    private String idBienSoXe;
    private String BienSoXeCol;
    public BienSoXe(String idBienSoXe,String BienSoXeCol){
        this.idBienSoXe = idBienSoXe;
        this.BienSoXeCol = BienSoXeCol;
    }

    @Override
    public String toString() {
        return this.BienSoXeCol; //To change body of generated methods, choose Tools | Templates.
    }
    

    /**
     * @return the idBienSoXe
     */
    public String getIdBienSoXe() {
        return idBienSoXe;
    }

    /**
     * @param idBienSoXe the idBienSoXe to set
     */
    public void setIdBienSoXe(String idBienSoXe) {
        this.idBienSoXe = idBienSoXe;
    }

    /**
     * @return the BienSoXeCol
     */
    public String getBienSoXeCol() {
        return BienSoXeCol;
    }

    /**
     * @param BienSoXeCol the BienSoXeCol to set
     */
    public void setBienSoXeCol(String BienSoXeCol) {
        this.BienSoXeCol = BienSoXeCol;
    }
}
