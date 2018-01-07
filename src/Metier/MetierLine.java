/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Classes.*;
import DAO.DAOCategory;
import DAO.DAOLine;

import java.util.ArrayList;

/**
 *
 * @author inknown
 */
public class MetierLine implements IMetierLine{
    private DAOLine daoLine=new DAOLine();
    @Override
    public double getprice() {
        return daoLine.getprice();
    }

    @Override
    public ArrayList<Line> findbyCommande(Commande cmd) {
        return daoLine.findbyCommande(cmd);
    }

    @Override
    public Line findbyCommandeForm(Commande cmd, Form form) {
        return daoLine.findbyCommandeForm(cmd,form);
    }

    @Override
    public Line find(int id) {
        return daoLine.find(id);
    }

    @Override
    public int create(Line object) {
        return daoLine.create(object);
    }

    @Override
    public int update(Line object) {
        return daoLine.update(object);
    }

    @Override
    public int delete(int id) {
        return daoLine.delete(id);
    }

    @Override
    public ArrayList<Line> getAll() {
        return daoLine.getAll();
    }
}
