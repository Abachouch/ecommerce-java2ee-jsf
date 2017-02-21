/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.controler;

import com.ecommerce.beans.Commentaire;
import com.ecommerce.beans.Genre;
import com.ecommerce.beans.Marque;
import com.ecommerce.beans.Panier;
import com.ecommerce.beans.Produit;
import com.ecommerce.beans.SousGenre;
import com.ecommerce.model.CommentaireModel;
import com.ecommerce.model.GenreModel;
import com.ecommerce.model.MarqueModel;
import com.ecommerce.model.PanierModel;
import com.ecommerce.model.ProduitModel;
import com.ecommerce.model.SousGenreModel;
import com.ecommerce.model.User;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author youssouf
 */
@Named(value = "controler")
@ManagedBean
@SessionScoped
public class Controler implements Serializable {

    private int selectedGenre = 1;

    // <editor-fold desc="url parametres">
    public String getUrlParamValue(String param) {
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String s = (String) requestMap.get(param);
        return s;
    }
    // </editor-fold>
    // <editor-fold desc="Marque">
    public List<Marque> allMarques() {
        return MarqueModel.all();
    }
    public Marque getMarqueById(int id){
        return MarqueModel.getById(id);
    }
    // </editor-fold>
    // <editor-fold desc="Genre & SousGenre">
    public List<Genre> allGenre() {
        return GenreModel.all();
    }
    public List<SousGenre> allSousGenreByGenre() {
        return SousGenreModel.allByGenre(selectedGenre);
    }
    public void genreEvent(ValueChangeEvent event) {
        selectedGenre = (int) event.getNewValue();
    }
    public SousGenre getSousGenreById(int id){
        return SousGenreModel.getById(id) ;
    }
    // </editor-fold>
    // <editor-fold desc="Produit">
    public Produit getProduitById(String id) {
        return ProduitModel.getById(Integer.parseInt(id));
    }
    public List<Produit> allProduitsByIdMarque() {
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String s = (String) requestMap.get("id");
        return ProduitModel.allByMarque(Integer.parseInt(s));
    }
    public List<Produit> allProduitByGenre(int genre) {
        return ProduitModel.allByGenre(genre);
    }
    public List<Produit> allProduitByLibelle(String key) {
        return ProduitModel.sugestProduits(key);
    }
    public List<Produit> allProduits() {
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String key = (String) requestMap.get("key");
        String cat = (String) requestMap.get("cat");

        if (key != null) {
            return allProduitByLibelle(key);
        }
        if (cat != null) {
            return allProduitByGenre(Integer.parseInt(cat));
        }
        return ProduitModel.all();
    }
    
    public void supprimerProduit(Produit produit){
        ProduitModel.delete(produit.getIdProduit());
    }
    
    public String produitInfo(int idProduit) {
        //return "ecommerce/visiteur/produitdetail.xhtml?id="+idProduit+"&faces-redirect=true" ;
        return "visiteur/login.xhtml";
    }
    public void addProduit(Produit produit) {
        produit.setDateEnrg(new Date());
        ProduitModel.add(produit);
    }
    // </editor-fold>
    // <editor-fold desc="commentaire">
    public List<Commentaire> allCommentaire(int idProduit) {
        return CommentaireModel.all(idProduit);
    }
    public String addComment(Commentaire commentaire) {
        //get the username
        HttpServletRequest request = (HttpServletRequest) javax.faces.context.FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //get id product 
        Map<String, String> parameterMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String param = parameterMap.get("idproject");
        int idProduit = Integer.parseInt(param);

        commentaire.setIdProduit(idProduit);
        commentaire.setDateCommentaire(new Date());
        commentaire.setLogin(user.getLogin());
        CommentaireModel.add(commentaire);
        return "/visiteur/produitdetail?id=" + idProduit + "&faces-redirect=true";
    }
    // </editor-fold>
    public List<Panier> getPanier(){
        HttpServletRequest request = (HttpServletRequest) javax.faces.context.FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        return PanierModel.getPanier(user.getLogin());
        }
    public  String acheter(Panier p){
        HttpServletRequest request = (HttpServletRequest) javax.faces.context.FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        Map<String, String> parameterMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String param = parameterMap.get("idproject");
        
        int idProduit = Integer.parseInt(param);
        PanierModel.acheter(p.getQte() ,idProduit, user.getLogin()) ;
        return "/visiteur/panier?faces-redirect=true";
        }
}
