/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Commande;
import Classes.Line;

import java.util.ArrayList;


/**
 *
 * @author inknown
 */
public interface IDAOCommande extends IDAO<Commande>{
    ArrayList<Line> getLines(Commande commande);
}
