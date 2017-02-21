/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author youssouf
 */
@ManagedBean
@SessionScoped
public class User {

    private String login;
    private String password;
    private int IdRole;
    private boolean isLoged;

    public User(String login, String password, int IdRole) {
        this.login = login;
        this.password = password;
        this.IdRole = IdRole;
    }

    public User() {
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
        return IdRole;
    }

    public void setIdRole(int IdRole) {
        this.IdRole = IdRole;
    }
    public String logIn() {
        String sql = "select * from Personne where login = ? and password = ? and idRole in (1 ,2 )  ";
        PreparedStatement p;
        try {
            p = Connexion.getConnection().prepareStatement(sql);

            p.setString(1, this.login);
            p.setString(2, this.password);

            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                this.setIdRole(rs.getInt("idRole"));
                this.isLoged  =true ;
                return "/visiteur/produit.xhtml?faces-redirect=true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.isLoged  =false ;
        return "/visiteur/login.xhtml?err=login&faces-redirect=true";
        
    }
    public boolean getIsLoged() {
        return this.isLoged;
    }
    public String logOut(){
        isLoged = false ;
        this.password = null;
        this.login = null ;
        this.IdRole = 0 ;
        return "/visiteur/produit.xhtml?faces-redirect=true" ;
    }
    
}
