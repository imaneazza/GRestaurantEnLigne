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
import  Classes.Detail;
import  Classes.Form;
import  Classes.Ingredient;
import  DBLinking.DAO;

/**
 *
 * @author mk
 */
public class DAODetail extends DAO implements IDAODetail {

    private String formId = "formId";
    private String ingredientId = "ingredientId";
    private String obligatory = "obligatory";
    private String qteMin = "qteMin";
    private String qteMax = "qteMax";
    private DAOForm daoForm = new DAOForm();
    private DAOIngredient daoIngredient = new DAOIngredient();

    public DAODetail() {
        super();
    }

    @Override
    public int create(Detail o) {
        statement = createStatement("INSERT INTO detail(formId,ingredientId,obligatory,qteMin,qteMax) Values(?,?,?,?,?);");
        try {
            statement.setInt(1, o.getForm().getId());
            statement.setInt(2, o.getIngredient().getId());
            statement.setBoolean(3, o.getObligatory());
            statement.setInt(4, o.getMin());
            statement.setInt(5, o.getMax());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAODetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int update(Detail o) {
        statement = createStatement("UPDATE detail SET obligatory=?,qteMin=?,qteMax=? WHERE formId=?,ingredientId=?;");
        try {
            statement.setBoolean(1, o.getObligatory());
            statement.setInt(2, o.getMin());
            statement.setInt(3, o.getMax());
            statement.setInt(4, o.getForm().getId());
            statement.setInt(5, o.getIngredient().getId());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAODetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    @Override
    public int delete(int id) {
        statement = createStatement("DELETE FROM detail WHERE id=?;");
        try {
            statement.setInt(1, id);
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAODetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Detail find(int id) {
        try {
            statement = createStatement("SELECT * FROM form WHERE id=?;");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Detail o = ResultSetToObject(rs);
                o.setForm(daoForm.find(rs.getInt(formId)));
                o.setIngredient(daoIngredient.find(rs.getInt(ingredientId)));
                return o;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAODetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public HashMap<Integer, Detail> getAll() {
        HashMap<Integer, Detail> list = new HashMap<Integer, Detail>();
        try {
            statement = createStatement("SELECT * FROM form");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Detail o = ResultSetToObject(rs);
                o.setForm(daoForm.find(rs.getInt(formId)));
                o.setIngredient(daoIngredient.find(rs.getInt(ingredientId)));
                list.put(list.size(), o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAODetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Detail ResultSetToObject(ResultSet rs) {
        try {
            Detail o = new Detail(rs.getBoolean(obligatory), rs.getInt(qteMin), rs.getInt(qteMax));
            return o;
        } catch (SQLException ex) {
            Logger.getLogger(DAODetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public HashMap<Integer, Detail> findByForm(Form form) {
        HashMap<Integer, Detail> list = new HashMap<Integer, Detail>();
        try {
            statement = createStatement("SELECT * FROM detail WHERE formId=?;");
            statement.setInt(1, form.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Detail o = ResultSetToObject(rs);
                o.setForm(form);
                o.setIngredient(daoIngredient.find(rs.getInt(ingredientId)));
                list.put(list.size(), o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAODetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public HashMap<Integer, Detail> findByIngredient(Ingredient ingredient) {
        HashMap<Integer, Detail> list = new HashMap<Integer, Detail>();
        try {
            statement = createStatement("SELECT * FROM detail WHERE ingredientId=?;");
            statement.setInt(1, ingredient.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Detail o = ResultSetToObject(rs);
                o.setForm(daoForm.find(rs.getInt(formId)));
                o.setIngredient(ingredient);
                list.put(list.size(), o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAODetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
