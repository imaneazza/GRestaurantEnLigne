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
import  Classes.Role;
import  Classes.User;
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
        DAORole daoRole=new DAORole();
        public DAOUser() {
        super();
    }
    @Override
    public int create(User o) {
        statement = createStatement("INSERT INTO user(fName,lName,login,password,roleId) Values(?,?,?,?,?);");
        try {
            statement.setString(1, o.getfName());
            statement.setString(2, o.getlName());
            statement.setString(3, o.getLogin());
            statement.setString(4, o.getPassword());
            statement.setInt(5, o.getRole().getId());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int update(User o) {
         statement = createStatement("UPDATE user SET fName=?,lName=?,login=?,password=?,roleId=? WHERE id=?;");
        try {
            statement.setString(1, o.getfName());
            statement.setString(2, o.getlName());
            statement.setString(3, o.getLogin());
            statement.setString(4, o.getPassword());
            statement.setInt(5, o.getRole().getId());
            statement.setInt(6, o.getId());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
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
    public HashMap<Integer, User> getAll() {
        HashMap<Integer, User> list = new HashMap<Integer, User>();
        try {
            statement = createStatement("SELECT * FROM user;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User o = ResultSetToObject(rs);
                o.setRole(daoRole.find(rs.getInt(roleId)));
                list.put(o.getId(), o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public User ResultSetToObject(ResultSet rs) {
        try {
            User o = new User(rs.getInt(id), rs.getString(fName), rs.getString(lName), rs.getString(login), rs.getString(password));
            o.setRole(daoRole.find(rs.getInt(roleId)));
            return o;
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
    public HashMap<Integer, User> findByRole(Role role) {
        HashMap<Integer, User> list = new HashMap<Integer, User>();
        try {
            statement = createStatement("SELECT * FROM user WHERE roleId=?;");
            statement.setInt(1, role.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User o = ResultSetToObject(rs);
                o.setRole(role);
                list.put(o.getId(), o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    
}
