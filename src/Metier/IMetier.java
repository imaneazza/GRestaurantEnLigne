/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Metier;

import java.util.HashMap;

/**
 *
 * @author inknown
 */
public interface IMetier<T> {
    public T find(int id);
    public int create(T object);
    public int update(T object);
    public int delete(int id);
    public HashMap<Integer,T> getAll();
}
