/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import java.util.HashMap;
import  Classes.Detail;
import  Classes.Form;
import  Classes.Ingredient;
import  DAO.DAODetail;

/**
 *
 * @author inknown
 */
public class MetierDetail implements IMetierDetail{
    private DAODetail dao=new DAODetail();

    @Override
    public HashMap<Integer, Detail> findByForm(Form form) {
        return dao.findByForm(form);
    }

    @Override
    public HashMap<Integer, Detail> findByIngredient(Ingredient ingredient) {
        return dao.findByIngredient(ingredient);
    }

    @Override
    public Detail find(int id) {
        return dao.find(id);
    }

    @Override
    public int create(Detail object) {
        return dao.create(object);
    }

    @Override
    public int update(Detail object) {
        return dao.update(object);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public HashMap<Integer, Detail> getAll() {
        return dao.getAll();
    }


}
