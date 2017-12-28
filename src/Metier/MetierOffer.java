package  Metier;

import java.util.ArrayList;
import  Classes.Form;
import  Classes.Offer;
import  DAO.DAOOffer;
import  DAO.DAOForm;

/**
 *
 * @author inknown
 */
public class MetierOffer implements IMetierOffer{
    private DAOOffer dao=new DAOOffer();


    @Override
    public Offer find(int id) {
        return dao.find(id);
    }

    @Override
    public int create(Offer object) {
        return dao.create(object);
    }

    @Override
    public int update(Offer object) {
        return dao.update(object);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public ArrayList<Offer> getAll() {
        return dao.getAll();
    }

    @Override
    public ArrayList<Form> getForms(Offer offer) {
        return dao.getForms(offer);
    }
}
