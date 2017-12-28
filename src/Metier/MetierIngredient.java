/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import java.util.ArrayList;
import  Classes.Price;
import  Classes.Category;
import  Classes.Ingrediant;
import  DAO.DAOIngredient;
import  DAO.DAOPrice;

/**
 *
 * @author inknown
 */
public class MetierIngredient implements IMetierIngredient{
    DAOIngredient dao=new DAOIngredient();
    DAOPrice daoPrice=new DAOPrice();
    @Override
    public ArrayList<Ingrediant> findByCategory(Category category) {
        return dao.findByCategory(category);
    }

    @Override
    public Ingrediant find(int id) {
        return dao.find(id);
    }

    @Override
    public int create(Ingrediant object) {
        return dao.create(object);
    }

    @Override
    public int update(Ingrediant object) {
        return dao.update(object);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public ArrayList<Ingrediant> getAll() {
        return dao.getAll();
    }
    @Override
    public ArrayList<Price> getPrices(Ingrediant ingediant) {
        return daoPrice.findByIngrediant(ingediant);
    }
    
}
