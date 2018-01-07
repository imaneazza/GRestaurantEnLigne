package DAO;

import Classes.Commande;
import Classes.Form;
import Classes.Line;

import java.util.ArrayList;

public interface IDAOLine extends IDAO<Line>{
    public double getprice();
    public ArrayList<Line> findbyCommande(Commande cmd);
    public Line findbyCommandeForm(Commande cmd, Form form);

}
