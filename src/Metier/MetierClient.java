package Metier;

import Classes.Client;
import Classes.Commande;
import Classes.Form;
import Classes.Offer;
import DAO.DAOClient;
import DAO.DAOOffer;

import java.util.ArrayList;

/**
 *
 * @author inknown
 */
public class MetierClient implements IMetierClient{
    private DAOClient dao=new DAOClient();


    @Override
    public Client find(int id) {
        return dao.find(id);
    }

    @Override
    public int create(Client object) {
        return dao.create(object);
    }

    @Override
    public int update(Client object) {
        return dao.update(object);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }
    @Override
    public ArrayList<Client> getAll() {
        return dao.getAll();
    }

    @Override
    public ArrayList<Commande> getCommandes(Client client) {
        return dao.getCommandes(client);
    }
}
