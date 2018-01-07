/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Classes.Commande;
import Classes.Line;

import java.util.ArrayList;

/**
 *
 * @author inknown
 */
public interface IMetierCommande extends IMetier<Commande>{
    ArrayList<Line> getLines(Commande commande);
}
