/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.beans;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author youssouf
 */
@ManagedBean
@RequestScoped
public class Commentaire {

    private int idComment;
    private int idProduit;
    private String txt;
    private String login;
    private Date dateCommentaire;

    public Commentaire(String txt) {
        this.txt = txt;
    }

    public Commentaire(int idComment, int idProduit, String txt, String login, Date dateCommentaire) {
        this.idComment = idComment;
        this.idProduit = idProduit;
        this.txt = txt;
        this.login = login;
        this.dateCommentaire = dateCommentaire;
    }

    public Commentaire(int idProduit, String txt, String login) {
        this.idProduit = idProduit;
        this.txt = txt;
        this.login = login;
    }

    public Commentaire() {
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getDateCommentaire() {
        return dateCommentaire;
    }

    public void setDateCommentaire(Date dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }
}
