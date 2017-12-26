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
import  Classes.Ingredient;
import  Classes.Price;
import  DBLinking.DAO;

/**
 *
 * @author inknown
 */
class DAOPrice extends DAO implements IDAOPrice{

    private String id = "id";
    private String date = "date";
    private String price = "price";
    private String ingredientId = "ingredientId";
    private DAOIngredient daoIngredient=new DAOIngredient();
    public DAOPrice() {
        super();
    }


    @Override
    public int create(Price o) {
        statement = createStatement("INSERT INTO price(date,price) Values(?,?);");
        try {
            statement.setDate(1, new java.sql.Date(o.getDate().getTime()));
            statement.setFloat(2, o.getPrice());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPrice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int update(Price o) {
        statement = createStatement("UPDATE price SET date=?,price=? WHERE id=?;");
        try {
            statement.setDate(1, new java.sql.Date(o.getDate().getTime()));
            statement.setFloat(2, o.getPrice());
            statement.setInt(5, o.getId());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPrice.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DAOPrice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Price find(int id) {
        try {
            statement = createStatement("SELECT * FROM price WHERE id=?;");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return ResultSetToObject(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPrice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public HashMap<Integer, Price> getAll() {
        HashMap<Integer, Price> list = new HashMap<Integer, Price>();
        try {
            statement = createStatement("SELECT * FROM price");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Price o = ResultSetToObject(rs);
                list.put(o.getId(), o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPrice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Price ResultSetToObject(ResultSet rs) {
       try {
            Price p = new Price(rs.getInt(id), rs.getDate(date), rs.getFloat(price),daoIngredient.find(rs.getInt(ingredientId)));
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DAOPrice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    @Override
    public HashMap<Integer, Price> findByIngredient(Ingredient ingredient) {
      HashMap<Integer, Price> list = new HashMap<Integer, Price>();
        try {
            statement = createStatement("SELECT * FROM price WHERE id=?;");
            statement.setInt(1, ingredient.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Price o = ResultSetToObject(rs);
                list.put(o.getId(), o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPrice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }


    
}
