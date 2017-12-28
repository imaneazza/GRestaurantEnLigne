/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Form;
import  Classes.Offer;

import java.util.ArrayList;

/**
 *
 * @author inknown
 */
public interface IDAOOffer extends IDAO<Offer>{
    public ArrayList<Form> getForms(Offer o);
}
