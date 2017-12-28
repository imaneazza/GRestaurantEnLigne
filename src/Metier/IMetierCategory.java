/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import  Classes.Category;
import Classes.Ingrediant;

import java.util.ArrayList;

/**
 *
 * @author inknown
 */
public interface IMetierCategory extends IMetier<Category>{
    public ArrayList<Ingrediant> getIngrediants(Category category);
}
