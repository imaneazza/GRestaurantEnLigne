package DAO;

import java.util.ArrayList;
import Classes.Ingrediant;
import  Classes.Price;

/**
 *
 * @author inknown
 */

interface IDAOPrice extends IDAO<Price>{

    public ArrayList<Price> findByIngrediant(Ingrediant ingrediant);
}
