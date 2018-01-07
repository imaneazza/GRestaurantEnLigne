/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import  Classes.Category;
import  Classes.Ingrediant;
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
    private String stock = "qte";
    private String categoryId = "categoryId";
    DAOPrice daoPrice=new DAOPrice();

    public DAOIngredient() {
        super();
    }

    @Override
    public ArrayList<Ingrediant> executeToArray() {
        try {
            ResultSet rs = statement.executeQuery();
            ArrayList<Ingrediant> list=new ArrayList<Ingrediant>();
            while (rs.next()) {
                Ingrediant ingredient =ResultSetToObject(rs);
                ArrayList<Price> liste=getPrices(ingredient);
                ingredient.setArchivePrice(liste);
                list.add(ingredient);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DAOIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int executeQuery(String query, Ingrediant o) {
        statement = createStatement(query);
        try {
            statement.setString(1, o.getName());
            statement.setString(2, o.getUnitMesure().toString());
            statement.setInt(3, o.getStock());
            statement.setInt(4, o.getCategoryId());
            statement.setInt(5, o.getId());
            statement.executeUpdate();
            ResultSet rs=statement.getGeneratedKeys();
            if (rs.next())return rs.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(DAOIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }



    @Override
    public ArrayList<Ingrediant> findByCategory(Category category) {
        try {
            statement = createStatement("SELECT * FROM ingredient WHERE categoryId=?;");
            statement.setInt(1, category.getId());

        } catch (SQLException ex) {
            Logger.getLogger(DAOIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return executeToArray();
    }

    @Override
    public int create(Ingrediant o) {

        o.setId(executeQuery("INSERT INTO ingredient(name,uniteMesure,qte,categoryId,id) Values(?,?,?,?,?);",o));
        return o.getId();


}

    @Override
    public int update(Ingrediant o) {
        return executeQuery("UPDATE ingredient SET name=?,uniteMesure=?,qte=?,categoryId=? WHERE id=?;",o);

    }

    @Override
    public int delete(int id) {
        statement = createStatement("DELETE FROM ingredient WHERE id=?;");
        try {
            statement.setInt(1, id);
            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAOIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Ingrediant find(int id) {
        try {
            statement = createStatement("SELECT * FROM ingredient WHERE id=?;");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return ResultSetToObject(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Ingrediant> getAll() {
            statement = createStatement("SELECT * FROM ingredient");
            return executeToArray();
    }

    @Override
    public Ingrediant ResultSetToObject(ResultSet rs) {
        try {
            Ingrediant ingredient = new Ingrediant(
                    rs.getInt(id),
                    rs.getString(name),
                    StringToUniteMesure(rs.getString(uniteMesure)),
                    rs.getInt(stock),
                    rs.getInt(categoryId)
            );
            ingredient.setArchivePrice(getPrices(ingredient));
            daoPrice.getManager().close();
            return ingredient;
        } catch (SQLException ex) {
            Logger.getLogger(DAOIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }




    @Override
    public int addStock(Ingrediant ingredient,int quantity) {
        statement = createStatement("UPDATE ingredient SET stock=stock+? id=?;");
        try {
            statement.setInt(1, quantity);
            statement.setInt(2, ingredient.getId());
            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAOIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int consume(Ingrediant ingredient, int quantity) {
        return addStock(ingredient,-quantity);
    }
    public ArrayList<Price> getPrices(Ingrediant ingrediant){

        DAOPrice daoPrice=new DAOPrice();
        ArrayList<Price>liste= daoPrice.findByIngrediant(ingrediant);
        daoPrice.getManager().close();
        return  liste;
    }
}
