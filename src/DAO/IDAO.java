/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  DAO;

import Classes.PaimentMode;
import Classes.UniteMesure;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author inknown
 */
public interface IDAO<T> {
    int create(T object);
    int update(T object);
    int delete(int id);
    T find(int id);
    ArrayList<T> getAll();
    T ResultSetToObject(ResultSet rs);
    int executeQuery(String query,T o);
    ArrayList<T> executeToArray();
}
