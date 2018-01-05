/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  DAO;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Classes.Form;
import  Classes.Offer;
import  DBLinking.DAO;

/**
 *
 * @author mk
 */
public class DAOOffer extends DAO implements IDAOOffer {

    private String id = "id";
    private String name = "name";
    private String imageSource = "imageSource";
    private String state = "state";
    private DAOForm daoForm=new DAOForm();

    public DAOOffer() {
        super();
    }

    @Override
    public int executeQuery(String query,Offer o){
        statement = createStatement(query);
        try {
            statement.setString(1, o.getName());
            statement.setString(2, o.getImageSource());
            statement.setBoolean(3, o.getState());
            statement.setInt(4, o.getId());
            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOffer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    @Override
    public int create(Offer o) {
        o.setId(executeQuery("INSERT INTO Offer(name,imageSource,state,id) Values(?,?,?,?);",o));
        return o.getId();
    }

    @Override
    public int update(Offer o) {
        return executeQuery("UPDATE Offer SET name=?,imageSource=?,state=? WHERE id=?;",o);
    }

    @Override
    public int delete(int id) {

        statement = createStatement("DELETE FROM Offer WHERE id=?;");
        try {

            statement.setInt(1, id);
     return  statement.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(DAOOffer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }


    @Override
    public Offer find(int id) {
        try {
            statement = createStatement("SELECT * FROM Offer WHERE id=?;");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Offer o = ResultSetToObject(rs);
                o.setForms(getForms(o));
                return o;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOffer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Offer> getAll() {
            statement = createStatement("SELECT * FROM Offer");
            return executeToArray();
    }

    @Override
    public Offer ResultSetToObject(ResultSet rs) {
        try {
            Offer o = new Offer(rs.getInt(id), rs.getString(name), rs.getString(imageSource),rs.getBoolean(state));
            return o;
        } catch (SQLException ex) {
            Logger.getLogger(DAOOffer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Form> getForms(Offer o) {
        return daoForm.findByOffer(o);
    }

    @Override
    public ArrayList<Offer> executeToArray() {

        try {
            ResultSet rs = statement.executeQuery();
            ArrayList<Offer> list = new ArrayList<Offer>();
            while (rs.next()) {
                Offer o = ResultSetToObject(rs);
                o.setForms(getForms(o));
                list.add(o);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DAOOffer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
