/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.util.ArrayList;
import  Classes.Detail;
import  Classes.Form;
import  Classes.Offer;

/**
 *
 * @author inknown
 */
public interface IDAOForm extends IDAO<Form> {
    public ArrayList<Detail> getDetails(Form o);
    public ArrayList<Form> findByOffer(Offer o);

}
