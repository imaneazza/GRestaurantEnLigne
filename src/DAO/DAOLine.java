package DAO;

import Classes.Commande;
import Classes.Form;
import Classes.Line;
import DBLinking.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOLine extends DAO implements IDAOLine  {
    private String idLine="id";
    private String formID="formId";
    private String qte="qte";
    private String commandeId="commandeId";
    @Override
    public double getprice() {
        return 0;
    }

    @Override
    public ArrayList<Line> findbyCommande(Commande cmd) {
        return findByInt(String.format("SELECT * FROM line WHERE %s =?",commandeId),cmd.getId());

    }

    public ArrayList<Line> findByInt(String query, int value) {
        try {
            statement = createStatement(query);
            statement.setInt(1,value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executeToArray();
    }



    @Override
    public Line findbyCommandeForm(Commande cmd, Form form) {
        try {
            statement = createStatement(String.format("SELECT * FROM line WHERE %s=? and %s=?",commandeId,formID));
            statement.setInt(1, cmd.getId());
            statement.setInt(2, form.getId());
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
    public int create(Line object) {
        object.setIdLine(executeQuery(String.format("INSERT INTO line( %s,%s,%s,%s) VALUES (?,?,?,?);",qte,formID,commandeId,idLine),object));
        return object.getIdLine();
    }

    @Override
    public int update(Line object) {
        return executeQuery(String.format("UPDATE line SET %s=? , %s=? , %s=? WHERE %s=?;",qte,formID,commandeId,idLine),object);

    }

    @Override
    public int delete(int id) {
        statement = createStatement(String.format("DELETE FROM line WHERE %s=?;",idLine));
        try {
            statement.setInt(1, id);
            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Line find(int id) {
        try {
            statement = createStatement("SELECT * FROM line WHERE id=?");
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
    public ArrayList<Line> getAll() {
        statement = createStatement("SELECT * FROM line ");
        return executeToArray();
    }

    @Override
    public Line ResultSetToObject(ResultSet rs) {
        try {
                DAOForm form=new DAOForm();
            Line line = new Line(rs.getInt(idLine), form.find(rs.getInt(formID)), rs.getInt(commandeId),rs.getInt(qte));
            form.getManager().close();
            return line;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int executeQuery(String query, Line o) {
        statement = createStatement(query);
        try {
            statement.setInt(1, o.getQuantity());
            statement.setInt(2, o.getForm().getId());
            statement.setInt(3, o.getComamnde());
            statement.setInt(4, o.getIdLine());
            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Line> executeToArray() {
        try {
            ResultSet rs = statement.executeQuery();
            ArrayList<Line> list = new ArrayList<Line>();
            while (rs.next()) {
                Line line = ResultSetToObject(rs);
                list.add(line);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
