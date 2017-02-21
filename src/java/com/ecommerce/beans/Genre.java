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
public class Genre {
    private int idGenre ; 
    private String genre ;

    public Genre() {
    }

    public Genre(int idGenre, String genre) {
        this.idGenre = idGenre;
        this.genre = genre;
    }
    
    

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    
}
