/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Classes.*;
import DAO.DAOComment;
import DAO.DAOPersonnalization;

import java.util.ArrayList;

/**
 *
 * @author inknown
 */
public class MetierComment implements IMetierComment{
    private DAOComment daoComment=new DAOComment();

    @Override
    public ArrayList<Comment> findbyCommande(Commande cmd) {
        return daoComment.findbyCommande(cmd);
    }

    @Override
    public Comment find(int id) {
        return daoComment.find(id);
    }

    @Override
    public int create(Comment object) {
        return daoComment.create(object);
    }

    @Override
    public int update(Comment object) {
        return daoComment.update(object);
    }

    @Override
    public int delete(int id) {
        return daoComment.delete(id);
    }

    @Override
    public ArrayList<Comment> getAll() {
        return daoComment.getAll();
    }
}
