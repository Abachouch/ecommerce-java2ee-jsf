/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.beans;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped ;
/**
 *
 * @author youssouf
 */
@ManagedBean (name="produit")
@ViewScoped
public class Produit {

    public Produit(int idMarque, String libelle, String logo, int prixVent, int prixAchat, Date dateEnrg, int idSousGenre) {
        this.idMarque = idMarque;
        this.libelle = libelle;
        this.logo = logo;
        this.prixVent = prixVent;
        this.prixAchat = prixAchat;
        this.dateEnrg = dateEnrg;
        this.idSousGenre = idSousGenre;
    }

    public Produit(int idMarque, String libelle, int prixVent, int prixAchat, int idSousGenre) {
        this.idMarque = idMarque;
        this.libelle = libelle;
        this.prixVent = prixVent;
        this.prixAchat = prixAchat;
        this.idSousGenre = idSousGenre;
    }




    

    public Produit(int idProduit, int idMarque, String libelle, String logo, int prixVent, int prixAchat, Date dateEnrg, int idSousGenre) {
        this.idProduit = idProduit;
        this.idMarque = idMarque;
        this.libelle = libelle;
        this.logo = logo;
        this.prixVent = prixVent;
        this.prixAchat = prixAchat;
        this.dateEnrg = dateEnrg;
        this.idSousGenre = idSousGenre;
    }

    public Produit(int idProduit) {
        this.idProduit = idProduit;
    }

    public Produit() {
    }
    
    private int idProduit ;
	private int idMarque ;
	private String libelle ;
	private String logo ;
	private int prixVent ;
	private int prixAchat ;
	private Date dateEnrg ;
	private int idSousGenre ;

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(int idMarque) {
        this.idMarque = idMarque;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getPrixVent() {
        return prixVent;
    }

    public void setPrixVent(int prixVent) {
        this.prixVent = prixVent;
    }

    public int getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Date getDateEnrg() {
        return dateEnrg;
    }

    public void setDateEnrg(Date dateEnrg) {
        this.dateEnrg = dateEnrg;
    }

    public int getIdSousGenre() {
        return idSousGenre;
    }

    public void setIdSousGenre(int idSousGenre) {
        this.idSousGenre = idSousGenre;
    }
}
