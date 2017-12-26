/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  DAO;

import java.util.HashMap;
import  Classes.Category;
import  Classes.Ingredient;


/**
 *
 * @author inknown
 */
public interface IDAOCategory extends IDAO<Category>{
    public HashMap<Integer,Ingredient> getIngredients(Category category);
}
