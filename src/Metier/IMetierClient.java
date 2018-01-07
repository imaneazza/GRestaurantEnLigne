package Metier;
import Classes.Client;
import Classes.Commande;
import java.util.ArrayList;

public interface IMetierClient extends IMetier<Client>{

    ArrayList<Commande> getCommandes(Client client);
}
