/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import java.util.ArrayList;
import  Classes.Detail;
import  Classes.Form;
import  Classes.Ingrediant;
import  DAO.DAODetail;

/**
 *
 * @author inknown
 */
public class MetierDetail implements IMetierDetail{
    private DAODetail dao=new DAODetail();

    @Override
    public int delete(int id,int ing){
    return dao.delete(id,ing);
}
    @Override
    public ArrayList<Detail> findByForm(Form form) {
        return dao.findByForm(form);
    }

    @Override
    public ArrayList<Detail> findByIngredient(Ingrediant ingredient) {
        return dao.findByIngrediant(ingredient);
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
    public ArrayList<Detail> getAll() {
        return dao.getAll();
    }


}
