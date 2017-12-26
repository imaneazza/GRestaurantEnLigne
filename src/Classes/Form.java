/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 *
 * @author inknown
 */
public class Form {

    private int id;
    private String name;
    private Offre offre = null;
    private HashMap<Integer,Detail> details = new HashMap<Integer,Detail>();

    public Form() {
        this.id = -1;
        name = "";
        offre = new Offre();
    }

    public Form(int id, String name, Offre offre,HashMap<Integer,Detail> details) {
        this.id = id;
        this.name = name;
        this.offre = offre;
        this.details.putAll(details);
    }

    public Form(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addDetail(Detail detail) {
        this.details.put(details.size(),detail);
    }

    public boolean isAvailable() {
        for (Detail detail : getDetails().values()) {
            if (detail.getMax() < detail.getIngredient().getStock()) {
                return false;
            }
        }
        return true;
    }

    public void removeDetail(Detail detail) {
        this.getDetails().remove(detail);
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
     * @return the offre
     */
    public Offre getOffre() {
        return offre;
    }

    /**
     * @param offre the offre to set
     */
    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    /**
     * @return the details
     */
    public HashMap<Integer,Detail> getDetails() {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(HashMap<Integer,Detail> details) {
        this.details = details;
    }

}
