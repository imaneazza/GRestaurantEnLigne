/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBLinking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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



            public int executeToInt(){
                try {
                    ResultSet rs= statement.executeQuery();
                    if(rs.next())   return rs.getInt(1);
                } catch (SQLException ex) {
                    System.out.println(ex.getErrorCode()+ex.getMessage());
                }
                return -1;
            }
}
