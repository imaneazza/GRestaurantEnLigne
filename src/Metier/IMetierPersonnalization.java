package Metier;

import Classes.Ingrediant;
import Classes.Line;
import Classes.Personalization;
import DAO.IDAO;

import java.util.ArrayList;

public interface IMetierPersonnalization extends IMetier<Personalization>{
    public ArrayList<Personalization> findByLine(Line line);
    public Personalization findByLineIngredient(Ingrediant ing, Line line);
    public int deletebyLine(Line line);
}
