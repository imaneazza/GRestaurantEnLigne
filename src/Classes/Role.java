/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author mk
 */
public class Role {

    private int id;
    private String name;
    private ArrayList<Compte> comptes;

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
        this.comptes = new ArrayList<Compte>();
    }

    public Role(int id, String name, ArrayList<Compte> comptes) {
        this.id = id;
        this.name = name;
        this.comptes = comptes;
    }

    public Role() {
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

    public void addUser(Compte compte) {
        comptes.add(compte);
    }

    public void removeUser(Compte compte) {
        comptes.remove(compte);
    }

    public void removeUser(int id) {
        Compte u = findUser(id);
        if (u != null) {
            comptes.remove(u);
        }
    }

    public Compte findUser(int id) {
        for (Compte u : comptes) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public ArrayList<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(ArrayList<Compte> comptes) {
        this.comptes = comptes;
    }

    @Override
    public String toString() {
        return getId()+"- "+getName();
    }
}
