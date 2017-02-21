/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.model;

import com.ecommerce.beans.Commentaire;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author youssouf
 */
public class CommentaireModel {
    
    public static void add(Commentaire commentaire){
        String sql  = "insert into commentaire(idProduit , txt ,login) values (? , ? ,?) " ;
        try {
            PreparedStatement st = Connexion.getConnection().prepareStatement(sql) ;
            st.setInt(1, commentaire.getIdProduit());
            st.setString(2, commentaire.getTxt());
            st.setString(3, commentaire.getLogin());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static void delete(int idCommentaire){
        
        String sql  = "delete commentaire where idcommentaire  = ?  " ;
        try {
            PreparedStatement st = Connexion.getConnection().prepareStatement(sql) ;
            st.setInt(1, idCommentaire);
           
            st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
     
     public static List<Commentaire> all(int idProduit){
         
         List<Commentaire> lst = new ArrayList<>() ;
         Commentaire c  ;
         String sql = "select * from commentaire where idProduit = ?  " ;
        try {
            PreparedStatement st = Connexion.getConnection().prepareStatement(sql) ;
            st.setInt(1, idProduit);
            ResultSet rs = st.executeQuery() ; 
            while(rs.next()){
                c = new Commentaire() ;
                c.setIdComment(rs.getInt("idComment"));
                c.setIdProduit(rs.getInt("idProduit"));
                c.setLogin(rs.getString("login")) ;
                c.setTxt(rs.getString("txt")) ;
                c.setDateCommentaire(rs.getDate("dateCommentaire")) ;
                lst.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireModel.class.getName()).log(Level.SEVERE, null, ex);
        }
         return lst ;
     }
    
    
}
