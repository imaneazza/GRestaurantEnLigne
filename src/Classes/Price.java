/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.Ingrediant;
import java.util.Date;

/**
 *
 * @author mk
 */
public class Price {
    private int id;
    private Date date;
    private float price;
    private Ingrediant ingredient=null;
    public Price() {
    }
    public Price(int id,Date date,float price) {
        this.id=id;
        this.date=date;
        this.price=price;
    }
    public Price(int id,Date date,float price,Ingrediant ingredient) {
        this.id=id;
        this.date=date;
        this.price=price;
        this.ingredient=ingredient;
    }
    
    


    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the ingredient
     */
    public Ingrediant getIngredient() {
        return ingredient;
    }

    /**
     * @param ingredient the ingredient to set
     */
    public void setIngredient(Ingrediant ingredient) {
        this.ingredient = ingredient;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }
}
