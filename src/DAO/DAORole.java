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
import  DBLinking.DAO;

/**
 *
 * @author mk
 */
public class DAORole extends DAO implements IDAORole{
    private String id = "id";
        private String name = "name";
        public DAORole() {
        super();
    }
    @Override
    public int create(Role o) {
        statement = createStatement("INSERT INTO role(name) Values(?);");
        try {
            statement.setString(1, o.getName());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAORole.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int update(Role o) {
        statement = createStatement("UPDATE role SET name=? WHERE id=?;");
        try {
            statement.setString(1, o.getName());
            statement.setInt(2, o.getId());
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAORole.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        statement = createStatement("DELETE FROM role WHERE id=?;");
        try {
            statement.setInt(3, id);
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAORole.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Role find(int id) {
        try {
            statement = createStatement("SELECT * FROM role WHERE id=?;");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return ResultSetToObject(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAORole.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public HashMap<Integer, Role> getAll() {
        HashMap<Integer, Role> list = new HashMap<Integer, Role>();
        try {
            statement = createStatement("SELECT * FROM role;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Role o = ResultSetToObject(rs);
                list.put(o.getId(), o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAORole.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Role ResultSetToObject(ResultSet rs) {
        try {
            Role o = new Role(rs.getInt(id), rs.getString(name));
            return o;
        } catch (SQLException ex) {
            Logger.getLogger(DAORole.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
