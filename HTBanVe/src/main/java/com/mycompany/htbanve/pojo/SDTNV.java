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
public class SDTNV {
    private String idSDTNV;
    private String nSDTNV;
    public SDTNV(String id, String n){
        this.idSDTNV = id;
        this.nSDTNV = n;
    }

    @Override
    public String toString() {
        return this.nSDTNV; //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * @return the idSDTNV
     */
    public String getIdSDTNV() {
        return idSDTNV;
    }

    /**
     * @param idSDTNV the idSDTNV to set
     */
    public void setIdSDTNV(String idSDTNV) {
        this.idSDTNV = idSDTNV;
    }

    /**
     * @return the nSDTNV
     */
    public String getnSDTNV() {
        return nSDTNV;
    }

    /**
     * @param nSDTNV the nSDTNV to set
     */
    public void setnSDTNV(String nSDTNV) {
        this.nSDTNV = nSDTNV;
    }
}
