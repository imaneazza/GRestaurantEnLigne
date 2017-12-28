/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import  Classes.Role;
import Classes.User;

/**
 *
 * @author inknown
 */
public interface IDAORole extends IDAO<Role>{
    public ArrayList<User> getUsers(Role role);
}
