/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import java.util.ArrayList;
import  Classes.Ingrediant;
import  Classes.Price;

/**
 *
 * @author inknown
 */
public interface IMetierPrice extends IMetier<Price> {
    public ArrayList<Price> findByIngredient(Ingrediant ingredient);
}
