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
public class Offer {
    private int id;
    private String name;
    private String imageSource;
    private boolean state = false;
    private ArrayList<Form> forms;

    
    public Offer() {
        this.id = -1;
        name = "";
        imageSource = "";
    }

    public Offer(int id, String name, String imageSource, boolean state,ArrayList<Form> forms) {
        this.id = id;
        this.name = name;
        this.imageSource = imageSource;
        this.state=state;
        this.forms=forms;
    }
        public Offer(int id, String name, String imageSource, boolean state) {
        this.id = id;
        this.name = name;
        this.imageSource = imageSource;
        this.state=state;
        this.forms= new ArrayList<Form>();
    }
    
    public boolean isAvailable(ArrayList<Category> stock){
        for(Form form : forms)     if(!form.isAvailable(stock)) return false;
        return true;
    }
    
    public void addNewForm(Form form){
        this.forms.add(form);
    }
    public void removeForm(Form form){
        this.forms.remove(form);
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
    public ArrayList<Form> getForms() {
        return forms;
    }

    /**
     * @param forms the forms to set
     */
    public void setForms(ArrayList<Form> forms) {
        this.forms = forms;
    }
    public void activate(){
        this.state=true;
    }
    public void desactivate(){
        this.state=false;
    }
}
