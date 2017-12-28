/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import java.util.ArrayList;
import  Classes.Detail;
import  Classes.Form;
import  Classes.Ingrediant;

/**
 *
 * @author inknown
 */
public interface IMetierDetail extends IMetier<Detail> {
    public ArrayList<Detail> findByForm(Form form);
    public ArrayList<Detail> findByIngredient(Ingrediant ingredient);
}
