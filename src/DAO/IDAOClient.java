/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Client;
import Classes.Compte;
import Classes.Role;

import java.util.ArrayList;


/**
 *
 * @author inknown
 */
public interface IDAOClient extends IDAO<Client>{
    ArrayList<Client> findByCompte(Compte compte);
}
