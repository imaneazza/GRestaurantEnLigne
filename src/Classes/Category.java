/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author inknown
 */
public class Category {
    private int id;
    private String name,imageSource;
    private Map<Integer,Ingredient> ingredients;
    public Category() {
        this.id=-1;
        name="inknown";
        imageSource="inknown";
        this.ingredients = new HashMap<Integer,Ingredient>();
    }
    public Category(int id,String name,String imageSource,HashMap<Integer,Ingredient> ingredients) {
        this.id=id;
        this.name=name;
        this.imageSource=imageSource;
        this.ingredients.putAll(ingredients);
    }
        public Category(int id,String name,String imageSource) {
        this.id=id;
        this.name=name;
        this.imageSource=imageSource;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the imageSource
     */
    public String getImageSource() {
        return imageSource;
    }

    /**
     * @param imageSource the imageSource to set
     */
    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    /**
     * @return the ingredients
     */
    public Map<Integer,Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * @param ingredients the ingredients to set
     */
    public void setIngredients(Map<Integer,Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
