package project;

import Classes.Category;
import Classes.Ingrediant;
import Classes.Price;
import Classes.UniteMesure;
import Metier.MetierCategory;
import Metier.MetierIngredient;
import Metier.MetierPrice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws SQLException {
        MetierCategory cat=new MetierCategory();



        MetierIngredient mingredient=new MetierIngredient();
        MetierPrice price=new MetierPrice();
       /* Ingrediant ing=new Ingrediant(0,"Ingredient Test", UniteMesure.litres,20,1);
       int a=mingredient.create(ing);
         System.out.println(ing.getName()+" "+ing.getId());
        Price p=new Price(0, new Date(),150,a);
        price.create(p);
        System.out.println(p.getId()+" "+p.getIngredientId()+" "+p.getDate().toString());*/
       /* ArrayList<Category> liste=cat.getAll();
        for(Category c:liste){
            System.out.println(c.getName());
            for(Ingrediant in:c.getIngrediants()){
                System.out.println(in.getName()+" "+in.getCurrentPrice().getPrice());
            }
        }*/
        System.out.println(mingredient.find(1).getName());
        System.out.println(price.find(1).getDate());
        System.out.println(cat.find(1).getName());
      /*
       Category c=new Category(0,"test","");
       cat.create(c);
        System.out.println(c.getId()+" "+c.getName());/
      cat.update(new Category(10,"HellowCat","hh"));
      mingredient.update(new Ingrediant(60,"Namex",UniteMesure.litres,20,10));
      price.update(new Price(60,new Date(),800,60));*/
      //cat.delete(10);
       // mingredient.delete(61);
       // price.delete(-1);
    }
}
