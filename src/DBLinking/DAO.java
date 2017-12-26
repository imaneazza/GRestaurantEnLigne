/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBLinking;

import java.sql.PreparedStatement;

/**
 *
 * @author inknown
 */
public class DAO {
    protected PreparedStatement statement;
    BDDManager manager=new BDDManager();
    public DAO() {
        manager=new BDDManager();
    }
    public PreparedStatement createStatement(String Query){
        return manager.createStatement(Query);
                
    }

    public BDDManager getManager() {
        return manager;
    }
}
