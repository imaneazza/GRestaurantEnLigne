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
public class Offre {
    private int id;
    private String name;
    private String imageSource;
    private boolean state = false;
    private Map<Integer,Form> forms = new HashMap<Integer,Form>();

    
    public Offre() {
        this.id = -1;
        name = "";
        imageSource = "";
    }

    public Offre(int id, String name, String imageSource, boolean state,HashMap<Integer,Form> forms) {
        this.id = id;
        this.name = name;
        this.imageSource = imageSource;
        this.state=state;
        this.forms.putAll(forms);
    }
        public Offre(int id, String name, String imageSource, boolean state) {
        this.id = id;
        this.name = name;
        this.imageSource = imageSource;
        this.state=state;
    }
    
    public boolean isAvailable(HashMap<Integer, Ingredient> stock){
        for(Form form : forms.values())     if(!form.isAvailable()) return false;
        return true;
    }
    
    public void addNewForm(Form form){
        this.getForms().put(form.getId(), form);
    }
    public void removeForm(Form form){
        this.getForms().remove(form);
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
     * @return the state
     */
    public boolean getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(boolean state) {
        this.state = state;
    }

    /**
     * @return the forms
     */
    public Map<Integer,Form> getForms() {
        return forms;
    }

    /**
     * @param forms the forms to set
     */
    public void setForms(Map<Integer,Form> forms) {
        this.forms = forms;
    }
}
