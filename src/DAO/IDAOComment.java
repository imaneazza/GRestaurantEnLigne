package DAO;

import Classes.Commande;
import Classes.Comment;

import java.util.ArrayList;

public interface IDAOComment  extends IDAO<Comment>{

    public ArrayList<Comment> findbyCommande(Commande cmd);
}
