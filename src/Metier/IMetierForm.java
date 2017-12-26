/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import java.util.HashMap;
import  Classes.Form;
import  Classes.Offre;

/**
 *
 * @author inknown
 */
public interface IMetierForm extends IMetier<Form> {
    public HashMap<Integer,Form> findByOffre(Offre offre);
}
