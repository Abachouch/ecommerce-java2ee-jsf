/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.model;

import java.util.Date;

/**
 *
 * @author youssouf
 */
public class Personne {
    

        private String login ;
        private String password;
        private int idRole ; 
        private String nom ;
        private String prenom ;
        private Date dateNaaissance ;
        private String email ;
        private String tel ;
        private String adress ;
        private String ville ;
        private String paye ;

    public Personne() {
    }

    public Personne(String login, String password, int idRole, String nom, String prenom, Date dateNaaissance, String email, String tel, String adress, String ville, String paye) {
        this.login = login;
        this.password = password;
        this.idRole = idRole;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaaissance = dateNaaissance;
        this.email = email;
        this.tel = tel;
        this.adress = adress;
        this.ville = ville;
        this.paye = paye;
    }

    public String getPaye() {
        return paye;
    }

    public void setPaye(String paye) {
        this.paye = paye;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaaissance() {
        return dateNaaissance;
    }

    public void setDateNaaissance(Date dateNaaissance) {
        this.dateNaaissance = dateNaaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdress() {
        return adress;
    }
    
    public void setAdress(String adress) {
        this.adress = adress;
    }
    
    public String getVille() {
        return ville;
    }
    
    public void setVille(String ville) {
        this.ville = ville;
    }
}
