/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author inknown
 */
public interface IDAO<T> {
    public int create(T object);
    public int update(T object);
    public int delete(int id);
    public T find(int id);
    public ArrayList<T> getAll();
    public T ResultSetToObject(ResultSet rs);
    public int executeQuery(String query,T o);
    public ArrayList<T> executeToArray();
}
