/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import java.util.HashMap;
import  Classes.Role;
import  Classes.User;

/**
 *
 * @author inknown
 */
public interface IMetierUser extends IMetier<User> {
    public User connect(String login,String password);
    public HashMap<Integer,User> findByRole(Role role);
}
