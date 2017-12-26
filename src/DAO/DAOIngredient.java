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
import  Classes.Category;
import  Classes.Ingredient;
import  Classes.Price;
import  Classes.UniteMesure;
import  DBLinking.DAO;

/**
 *
 * @author inknown
 */
public class DAOIngredient extends DAO implements IDAOIngredient {

    private String id = "id";
    private String name = "name";
    private String uniteMesure = "uniteMesure";
    private String stock = "stock";
    private String categoryId = "categoryId";
    private DAOCategory daoCategory = new DAOCategory();

    public DAOIngredient() {
        super();
    }

    
    @Override
    public HashMap<Integer, Ingredient> findByCategory(Category category) {
        HashMap<Integer, Ingredient> list=new HashMap<Integer, Ingredient>();
        try {
            statement = createStatement("SELECT * FROM ingredient WHERE categoryId=?;");
            statement.setInt(1, category.getId());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Ingredient ingredient =ResultSetToObject(rs);
                ingredient.setCategory(category);
                list.put(ingredient.getId(), ingredient);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int create(Ingredient o) {
        statement = createStatement("INSERT INTO ingredient(nom,uniteMesure,stock,categoryId) Values(?,?,?,?);");
        try {
            statement.setString(1, o.getName());
            statement.setString(2, o.getUnitMesure().toString());
            statement.setInt(3, o.getStock());
            statement.setInt(4, o.getCategory().getId());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int update(Ingredient o) {
        statement = createStatement("UPDATE ingredient SET nom=?,uniteMesure=?,stock=?,categoryId=? WHERE id=?;");
        try {
            statement.setString(1, o.getName());
            statement.setString(2, o.getUnitMesure().toString());
            statement.setInt(3, o.getStock());
            statement.setInt(4, o.getCategory().getId());
            statement.setInt(5, o.getId());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    @Override
    public int delete(int id) {
        statement = createStatement("DELETE FROM ingredient WHERE id=?;");
        try {
            statement.setInt(1, id);
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Ingredient find(int id) {
        try {
            statement = createStatement("SELECT * FROM ingredient WHERE id=?;");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Ingredient i = ResultSetToObject(rs);
                i.setCategory(daoCategory.find(rs.getInt("categoryId")));
                return i;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public HashMap<Integer, Ingredient> getAll() {
        HashMap<Integer, Ingredient> list = new HashMap<Integer, Ingredient>();
        try {
            statement = createStatement("SELECT * FROM ingredient");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Ingredient ingredient = ResultSetToObject(rs);

                ingredient.setCategory(daoCategory.find(rs.getInt("categoryId")));
                list.put(ingredient.getId(), ingredient);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Ingredient ResultSetToObject(ResultSet rs) {
        try {
            Ingredient ingredient = new Ingredient(rs.getInt(id), rs.getString(name), StringToUniteMesure(rs.getString(uniteMesure)), rs.getInt("stock"));

             DAOPrice daoPrice = new DAOPrice();
            ingredient.setArchivePrice(daoPrice.findByIngredient(ingredient));
            daoPrice.getManager().close();
            return ingredient;
        } catch (SQLException ex) {
            Logger.getLogger(DAOIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public UniteMesure StringToUniteMesure(String uniteMesure) {
        switch (uniteMesure) {
            case "ml":
                return UniteMesure.ml;
            case "cl":
                return UniteMesure.cl;
            case "l":
                return UniteMesure.l;
            case "mg":
                return UniteMesure.mg;
            case "cg":
                return UniteMesure.cg;
            case "g":
                return UniteMesure.g;
            case "kg":
                return UniteMesure.kg;
            default:
                return UniteMesure.autre;
        }
    }


    @Override
    public int addQuantity(Ingredient ingredient,int quantity) {
        statement = createStatement("UPDATE ingredient SET stock=stock+? id=?;");
        try {
            statement.setInt(1, quantity);
            statement.setInt(2, ingredient.getId());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
