/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import  Classes.Offre;
import  DBLinking.DAO;

/**
 *
 * @author mk
 */
public class DAOOffre extends DAO implements IDAOOffre{

    private String id = "id";
    private String name = "name";
    private String imageSource = "imageSource";
    private String state = "state";
    
    private DAOForm daoForm = new DAOForm();

    public DAOOffre() {
        super();
    }
    @Override
    public int create(Offre o) {
        statement = createStatement("INSERT INTO offre(nom,imageSource,state) Values(?,?,?);");
        try {
            statement.setString(1, o.getName());
            statement.setString(2, o.getImageSource());
            statement.setBoolean(3, o.getState());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int update(Offre o) {
        statement = createStatement("UPDATE offre SET nom=?,imageSource=?,state=?,categoryId=? WHERE id=?;");
        try {
            statement.setString(1, o.getName());
            statement.setString(2, o.getImageSource());
            statement.setBoolean(3, o.getState());
            statement.setInt(5, o.getId());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    @Override
    public int delete(int id) {
        statement = createStatement("DELETE FROM offre WHERE id=?;");
        try {
            statement.setInt(1, id);
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Offre find(int id) {
        try {
            statement = createStatement("SELECT * FROM offre WHERE id=?;");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Offre o = ResultSetToObject(rs);
                o.setForms(daoForm.findByOffre(o));
                return o;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public HashMap<Integer, Offre> getAll() {
        HashMap<Integer, Offre> list = new HashMap<Integer, Offre>();
        try {
            statement = createStatement("SELECT * FROM offre");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Offre o = ResultSetToObject(rs);
                o.setForms(daoForm.findByOffre(o));
                list.put(o.getId(), o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Offre ResultSetToObject(ResultSet rs) {
        try {
            Offre o = new Offre(rs.getInt(id), rs.getString(name), rs.getString(imageSource),rs.getBoolean(state));
            return o;
        } catch (SQLException ex) {
            Logger.getLogger(DAOOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
