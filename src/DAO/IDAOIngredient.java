/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import  Classes.Category;
import Classes.Ingrediant;
import Classes.Price;

/**
 *
 * @author inknown
 */
public interface IDAOIngredient extends IDAO<Ingrediant> {
    ArrayList<Ingrediant> findByCategory(Category category);
    public int addStock(Ingrediant ingredient,int quantity);
    public int consume(Ingrediant ingredient,int quantity);
    ArrayList<Price> getPrices(Ingrediant ingrediant);

}
