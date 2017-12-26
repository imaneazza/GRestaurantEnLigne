/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import java.util.HashMap;
import  Classes.Category;
import  Classes.Ingredient;
import  DAO.DAOIngredient;

/**
 *
 * @author inknown
 */
public class MetierIngredient implements IMetierIngredient{
    DAOIngredient dao=new DAOIngredient();
    @Override
    public HashMap<Integer, Ingredient> findByCategory(Category category) {
        return dao.findByCategory(category);
    }

    @Override
    public Ingredient find(int id) {
        return dao.find(id);
    }

    @Override
    public int create(Ingredient object) {
        return dao.create(object);
    }

    @Override
    public int update(Ingredient object) {
        return dao.update(object);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public HashMap<Integer, Ingredient> getAll() {
        return dao.getAll();
    }
    
}
