/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.pojo;


public class BienSoXe {
    private String idBienSoXe;
    private String nameBienSoXe;
    public BienSoXe(String idBienSoXe,String nameBienSoXe){
        this.idBienSoXe= idBienSoXe;
        this.nameBienSoXe= nameBienSoXe;
    }

    @Override
    public String toString() {
        return this.nameBienSoXe; //To change body of generated methods, choose Tools | Templates.
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
     * @return the nameBienSoXe
     */
    public String getNameBienSoXe() {
        return nameBienSoXe;
    }

    /**
     * @param nameBienSoXe the nameBienSoXe to set
     */
    public void setNameBienSoXe(String nameBienSoXe) {
        this.nameBienSoXe = nameBienSoXe;
    }
}

