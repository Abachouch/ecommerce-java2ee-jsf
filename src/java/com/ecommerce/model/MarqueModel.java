/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.model;

import com.ecommerce.beans.Marque;
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
public class MarqueModel {

    public static List<Marque> all() {

        String sqlSelect = "SELECT * FROM marque ";

        List<Marque> lst = new ArrayList<>();

        try {
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sqlSelect);

            Marque m;


            while (rs.next()) {
                m = new Marque();
                m.setIdMarque(rs.getInt("idMarque"));
                m.setDiscription(rs.getString("discription"));
                m.setLogo(rs.getString("logo"));
                m.setMarque(rs.getString("marque"));


                lst.add(m);
            }

            st.close();


        } catch (SQLException ex) {
            Logger.getLogger(MarqueModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lst;

    }

    public static Marque getById(int id) {

        String sqlSelect = "SELECT * FROM marque where idMarque = ? ";

        Marque m = null;

        try {
            PreparedStatement st = Connexion.getConnection().prepareStatement(sqlSelect);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery(sqlSelect);
            
            while (rs.next()) {
                m = new Marque();
                m.setIdMarque(rs.getInt("idMarque"));
                m.setDiscription(rs.getString("discription"));
                m.setLogo(rs.getString("logo"));
                m.setMarque(rs.getString("marque"));
            }

            st.close();


        } catch (SQLException ex) {
            Logger.getLogger(MarqueModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return m;

    }
}
