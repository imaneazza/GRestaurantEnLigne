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
import  Classes.Ingrediant;
import  Classes.Price;
import  DBLinking.DAO;

/**
 *
 * @author inknown
 */
public class DAOPrice extends DAO implements IDAOPrice{

    private String id = "id";
    private String date = "date";
    private String price = "price";
    private String ingredientId = "ingredientId";
    public DAOPrice() {
        super();
    }

    @Override
    public ArrayList<Price> executeToArray() {

        try {
            ResultSet rs = statement.executeQuery();
            ArrayList<Price> list = new ArrayList<Price>();
            while (rs.next())  list.add(ResultSetToObject(rs));
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DAOPrice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int executeQuery(String query, Price o) {
        statement = createStatement(query+"SELECT LAST_INSERT_ID();");
        try {
            statement.setDate(1, new java.sql.Date(o.getDate().getTime()));
            statement.setFloat(2, o.getPrice());
            statement.setFloat(3, o.getIngredientId());
            statement.setFloat(4, o.getId());
            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPrice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int create(Price o) {
        return executeQuery("INSERT INTO (`price`,`date`,`ingredientId`,`id`) VALUES(?,?,?,?)",o);

    }

    @Override
    public int update(Price o) {
        return executeQuery("UPDATE price SET price=?,date=?,ingredientId=? WHERE id=?;",o);
    }

    @Override
    public int delete(int id) {
        statement = createStatement("DELETE FROM price WHERE id=?;");
        try {
            statement.setInt(1, id);
            return executeToInt();
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
    public ArrayList<Price> getAll() {
            statement = createStatement("SELECT * FROM price");
            return executeToArray();
    }
    @Override
    public ArrayList<Price> findByIngrediant(Ingrediant ingrediant) {
        try {
            statement = createStatement("SELECT * FROM price WHERE id=?;");
            statement.setInt(1, ingrediant.getId());
        } catch (SQLException ex) {
            Logger.getLogger(DAOPrice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return executeToArray();
    }

    @Override
    public Price ResultSetToObject(ResultSet rs) {
       try {
            return new Price(rs.getInt(id), rs.getDate(date), rs.getFloat(price),rs.getInt(ingredientId));
        } catch (SQLException ex) {
            Logger.getLogger(DAOPrice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }





    
}
