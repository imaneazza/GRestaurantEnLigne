/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import java.sql.SQLException;
import java.util.ArrayList;

import Classes.Detail;
import  Classes.Form;
import  Classes.Offer;
import  DAO.DAOForm;

/**
 *
 * @author inknown
 */
public class MetierForm implements IMetierForm{
    DAOForm dao=new DAOForm();
public int getlastID() throws SQLException {
    return dao.getlastID();
}
    @Override
    public ArrayList<Form> findByOffer(Offer Offer) {
        return dao.findByOffer(Offer);
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
    public ArrayList<Form> getAll() {
        return dao.getAll();
    }

    @Override
    public ArrayList<Detail> getDetails(Form form) {
        return dao.getDetails(form);
    }
}
