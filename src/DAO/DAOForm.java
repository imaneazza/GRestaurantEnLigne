/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import  Classes.Form;
import  Classes.Offre;
import  DBLinking.DAO;

/**
 *
 * @author mk
 */
public class DAOForm extends DAO implements IDAOForm{

    private String id = "id";
    private String name = "name";
    private String idOffre = "idOffre";
    private DAOOffre daoOffer = new DAOOffre();
    private DAODetail daoDetails=new DAODetail();

    public DAOForm() {
        super();
    }
    @Override
    public int create(Form o) {
        statement = createStatement("INSERT INTO form(nom) Values(?);");
        try {
            statement.setString(1, o.getName());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int update(Form o) {
        statement = createStatement("UPDATE form SET nom=?,offreId=? WHERE id=?;");
        try {
            statement.setString(1, o.getName());
            statement.setInt(2, o.getOffre().getId());
            statement.setInt(5, o.getId());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    @Override
    public int delete(int id) {
        statement = createStatement("DELETE FROM form WHERE id=?;");
        try {
            statement.setInt(1, id);
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Form find(int id) {
        try {
            statement = createStatement("SELECT * FROM form WHERE id=?;");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Form o = ResultSetToObject(rs);
                o.setOffre(daoOffer.find(rs.getInt(idOffre)));
                o.setDetails(daoDetails.findByForm(o));
                return o;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public HashMap<Integer, Form> getAll() {
        HashMap<Integer, Form> list = new HashMap<Integer, Form>();
        try {
            statement = createStatement("SELECT * FROM form");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Form o = ResultSetToObject(rs);
                o.setOffre(daoOffer.find(rs.getInt(idOffre)));
                o.setDetails(daoDetails.findByForm(o));
                list.put(o.getId(), o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Form ResultSetToObject(ResultSet rs) {
        try {
            Form o = new Form(rs.getInt(id), rs.getString(name));
            return o;
        } catch (SQLException ex) {
            Logger.getLogger(DAOForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @param
     * @return
     */
    @Override
    public HashMap<Integer, Form> findByOffre(Offre offre) {
        HashMap<Integer, Form> list = new HashMap<Integer, Form>();
        try {
            statement = createStatement("SELECT * FROM form WHERE offreId=?;");
            statement.setInt(1,offre.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Form o = ResultSetToObject(rs);
                o.setOffre(offre);
                o.setDetails(daoDetails.findByForm(o));
                list.put(o.getId(), o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }



    
}
