/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.model;

import com.ecommerce.beans.SousGenre;
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
public class SousGenreModel {
    public static List<SousGenre> allByGenre(int idGenre){
        List<SousGenre> lst = new ArrayList<>() ;
        SousGenre sg ;
        String sql = "Select * from sousGenre where idgenre = ?" ;
        try {
            PreparedStatement p = Connexion.getConnection().prepareStatement(sql);
            p.setInt(1, idGenre);
            ResultSet rs =   p.executeQuery() ;
             while(rs.next()){
                 sg=new SousGenre(rs.getInt("idSousGenre"),rs.getInt( "idGenre"), rs.getString("sousgenre"));
                 lst.add(sg);
             }
        } catch (SQLException ex) {
            Logger.getLogger(SousGenreModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst ;
    }
    
    public static SousGenre getById(int idSousGenre){
        SousGenre sg = null;
        String sql = "Select * from sousGenre where idSousGenre = ?" ;
        try {
            PreparedStatement p = Connexion.getConnection().prepareStatement(sql);
            p.setInt(1, idSousGenre);
            ResultSet rs =   p.executeQuery() ;
             while(rs.next()){
                 sg=new SousGenre(rs.getInt("idSousGenre"),rs.getInt( "idGenre"), rs.getString("sousgenre"));
             }
        } catch (SQLException ex) {
            Logger.getLogger(SousGenreModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sg ;
    }
    
}
