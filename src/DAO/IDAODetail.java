/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  DAO;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import  Classes.Detail;
import  Classes.Form;
import  Classes.Ingredient;

/**
 *
 * @author inknown
 */
public interface IDAODetail extends IDAO<Detail> {
    public HashMap<Integer, Detail> findByForm(Form form);
    public HashMap<Integer, Detail> findByIngredient(Ingredient ingredient);
    
}
