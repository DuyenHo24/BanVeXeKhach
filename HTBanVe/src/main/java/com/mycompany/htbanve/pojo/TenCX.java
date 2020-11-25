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
public class TenCX {
    private int idTenCX;
    private String NameCX;
    public TenCX(int idTenCX,String NameCX){
        this.idTenCX = idTenCX;
        this.NameCX = NameCX;
    }

    @Override
    public String toString() {
        return this.NameCX; //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * @return the idTenCX
     */
    public int getIdTenCX() {
        return idTenCX;
    }

    /**
     * @param idTenCX the idTenCX to set
     */
    public void setIdTenCX(int idTenCX) {
        this.idTenCX = idTenCX;
    }

    /**
     * @return the NameCX
     */
    public String getNameCX() {
        return NameCX;
    }

    /**
     * @param NameCX the NameCX to set
     */
    public void setNameCX(String NameCX) {
        this.NameCX = NameCX;
    }
}
