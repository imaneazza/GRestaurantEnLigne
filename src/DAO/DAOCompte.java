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
import  Classes.Role;
import Classes.Compte;
import  DBLinking.DAO;
/**
 *
 * @author mk
 */
public class DAOCompte extends DAO implements IDAOCompte{
    private String id = "id";
        private String fName = "fName";
        private String lName = "lName";
        private String login = "login";
        private String password = "password";
        private String email = "email";
        private String roleId = "roleId";
        public DAOCompte() {
        super();
    }

    @Override
    public ArrayList<Compte> executeToArray() {
        try {
            ResultSet rs = statement.executeQuery();
            ArrayList<Compte> list = new ArrayList<Compte>();
            while (rs.next())  list.add(ResultSetToObject(rs));
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int executeQuery(String query, Compte o) {
        statement = createStatement(query);
        try {
            statement.setString(1, o.getfName());
            statement.setString(2, o.getlName());
            statement.setString(3, o.getLogin());
            statement.setString(4, o.getPassword());
            statement.setString(5, o.getEmail());
            statement.setInt(6, o.getRoleId());
            statement.setInt(7, o.getId());
            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }


    @Override
    public int create(Compte o) {
        o.setId(executeQuery("INSERT INTO compte(fName,lName,login,password,email,roleId,id) Values(?,?,?,?,?,?);",o));
        return o.getId();
    }

    @Override
    public int update(Compte o) {
        return executeQuery("UPDATE compte SET fName=?,lName=?,login=?,password=?,email=?,roleId=? WHERE id=?;",o);
    }

    @Override
    public int delete(int id) {
        statement = createStatement("DELETE FROM compte WHERE id=?;");
        try {
            statement.setInt(1, id);
            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Compte find(int id) {
        try {
            statement = createStatement("SELECT * FROM compte WHERE id=?;");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return ResultSetToObject(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Compte> getAll() {
            statement = createStatement("SELECT * FROM compte;");
            return executeToArray();
    }

    @Override
    public Compte ResultSetToObject(ResultSet rs) {
        try {
            return new Compte(rs.getInt(id), rs.getString(fName), rs.getString(lName), rs.getString(login), rs.getString(password),rs.getString(email),rs.getInt(roleId));
        } catch (SQLException ex) {
            Logger.getLogger(DAOCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
    }

    @Override
    public Compte connect(String login, String password) {
        try {
            statement = createStatement("SELECT * FROM compte WHERE login=? AND password=?;");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return ResultSetToObject(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Compte> findByRole(Role role) {
        try {
            statement = createStatement("SELECT * FROM compte WHERE roleId=?;");
            statement.setInt(1,role.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executeToArray();
    }

    
}
