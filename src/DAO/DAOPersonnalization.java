package DAO;

import Classes.Ingrediant;
import Classes.Line;
import Classes.Personalization;
import DBLinking.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOPersonnalization  extends DAO implements IDAOPersonnalization {

    private String lineid="lineId";
    private String ingredientid="ingredientId";
    private String qte="qte";
    @Override
    public int create(Personalization object) {
        return executeQuery(String.format("INSERT INTO personalisation(%s,%s, %s) VALUES (?,?,?);",qte,lineid,ingredientid),object);

    }

    @Override
    public int update(Personalization object) {
        return executeQuery(String.format("UPDATE personalisation SET %s=?  WHERE %s=? and %s=?;",qte,lineid,ingredientid),object);

    }
    @Override
    public int deletebyLine(Line line) {
        statement = createStatement(String.format("DELETE FROM personalisation WHERE %s=?;",lineid));
        try {
            statement.setInt(1, line.getIdLine());
            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     *
     * @param id
     * @return
     * Not USED
     */

    @Override
    public int delete(int id) {
        return 0;
    }
    /**
     *
     * @param id
     * @return
     * Not USED
     */
    @Override
    public Personalization find(int id) {
        return null;
    }

    @Override
    public ArrayList<Personalization> getAll() {

        statement = createStatement("SELECT * FROM personalisation ");
        return executeToArray();

    }

    @Override
    public Personalization ResultSetToObject(ResultSet rs) {
        try {
            DAOIngredient ing=new DAOIngredient();
            Personalization perso = new Personalization(rs.getInt(lineid),ing.find(rs.getInt(ingredientid)) , rs.getDouble(qte));
            ing.getManager().close();
            return perso;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int executeQuery(String query, Personalization o) {
        statement = createStatement(query);
        try {
            statement.setDouble(1, o.getQte());
            statement.setInt(2, o.getIdLine());
            statement.setInt(3, o.getIng().getId());
            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Personalization> executeToArray() {
        try {
            ResultSet rs = statement.executeQuery();
            ArrayList<Personalization> list = new ArrayList<Personalization>();
            while (rs.next()) {
                Personalization personalization = ResultSetToObject(rs);
                list.add(personalization);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Personalization> findByLine(Line line) {
        try {
            statement = createStatement(String.format("SELECT * FROM personalisation WHERE %s=? ",lineid));
            statement.setInt(1,line.getIdLine());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return executeToArray();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public Personalization findByLineIngredient(Ingrediant ing, Line line) {
        try {
            statement = createStatement(String.format("SELECT * FROM personalisation WHERE %s=? and %s=?",lineid,ingredientid));
            statement.setInt(1, line.getIdLine());
            statement.setInt(2, ing.getId());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return ResultSetToObject(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


}
