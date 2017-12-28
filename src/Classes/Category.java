/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author inknown
 */
public class Category {

    private int id;
    private String name, imageSource;
    private ArrayList<Ingrediant> ingrediants;

    public Category() {
        this.id = -1;
        name = "inknown";
        imageSource = "inknown";
        this.ingrediants = new ArrayList<Ingrediant>();
    }

    public Category(int id, String name, String imageSource) {
        this.id = id;
        this.name = name;
        this.imageSource = imageSource;
        this.ingrediants = new ArrayList<Ingrediant>();
    }
    public Category(int id, String name, String imageSource,ArrayList<Ingrediant> ingrediants) {
        this.id = id;
        this.name = name;
        this.imageSource = imageSource;
        this.ingrediants = ingrediants;
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


    public Ingrediant findIngrediant(int id){
        for(Ingrediant i :ingrediants)  if(i.getId()==id) return i;
        return null;
    }

    public ArrayList<Ingrediant> getIngrediants() {
        return ingrediants;
    }

    public void setIngrediants(ArrayList<Ingrediant> ingrediants) {
        this.ingrediants = ingrediants;
    }
}
