/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import  Classes.Detail;
import  Classes.Form;
import  Classes.Ingrediant;
import  DBLinking.DAO;

/**
 *
 * @author mk
 */
public class DAODetail extends DAO implements IDAODetail {

    private String formId = "idForm";
    private String ingredientId = "idingredient";
    private String obligatory = "obligatory";
    private String qteMin = "qteMin";
    private String qteMax = "qteMax";
    private DAOIngredient daoIngredient = new DAOIngredient();

    public DAODetail() {
        super();
    }

    @Override
    public int executeQuery(String query, Detail o) {
        statement = createStatement(query);
        try {
            statement.setBoolean(1, o.getObligatory());
            statement.setDouble(2, o.getMin());
            statement.setDouble(3, o.getMax());
            statement.setInt(4, o.getFormId());
            statement.setInt(5, o.getIngredient().getId());
            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAODetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Detail> executeToArray() {

        try {
            ResultSet rs = statement.executeQuery();
            ArrayList<Detail> list = new ArrayList<Detail>();
            while (rs.next()) {
                list.add(ResultSetToObject(rs));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DAODetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int create(Detail o) {
        return  executeQuery(String.format("INSERT INTO detail(%s,%s,%s,%s,%s) Values(?,?,?,?,?);",obligatory,qteMin,qteMax,formId,ingredientId),o);
    }

    @Override
    public int update(Detail o) {
        return  executeQuery(String.format("UPDATE detail SET %s=?,%s=?,%s=? WHERE %s=? and %s=?;",obligatory,qteMin,qteMax,formId,ingredientId),o);

    }

    @Override
    public int delete(int id,int ing) {
        statement = createStatement(String.format("DELETE FROM detail WHERE %s=? and %s=?;",formId,ingredientId));
        try {
            statement.setInt(1, id);
            statement.setInt(2, ing);
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAODetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    @Override
    public int delete(int id) {
        statement = createStatement(String.format("DELETE FROM detail WHERE %s=? ",formId));
        try {
            statement.setInt(1, id);
            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAODetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public Detail find(int id_form , int id_ingredient ) {
      try {
            statement = createStatement(String.format("SELECT * FROM detail WHERE %s=? and %s=?;",formId,ingredientId));
            statement.setInt(1, id_form);
            statement.setInt(2,id_ingredient);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) return ResultSetToObject(rs);
        } catch (SQLException ex) {
            Logger.getLogger(DAODetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public Detail find(int id ) {
     /*   try {
            statement = createStatement("SELECT * FROM detail WHERE id=?;");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) return ResultSetToObject(rs);
        } catch (SQLException ex) {
            Logger.getLogger(DAODetail.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public ArrayList<Detail> getAll() {
        statement = createStatement("SELECT * FROM detail;");
        return executeToArray();
    }

    /**
     *
     * @return
     */
    @Override
    public ArrayList<Detail> findByForm(Form o) {

        return findByInt(String.format("SELECT * FROM detail WHERE %s=?;",formId),o.getId());

    }

    @Override
    public ArrayList<Detail> findByIngrediant(Ingrediant o) {

        return findByInt(String.format("SELECT * FROM detail WHERE %s=?;",ingredientId),o.getId());

    }

    public ArrayList<Detail> findByInt(String query, int value) {
        try {
            statement = createStatement(query);
            statement.setInt(1,value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executeToArray();
    }

    @Override
    public Detail ResultSetToObject(ResultSet rs) {
        try {
           Detail o = new Detail(
                    rs.getInt(formId),
                    daoIngredient.find(rs.getInt(ingredientId)),
                    rs.getBoolean(obligatory), rs.getInt(qteMin),
                    rs.getInt(qteMax)
            );
            return o;
        } catch (SQLException ex) {
            Logger.getLogger(DAODetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


}
