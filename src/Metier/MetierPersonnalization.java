/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Classes.*;
import DAO.DAOLine;
import DAO.DAOPersonnalization;

import java.util.ArrayList;

/**
 *
 * @author inknown
 */
public class MetierPersonnalization implements IMetierPersonnalization{
    private DAOPersonnalization daoPersonnalization=new DAOPersonnalization();

    @Override
    public ArrayList<Personalization> findByLine(Line line) {
        return daoPersonnalization.findByLine(line);
    }

    @Override
    public Personalization findByLineIngredient(Ingrediant ing, Line line) {
        return daoPersonnalization.findByLineIngredient(ing, line);
    }

    @Override
    public int deletebyLine(Line line) {
        return daoPersonnalization.deletebyLine(line);
    }

    /**
     * not USED
     * @param id
     * @return
     */
    @Override
    public Personalization find(int id) {
        return daoPersonnalization.find(id);
    }

    @Override
    public int create(Personalization object) {
        return daoPersonnalization.create(object);
    }

    @Override
    public int update(Personalization object) {
        return daoPersonnalization.update(object);
    }

    /**
     * NOT USED
     * @param id
     * @return
     */
    @Override
    public int delete(int id) {
        return daoPersonnalization.delete(id);
    }

    @Override
    public ArrayList<Personalization> getAll() {
        return daoPersonnalization.getAll();
    }
}
