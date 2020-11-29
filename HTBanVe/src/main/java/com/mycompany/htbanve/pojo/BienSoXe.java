/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve.pojo;

/**
 *
<<<<<<< HEAD
 * @author ASUS-LAPTOP
 */
public class BienSoXe {
    private String idBienSoXe;
    private String BienSoXeCol;
    public BienSoXe(String idBienSoXe,String BienSoXeCol){
        this.idBienSoXe = idBienSoXe;
        this.BienSoXeCol = BienSoXeCol;
=======
 * @author ASUS
 */
public class BienSoXe {
    private String idBienSoXe;
    private String nameBienSoXe;
    public BienSoXe(String idBienSoXe,String nameBienSoXe){
        this.idBienSoXe= idBienSoXe;
        this.nameBienSoXe= nameBienSoXe;
>>>>>>> a419b28f759293a1519df0365ae0257ef108544f
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return this.BienSoXeCol; //To change body of generated methods, choose Tools | Templates.
    }
    

=======
        return this.nameBienSoXe; //To change body of generated methods, choose Tools | Templates.
    }
    
>>>>>>> a419b28f759293a1519df0365ae0257ef108544f
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
<<<<<<< HEAD
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
=======
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
>>>>>>> a419b28f759293a1519df0365ae0257ef108544f
    }
}
