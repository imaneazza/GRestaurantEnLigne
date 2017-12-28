/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import java.util.ArrayList;
import  Classes.Role;
import  DAO.DAORole;

/**
 *
 * @author mk
 */
public class MetierRole implements IMetierRole{
    DAORole dao=new DAORole();
    @Override
    public Role find(int id) {
        return dao.find(id);
    }

    @Override
    public int create(Role object) {
        return dao.create(object);
    }

    @Override
    public int update(Role object) {
        return dao.update(object);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public ArrayList<Role> getAll() {
        return dao.getAll();
    }
    
}
