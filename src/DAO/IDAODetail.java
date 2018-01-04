/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import  Classes.Detail;
import  Classes.Form;
import Classes.Ingrediant;

/**
 *
 * @author inknown
 */
public interface IDAODetail extends IDAO<Detail> {
    public ArrayList<Detail> findByForm(Form o);
    public int delete(int id,int ing);
    public ArrayList<Detail> findByIngrediant(Ingrediant o);

}
