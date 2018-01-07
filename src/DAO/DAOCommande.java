package DAO;

import Classes.*;
import DBLinking.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCommande extends DAO implements IDAOCommande{
    private String id="id";
    private String date="date";
    private String address="address";
    private String mode="mode";
    private String clientId="clientId";

    @Override
    public int create(Commande object) {
        object.setId(executeQuery(String.format("INSERT INTO commande(%s,%s,%s,%s,%s) VALUES(?,?,?,?,?);",date,address,mode,clientId,id),object));
        return object.getId();
    }

    @Override
    public int update(Commande object) {
        return executeQuery(String.format("UPDATE commande SET %s=?,%s=?,%s=?,%s=? WHERE %s=?);",date,address,mode,clientId,id),object);

    }

    @Override
    public int delete(int id) {
        statement = createStatement(String.format("DELETE FROM commande WHERE %s=?;",id));
        try {
            statement.setInt(1, id);
            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Commande find(int id) {
        try {
            statement = createStatement(String.format("SELECT * FROM commande WHERE %s=?;",id));
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
    public ArrayList<Commande> getAll() {
        statement = createStatement("SELECT * FROM commande ");
        return executeToArray();
    }

    @Override
    public Commande ResultSetToObject(ResultSet rs) {
        try {
            DAOLine line=new DAOLine();
            Commande commande = new Commande(
                    rs.getInt(id),
                    rs.getDate(date),
                    rs.getString(address) ,
                    StringToPaimentMode(rs.getString(mode)),
                    (new DAOClient()).find(rs.getInt(clientId))
            );
            line.getManager().close();
            return commande;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int executeQuery(String query, Commande o) {
        statement = createStatement(query);
        try {
            statement.setDate(1, new java.sql.Date(o.getDate().getTime()));
            statement.setString(2, o.getAddress());
            statement.setString(3, o.getMode().toString());
            statement.setInt(4, o.getClient().getCode());
            statement.setInt(5, o.getId());
            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Commande> executeToArray() {
        try {
            ResultSet rs = statement.executeQuery();
            ArrayList<Commande> list = new ArrayList<Commande>();
            while (rs.next()) {
                Commande commande = ResultSetToObject(rs);
                list.add(commande);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Line> getLines(Commande commande){
     return (new DAOLine()).findbyCommande(commande);
    }
}
