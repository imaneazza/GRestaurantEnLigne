/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Classes.Category;
import Classes.Ingrediant;
import DBLinking.DAO;

/**
 *
 * @author inknown
 */
public class DAOCategory extends DAO implements IDAOCategory {

    private String id = "id";
    private String name = "name";
    private String imageSource = "imageSource";
    private DAOIngredient daoIngredient=new DAOIngredient();


    @Override
    public int executeQuery(String query, Category o) {
        statement = createStatement(query);
        try {
            statement.setString(1, o.getName());
            statement.setString(2, o.getImageSource());
            statement.setInt(3, o.getId());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Category> executeToArray() {
        try {
            ResultSet rs = statement.executeQuery();
            ArrayList<Category> list = new ArrayList<Category>();
            while (rs.next()) {
                Category category = ResultSetToObject(rs);
                list.add(category);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Ingrediant> getIngredients(Category category) {

         DAOIngredient daoIngredients = new DAOIngredient();
        ArrayList<Ingrediant> liste=daoIngredients.findByCategory(category);
        daoIngredients.getManager().close();
        return liste;
    }

    public DAOCategory() {
        super();
    }

    @Override
    public int create(Category o) {
        return  executeQuery("INSERT INTO category(nom,imageSource,id) Values(?,?,?);",o);
    }

    @Override
    public int update(Category o) {
        return  executeQuery("UPDATE category SET nom=?,imageSource=? WHERE id=?;",o);
    }

    @Override
    public int delete(int id) {
        statement = createStatement("DELETE FROM category WHERE id=?;");
        try {
            statement.setInt(3, id);
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Category find(int id) {
        try {
            statement = createStatement("SELECT * FROM category WHERE id=?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return ResultSetToObject(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Category> getAll() {
            statement = createStatement("SELECT * FROM category ");
            return executeToArray();
    }

    @Override
    public Category ResultSetToObject(ResultSet rs) {
        try {
            Category category = new Category(rs.getInt(id), rs.getString(name), rs.getString(imageSource));
            category.setIngrediants(daoIngredient.findByCategory(category));
            return category;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


}
