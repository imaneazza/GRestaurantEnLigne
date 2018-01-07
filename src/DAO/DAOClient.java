/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Commande;
import Classes.Compte;
import Classes.Client;
import DBLinking.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mk
 */
public class DAOClient extends DAO implements IDAOClient{
        private String id = "code";
        private String tel = "tel";
        private String address = "address";
        private String loyal = "loyal";
        private String compteId = "compteId";
        public DAOClient() {
        super();
    }

    @Override
    public ArrayList<Client> executeToArray() {
        try {
            ResultSet rs = statement.executeQuery();
            ArrayList<Client> list = new ArrayList<Client>();
            while (rs.next())  list.add(ResultSetToObject(rs));
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DAOClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int executeQuery(String query, Client o) {
        statement = createStatement(query);
        try {
            statement.setString(1, o.getTel());
            statement.setString(2, o.getAddress());
            statement.setBoolean(3, o.isLoyal());
            statement.setInt(4, o.getCompteId());
            statement.setInt(5, o.getCode());
            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAOClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }


    @Override
    public int create(Client o) {
        o.setCode(executeQuery(String.format("INSERT INTO client(%s,%s,%s,%s,%s) Values(?,?,?,?,?);",tel,address,loyal,compteId,id),o));
        return o.getCode();
    }

    @Override
    public int update(Client o) {
        return executeQuery(String.format("UPDATE client SET %s=?,%s=?,%s=?,%s=? WHERE %s=?;",tel,address,loyal,compteId,id),o);
    }

    @Override
    public int delete(int id) {
        statement = createStatement(String.format("DELETE FROM client WHERE %s=?;",this.id));
        try {
            statement.setInt(1, id);
            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAOClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Client find(int id) {
        try {
            statement = createStatement(String.format("SELECT * FROM client WHERE %s=?;",this.id));
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return ResultSetToObject(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Client> getAll() {
            statement = createStatement("SELECT * FROM client;");
            return executeToArray();
    }

    @Override
    public Client ResultSetToObject(ResultSet rs) {
        try {
            return new Client(rs.getInt(id), rs.getString(tel), rs.getString(address), rs.getBoolean(loyal), rs.getInt(compteId));
        } catch (SQLException ex) {
            Logger.getLogger(DAOClient.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
    }


    @Override
    public ArrayList<Client> findByCompte(Compte compte) {
        try {
            statement = createStatement(String.format("SELECT * FROM client WHERE %s=?;",compteId));
            statement.setInt(1,compte.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executeToArray();
    }


    public ArrayList<Commande> getCommandes(Client client) {
            return null;//(new DAOCommande()).findByClient(client);
    }
}
