/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import java.util.HashMap;
import  Classes.Detail;
import  Classes.Form;
import  Classes.Ingredient;

/**
 *
 * @author inknown
 */
public interface IMetierDetail extends IMetier<Detail> {
    public HashMap<Integer,Detail> findByForm(Form form);
    public HashMap<Integer,Detail> findByIngredient(Ingredient ingredient);
}
