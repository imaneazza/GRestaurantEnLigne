/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Classes.Commande;
import Classes.Line;
import DAO.DAOCommande;

import java.util.ArrayList;

/**
 *
 * @author inknown
 */
public class MetierCommande implements IMetierCommande{
    private DAOCommande dao=new DAOCommande();

    @Override
    public ArrayList<Line> getLines(Commande cmd) {
        return dao.getLines(cmd);
    }

    @Override
    public Commande find(int id) {
        return dao.find(id);
    }

    @Override
    public int create(Commande object) {
        return dao.create(object);
    }

    @Override
    public int update(Commande object) {
        return dao.update(object);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public ArrayList<Commande> getAll() {
        return dao.getAll();
    }
}
