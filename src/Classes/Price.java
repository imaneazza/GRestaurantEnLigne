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
    private int ingredientId=-1;
    public Price() {
    }
    public Price(int id,Date date,float price) {
        this.id=id;
        this.date=date;
        this.price=price;
    }
    public Price(int id,Date date,float price,int ingredientId) {
        this.id=id;
        this.date=date;
        this.price=price;
        this.ingredientId=ingredientId;
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
     * @return the ingredientId
     */
    public int getIngredientId() {
        return ingredientId;
    }

    /**
     * @param ingredientId the ingredientId to set
     */
    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
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
