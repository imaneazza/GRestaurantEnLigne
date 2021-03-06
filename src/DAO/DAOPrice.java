/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            statement = createStatement(query);
            try {
                statement.setDate(2, new java.sql.Date(o.getDate().getTime()));
                statement.setDouble(1, o.getPrice());
                statement.setFloat(3, o.getIngredientId());
                statement.setFloat(4, o.getId());
                return  executeToInt();

            } catch (SQLException ex) {
                Logger.getLogger(DAOPrice.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        }






    @Override
    public int update(Price o) {

            return executeQuery(String.format("UPDATE price SET %s=?,%s=?,%s=? WHERE %s=?;",price,date,ingredientId,id),o);
    }

    @Override
    public int delete(int id) {
        statement = createStatement(String.format("DELETE FROM price WHERE %s=?;",this.id));
        try {
            statement.setInt(1, id);
            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPrice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
        @Override
        public int create(Price o) {
            o.setId(executeQuery(String.format("INSERT INTO price (%s,%s,%s,%s)VALUES(?,?,?,?)",price,date,ingredientId,id),o));
            return o.getId();


        }


        @Override
        public Price find(int id) {
            try {
                statement = createStatement(String.format("SELECT * FROM price WHERE %s=?;",this.id));
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
                statement = createStatement(String.format("SELECT * FROM price WHERE %s=?;",ingredientId));
                statement.setInt(1, ingrediant.getId());
            } catch (SQLException ex) {
                Logger.getLogger(DAOPrice.class.getName()).log(Level.SEVERE, null, ex);
            }
            return executeToArray();
        }

        @Override
        public Price ResultSetToObject(ResultSet rs) {
           try {
                Price p = new Price(rs.getInt(id), rs.getDate(date), rs.getDouble(price),rs.getInt(ingredientId));
                return p;
            } catch (SQLException ex) {
                Logger.getLogger(DAOPrice.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;

        }





    
}
