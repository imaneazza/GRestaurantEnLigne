/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import java.util.ArrayList;
import  Classes.Offer;
import  Classes.Form;
import  Classes.Detail;

/**
 *
 * @author inknown
 */
public interface IMetierForm extends IMetier<Form> {
    public ArrayList<Detail> getDetails(Form form);
    public ArrayList<Form> findByOffer(Offer Offer);
}
