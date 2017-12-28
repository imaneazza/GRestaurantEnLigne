/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import java.util.ArrayList;
import  Classes.Category;
import  Classes.Ingrediant;
import Classes.Price;

/**
 *
 * @author inknown
 */
public interface IMetierIngredient extends IMetier<Ingrediant> {
    public ArrayList<Price> getPrices(Ingrediant ingediant);
    public ArrayList<Ingrediant> findByCategory(Category category);
}
