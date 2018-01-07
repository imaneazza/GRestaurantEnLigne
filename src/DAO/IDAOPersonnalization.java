package DAO;

import Classes.Ingrediant;
import Classes.Line;
import Classes.Personalization;

import java.util.ArrayList;

public interface IDAOPersonnalization  extends IDAO<Personalization>{
    public ArrayList<Personalization> findByLine(Line line);
    public Personalization findByLineIngredient(Ingrediant ing,Line line);
    public int deletebyLine(Line line);
}
