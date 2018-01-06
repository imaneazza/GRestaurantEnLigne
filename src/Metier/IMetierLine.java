/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Classes.Commande;
import Classes.Form;
import Classes.Line;

import java.util.ArrayList;

/**
 *
 * @author inknown
 */
public interface IMetierLine extends IMetier<Line>{
    public double getprice();
    public ArrayList<Line> findbyCommande(Commande cmd);
    public Line findbyCommandeForm(Commande cmd, Form form);
}
