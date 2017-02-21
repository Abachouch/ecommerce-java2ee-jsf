/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.model;

import com.ecommerce.beans.Genre;
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
public class GenreModel {

    public static List<Genre> all() {
        List<Genre> lst = new ArrayList<>();
        Genre g;
        String sql = "Select * from genre";
        try {
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                g = new Genre(rs.getInt("idGenre"), rs.getString("genre"));
                lst.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GenreModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
}
