/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Classes.Commande;
import Classes.Comment;

import java.util.ArrayList;

/**
 *
 * @author inknown
 */
public interface IMetierComment extends IMetier<Comment>{
    public ArrayList<Comment> findbyCommande(Commande cmd);
}
