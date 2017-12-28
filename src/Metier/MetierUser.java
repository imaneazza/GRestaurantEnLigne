/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import java.util.ArrayList;
import  Classes.Role;
import  Classes.User;
import  DAO.DAOUser;

/**
 *
 * @author mk
 */
public class MetierUser implements IMetierUser{
    DAOUser dao=new DAOUser();
    @Override
    public User connect(String login, String password) {
        return dao.connect(login, password);
    }

    @Override
    public ArrayList<User> findByRole(Role role) {
        return dao.findByRole(role);
    }

    @Override
    public User find(int id) {
        return dao.find(id);
    }

    @Override
    public int create(User object) {
        return dao.create(object);
    }

    @Override
    public int update(User object) {
        return dao.update(object);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public ArrayList<User> getAll() {
        return dao.getAll();
    }
    
}
