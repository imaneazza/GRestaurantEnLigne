/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import java.util.ArrayList;
import  Classes.Role;
import Classes.Compte;
import  DAO.DAOCompte;

/**
 *
 * @author mk
 */
public class MetierCompte implements IMetierCompte{
    DAOCompte dao=new DAOCompte();
    @Override
    public Compte connect(String login, String password) {
        return dao.connect(login, password);
    }

    @Override
    public ArrayList<Compte> findByRole(Role role) {
        return dao.findByRole(role);
    }

    @Override
    public Compte find(int id) {
        return dao.find(id);
    }

    @Override
    public int create(Compte object) {
        return dao.create(object);
    }

    @Override
    public int update(Compte object) {
        return dao.update(object);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public ArrayList<Compte> getAll() {
        return dao.getAll();
    }
    
}
