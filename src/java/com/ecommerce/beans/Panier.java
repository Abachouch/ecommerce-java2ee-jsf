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
public class Panier {
    
    private int idProduit ;
    private String login  ;
    private String adressLivraison ;
    private String villeLivraison ;
    private String payeLivraison ;
    private String libelleProduit ;
    private int qte ;

    public Panier() {
    }

    public Panier(int idProduit, String login, int qte) {
        this.idProduit = idProduit;
        this.login = login;
        this.qte = qte;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAdressLivraison() {
        return adressLivraison;
    }

    public void setAdressLivraison(String adressLivraison) {
        this.adressLivraison = adressLivraison;
    }

    public String getVilleLivraison() {
        return villeLivraison;
    }

    public void setVilleLivraison(String villeLivraison) {
        this.villeLivraison = villeLivraison;
    }

    public String getPayeLivraison() {
        return payeLivraison;
    }

    public void setPayeLivraison(String payeLivraison) {
        this.payeLivraison = payeLivraison;
    }

    public String getLibelleProduit() {
        return libelleProduit;
    }

    public void setLibelleProduit(String libelleProduit) {
        this.libelleProduit = libelleProduit;
    }
    
    
    
    
}
