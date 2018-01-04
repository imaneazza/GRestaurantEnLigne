package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import  Classes.Role;
import Classes.User;
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
    public int executeQuery(String query, Role o) {
        statement = createStatement(query);
        try {
            statement.setString(1, o.getName());
            statement.setInt(2, o.getId());
            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAORole.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Role> executeToArray() {
        try {
            ResultSet rs = statement.executeQuery();
            ArrayList<Role> list = new ArrayList<Role>();
            while (rs.next()) {
                list.add(ResultSetToObject(rs));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DAORole.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int create(Role o) {
        return executeQuery("INSERT INTO role(name,id) Values(?,?);",o);
    }

    @Override
    public int update(Role o) {
       return executeQuery("UPDATE role SET name=? WHERE id=?;",o);
    }

    @Override
    public int delete(int id) {
        statement = createStatement("DELETE FROM role WHERE id=?;");
        try {
            statement.setInt(1, id);
            return executeToInt();
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
    public ArrayList<Role> getAll() {
            statement = createStatement("SELECT * FROM role;");
            return executeToArray();
    }

    @Override
    public Role ResultSetToObject(ResultSet rs) {
        try {
            Role o = new Role(rs.getInt(1), rs.getString(2));
            o.setUsers(getUsers(o));
            return o;
        } catch (SQLException ex) {
            Logger.getLogger(DAORole.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<User> getUsers(Role role) {
        return (new DAOUser()).findByRole(role);
    }
}
