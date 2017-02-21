 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.model;

import com.ecommerce.beans.Produit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author youssouf
 */
public class ProduitModel {
    
    
    
    public static Produit getById(int id){
        Produit p = null ;
        String sql = "select * from Produit where idProduit = ?" ;
        try {
            PreparedStatement st = Connexion.getConnection().prepareStatement(sql );
            st.setInt(1, id);
            ResultSet rs = st.executeQuery() ;
            while(rs.next()){
               p = new Produit();
                p.setIdProduit(rs.getInt("idProduit"));
                p.setIdMarque(rs.getInt("idMarque"));
                p.setLibelle(rs.getString("libelle"));
                p.setLogo(rs.getString("logo"));
                p.setPrixVent(rs.getInt("PrixVent"));
                p.setPrixAchat(rs.getInt("prixAchat"));
                p.setDateEnrg(rs.getDate("dateEnrg"));
                p.setIdSousGenre(rs.getByte("idSousGenre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return p ; 
        
    }
    
    public static List<Produit> allByMarque(int idMarque){
        
                String sqlSelect ="SELECT * FROM produit where idMarque = "+idMarque ;
        
        List<Produit> lst =new ArrayList<>() ;
        
        try {
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);
            
            Produit p ;
            
            while (rs.next())
            {
                p = new Produit();
                p.setIdProduit(rs.getInt("idProduit"));
                p.setIdMarque(rs.getInt("idMarque"));
                p.setLibelle(rs.getString("libelle"));
                p.setLogo(rs.getString("logo"));
                p.setPrixVent(rs.getInt("PrixVent"));
                p.setPrixAchat(rs.getInt("prixAchat"));
                p.setDateEnrg(rs.getDate("dateEnrg"));
                p.setIdSousGenre(rs.getByte("idSousGenre"));
                lst.add(p);
            }
            
            st.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MarqueModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lst ;
    }
    
     public static List<Produit> allByGenre(int idGenre){
        String sqlSelect ="SELECT * FROM produit where idSousGenre IN (select idSousGenre from sousgenre where idGenre = ? )" ;
        
        List<Produit> lst =new ArrayList<>() ;
        
        try {
            PreparedStatement st = Connexion.getConnection().prepareStatement(sqlSelect);
            st.setInt(1, idGenre);
            ResultSet rs = st.executeQuery() ;
            Produit p ;
            
            while (rs.next())
            {
                p = new Produit();
                p.setIdProduit(rs.getInt("idProduit"));
                p.setIdMarque(rs.getInt("idMarque"));
                p.setLibelle(rs.getString("libelle"));
                p.setLogo(rs.getString("logo"));
                p.setPrixVent(rs.getInt("PrixVent"));
                p.setPrixAchat(rs.getInt("prixAchat"));
                p.setDateEnrg(rs.getDate("dateEnrg"));
                p.setIdSousGenre(rs.getByte("idSousGenre"));
                lst.add(p);
            }
            
            st.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MarqueModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lst ;
    }
    
        public static List<Produit> all(){
        
                String sqlSelect ="SELECT * FROM Produit" ;
        
        List<Produit> lst =new ArrayList<>() ;
        
        try {
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);
            
            Produit p ;
            
            while (rs.next())
            {
                p = new Produit();
                p.setIdProduit(rs.getInt("idProduit"));
                p.setIdMarque(rs.getInt("idMarque"));
                p.setLibelle(rs.getString("libelle"));
                p.setLogo(rs.getString("logo"));
                p.setPrixVent(rs.getInt("PrixVent"));
                p.setPrixAchat(rs.getInt("prixAchat"));
                p.setDateEnrg(rs.getDate("dateEnrg"));
                p.setIdSousGenre(rs.getByte("idSousGenre"));
                lst.add(p);
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(MarqueModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst ;
    }
        public static void add(Produit p){
        try {
            String sql = "insert into Produit ( idMarque , libelle , prixVent , prixAchat , idSousGenre ) "
                    + "values( ?, ? , ? , ? ,   ? )";
            PreparedStatement st = Connexion.getConnection().prepareStatement(sql) ;
            st.setInt(1, p.getIdMarque());
            st.setString(2, p.getLibelle());
            st.setInt(3, p.getPrixVent());
            st.setInt(4, p.getPrixAchat());
           
            st.setInt(5, p.getIdSousGenre());
            
            st.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProduitModel.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        public static List<Produit> sugestProduits(String key){
            String sqlSelect ="SELECT * FROM Produit where libelle like '%"+key+"%'" ;
        List<Produit> lst =new ArrayList<>() ;
        
        try {
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);
            
            Produit p ;
            
            while (rs.next())
            {
                p = new Produit();
                p.setIdProduit(rs.getInt("idProduit"));
                p.setIdMarque(rs.getInt("idMarque"));
                p.setLibelle(rs.getString("libelle"));
                p.setLogo(rs.getString("logo"));
                p.setPrixVent(rs.getInt("PrixVent"));
                p.setPrixAchat(rs.getInt("prixAchat"));
                p.setDateEnrg(rs.getDate("dateEnrg"));
                p.setIdSousGenre(rs.getByte("idSousGenre"));
                lst.add(p);
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(MarqueModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst ;
            
        }
        
        public static void delete(int idpro){
            String sql ="delete from produit where idproduit = ?"        ;
        try {            
            PreparedStatement st = Connexion.getConnection().prepareStatement(sql);
            st.setInt(1, idpro);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitModel.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        
}
    

