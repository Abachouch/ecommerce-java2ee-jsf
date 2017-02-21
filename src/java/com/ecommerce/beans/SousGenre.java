/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecommerce.beans;

import javax.faces.bean.ManagedBean ;
import javax.faces.bean.RequestScoped ;
/**
 *
 * @author youssouf
 */
@ManagedBean 
@RequestScoped 
public class SousGenre {
    private int idSousGenre ;
    private int idGenre ;
    private String sousGenre ; 

    public SousGenre() {
    }

    public SousGenre(int idSousGenre, int idGenre, String sousGenre) {
        this.idSousGenre = idSousGenre;
        this.idGenre = idGenre;
        this.sousGenre = sousGenre;
    }

    public String getSousGenre() {
        return sousGenre;
    }

    public void setSousGenre(String sousGenre) {
        this.sousGenre = sousGenre;
    }

    public int getIdSousGenre() {
        return idSousGenre;
    }

    public void setIdSousGenre(int idSousGenre) {
        this.idSousGenre = idSousGenre;
    }

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }
    
    
    
}
