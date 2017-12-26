/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import java.util.HashMap;
import  Classes.Form;
import  Classes.Offre;
import  DAO.DAOForm;

/**
 *
 * @author inknown
 */
public class MetierForm implements IMetierForm{
    DAOForm dao=new DAOForm();

    @Override
    public HashMap<Integer, Form> findByOffre(Offre offre) {
        return dao.findByOffre(offre);
    }

    @Override
    public Form find(int id) {
        return dao.find(id);
    }

    @Override
    public int create(Form object) {
        return dao.create(object);
    }

    @Override
    public int update(Form object) {
        return dao.update(object);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public HashMap<Integer, Form> getAll() {
        return dao.getAll();
    }
    
}
