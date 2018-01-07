/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import  Classes.Role;
import Classes.Compte;



/**
 *
 * @author inknown
 */
public interface IDAOCompte extends IDAO<Compte>{
    public Compte connect(String login, String password);
    public ArrayList<Compte> findByRole(Role role);
}
