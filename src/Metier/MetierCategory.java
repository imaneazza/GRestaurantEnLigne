/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import java.util.HashMap;
import  Classes.Category;
import  DAO.DAOCategory;

/**
 *
 * @author inknown
 */
public class MetierCategory implements IMetierCategory{
    private DAOCategory dao=new DAOCategory();
    @Override
    public Category find(int id) {
        return dao.find(id);
    }

    @Override
    public int create(Category object) {
        return dao.create(object);
    }

    @Override
    public int update(Category object) {
        return dao.update(object);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public HashMap<Integer, Category> getAll() {
        return dao.getAll();
    }
    
}
