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
import  Classes.User;
import DAO.DAORole;
import  DBLinking.DAO;
/**
 *
 * @author mk
 */
public class DAOUser extends DAO implements IDAOUser{
    private String id = "id";
        private String fName = "fName";
        private String lName = "lName";
        private String login = "login";
        private String password = "password";
        private String roleId = "roleId";
        public DAOUser() {
        super();
    }

    @Override
    public ArrayList<User> executeToArray() {
        try {
            ResultSet rs = statement.executeQuery();
            ArrayList<User> list = new ArrayList<User>();
            while (rs.next())  list.add(ResultSetToObject(rs));
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int executeQuery(String query, User o) {
        statement = createStatement(query);
        try {
            statement.setString(1, o.getfName());
            statement.setString(2, o.getlName());
            statement.setString(3, o.getLogin());
            statement.setString(4, o.getPassword());
            statement.setInt(5, o.getRoleId());
            statement.setInt(6, o.getId());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int create(User o) {
        return executeQuery("INSERT INTO user(fName,lName,login,password,roleId,id) Values(?,?,?,?,?,?);",o);
    }

    @Override
    public int update(User o) {
        return executeQuery("UPDATE user SET fName=?,lName=?,login=?,password=?,roleId=? WHERE id=?;",o);
    }

    @Override
    public int delete(int id) {
        statement = createStatement("DELETE FROM user WHERE id=?;");
        try {
            statement.setInt(1, id);
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public User find(int id) {
        try {
            statement = createStatement("SELECT * FROM user WHERE id=?;");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return ResultSetToObject(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<User> getAll() {
            statement = createStatement("SELECT * FROM user;");
            return executeToArray();
    }

    @Override
    public User ResultSetToObject(ResultSet rs) {
        try {
            return new User(rs.getInt(id), rs.getString(fName), rs.getString(lName), rs.getString(login), rs.getString(password),rs.getInt(roleId));
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
    }

    @Override
    public User connect(String login, String password) {
        try {
            statement = createStatement("SELECT * FROM user WHERE login=? AND password=?;");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return ResultSetToObject(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<User> findByRole(Role role) {
        try {
            statement = createStatement("SELECT * FROM user WHERE roleId=?;");
            statement.setInt(1,role.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executeToArray();
    }

    
}
