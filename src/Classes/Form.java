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
public class Form {

    private int id;
    private String name;
    private int OfferId;
    private ArrayList<Detail> details;

    public Form() {
        this.id = -1;
        name = "";
        details = new ArrayList<Detail>();
    }

    public Form(int id, String name, int OfferId, ArrayList<Detail> details) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.setOfferId(OfferId);
    }

    public Form(int id, String name, int OfferId) {
        this.id = id;
        this.name = name;
        this.setOfferId(OfferId);
        this.details=new ArrayList<Detail>();
    }

    public void addDetail(Detail detail) {
        this.details.add( detail);
    }

    public boolean isAvailable(ArrayList<Category> categories) {
        for (Detail detail : getDetails()) {
            if (detail.getMax() < detail.getIngredient().getStock()) {
                return false;
            }
        }
        return true;
    }

    public void removeDetail(Detail detail) {
        this.details.remove(detail);
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
     * @return the details
     */
    public ArrayList< Detail> getDetails() {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(ArrayList<Detail> details) {
        this.details = details;
    }

    public int getOfferId() {
        return OfferId;
    }

    public void setOfferId(int OfferId) {
        this.OfferId = OfferId;
    }
}
