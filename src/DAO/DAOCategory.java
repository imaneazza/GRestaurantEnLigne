/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import Classes.Category;
import Classes.Ingredient;
import DBLinking.DAO;

/**
 *
 * @author inknown
 */
public class DAOCategory extends DAO implements IDAOCategory {

    private String id = "id";
    private String name = "name";
    private String imageSource = "imageSource";

    @Override
    public HashMap<Integer, Ingredient> getIngredients(Category category) {

         DAOIngredient daoIngredients = new DAOIngredient();
        HashMap<Integer, Ingredient> liste=daoIngredients.findByCategory(category);
        daoIngredients.getManager().close();
        return liste;
    }

    public DAOCategory() {
        super();
    }

    @Override
    public int create(Category o) {
        statement = createStatement("INSERT INTO category(nom,imageSource) Values(?,?);");
        try {
            statement.setString(1, o.getName());
            statement.setString(2, o.getImageSource());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int update(Category o) {
        statement = createStatement("UPDATE category SET nom=?,imageSource=? WHERE id=?;");
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
    public HashMap<Integer, Category> getAll() {
        HashMap<Integer, Category> list = new HashMap<Integer, Category>();
        try {
            statement = createStatement("SELECT * FROM category ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category category = ResultSetToObject(rs);
                list.put(category.getId(), category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Category ResultSetToObject(ResultSet rs) {
        try {
            Category category = new Category(rs.getInt(id), rs.getString(name), rs.getString(imageSource));

            DAOIngredient daoIngredients=new DAOIngredient();
            category.setIngredients(daoIngredients.findByCategory(category));
            daoIngredients.getManager().close();
            return category;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


}
