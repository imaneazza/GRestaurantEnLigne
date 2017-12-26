package DAO;

import java.util.Date;
import java.util.HashMap;
import Classes.Ingredient;
import Classes.Price;

/**
 *
 * @author inknown
 */

interface IDAOPrice extends IDAO<Price>{
    HashMap<Integer,Price> findByIngredient(Ingredient ingredient);
}
