/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.model;

import com.ecommerce.beans.Panier;
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
public class PanierModel {
    
    public static void acheter(int qte , int idProduit , String login){
        
        String sql = "INsert into detail(idProduit , login , qte ,villeLivraison , payeLivraison) values ( ? , ? , ? , 'not set' , 'not set')" ;
        try {
            PreparedStatement st = Connexion.getConnection().prepareStatement(sql);
            st.setInt(1,idProduit) ;
            st.setString(2,login) ;
            st.setInt(3,qte) ;
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PanierModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Panier> getPanier(String login ){
        String sql = "select * from detail where login = ?" ;
        List<Panier> lst = new ArrayList<>() ;
        Panier p = null ;
        try {
            PreparedStatement st = Connexion.getConnection().prepareStatement(sql) ;
            st.setString(1,login) ;
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                p = new Panier();
                p.setLogin(rs.getString("login"));
                p.setIdProduit(rs.getInt("idProduit"));
                p.setQte(rs.getInt("qte"));
                lst.add(p) ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanierModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst ;
    }
}
