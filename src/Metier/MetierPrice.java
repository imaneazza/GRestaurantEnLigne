/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import java.util.ArrayList;
import  Classes.Price;
import  Classes.Ingrediant;
import  DAO.DAOIngredient;
import  DAO.DAOPrice;

/**
 *
 * @author inknown
 */
public class MetierPrice implements IMetierPrice{
    DAOPrice dao=new DAOPrice();

    @Override
    public Price find(int id) {
        return dao.find(id);
    }

    @Override
    public int create(Price object) {
        return dao.create(object);
    }

    @Override
    public int update(Price object) {
        return dao.update(object);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public ArrayList<Price> getAll() {
        return dao.getAll();
    }
    public ArrayList<Price> findByIngredient(Ingrediant ingredient){
        return dao.findByIngrediant(ingredient);
    }


}