/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import java.util.HashMap;
import  Classes.Category;
import  Classes.Ingredient;

/**
 *
 * @author inknown
 */
public interface IMetierIngredient extends IMetier<Ingredient> {
    public HashMap<Integer,Ingredient> findByCategory(Category category);
}
