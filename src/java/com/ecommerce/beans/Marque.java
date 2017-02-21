/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.beans;

import javax.faces.bean.ManagedBean ;
import javax.faces.bean.RequestScoped ;
/**
 * @author youssouf
 */
@ManagedBean (name="marque")
@RequestScoped
public class Marque {
    
    private int idMarque ;
    private String marque;
    private String logo ; 
    private String discription;

    public Marque() {
    }

    public Marque(String marque, String logo, String discription) {
        this.marque = marque;
        this.logo = logo;
        this.discription = discription;
    }

    public Marque(int idMarque, String marque, String logo, String discription) {
        this.idMarque = idMarque;
        this.marque = marque;
        this.logo = logo;
        this.discription = discription;
    }

    public Marque(int idMarque) {
        this.idMarque = idMarque;
    }

    public int getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(int idMarque) {
        this.idMarque = idMarque;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
    
    
}
