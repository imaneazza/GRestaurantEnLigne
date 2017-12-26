/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.HashMap;
import  Classes.Role;
import  Classes.User;



/**
 *
 * @author inknown
 */
public interface IDAOUser extends IDAO<User>{
    public User connect(String login,String password);
    public HashMap<Integer,User> findByRole(Role role);
}
