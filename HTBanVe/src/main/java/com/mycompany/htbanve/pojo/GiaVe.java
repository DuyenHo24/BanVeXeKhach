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
public class GiaVe {
    private String idGiaVe;
    private String nameGiave;
    public GiaVe(String id, String name){
        this.idGiaVe = id;
        this.nameGiave = name;
    }

    @Override
    public String toString() {
        return this.nameGiave; //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * @return the idGiaVe
     */
    public String getIdGiaVe() {
        return idGiaVe;
    }

    /**
     * @param idGiaVe the idGiaVe to set
     */
    public void setIdGiaVe(String idGiaVe) {
        this.idGiaVe = idGiaVe;
    }

    /**
     * @return the nameGiave
     */
    public String getNameGiave() {
        return nameGiave;
    }

    /**
     * @param nameGiave the nameGiave to set
     */
    public void setNameGiave(String nameGiave) {
        this.nameGiave = nameGiave;
    }
}
