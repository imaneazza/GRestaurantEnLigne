/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBLinking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDDManager {
    private Connection con;
    private String driver,host,DBName,DBUser,DBPassword;
    public BDDManager() {
       driver="jdbc:mysql";
       host="localhost:3306";
       DBName="restaurantapp";
       DBUser="root";
       DBPassword="";
       PrepareConnextion(driver,host,DBName,DBUser,DBPassword); 
    }
    
    public BDDManager(String driver,String host,String DBName,String DBUser,String DBPassword) {
        PrepareConnextion(driver,host,DBName,DBUser,DBPassword); 
    }
    public void PrepareConnextion(String driver,String host,String DBName,String DBUser,String DBPassword) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDDManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
         setCon(DriverManager.getConnection(String.format("%s://%s/%s", driver,host,DBName),DBUser,DBPassword));
        } catch (SQLException ex) {
            Logger.getLogger(BDDManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public PreparedStatement createStatement(String Query) {
        try {
            return con.prepareStatement(Query);
        } catch (SQLException ex) {
            Logger.getLogger(BDDManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void close(){
        try {
            getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(BDDManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the DBName
     */
    public String getDBName() {
        return DBName;
    }

    /**
     * @param DBName the DBName to set
     */
    public void setDBName(String DBName) {
        this.DBName = DBName;
    }

    /**
     * @return the DBUser
     */
    public String getDBUser() {
        return DBUser;
    }

    /**
     * @param DBUser the DBUser to set
     */
    public void setDBUser(String DBUser) {
        this.DBUser = DBUser;
    }

    /**
     * @return the DBPassword
     */
    public String getDBPassword() {
        return DBPassword;
    }

    /**
     * @param DBPassword the DBPassword to set
     */
    public void setDBPassword(String DBPassword) {
        this.DBPassword = DBPassword;
    }

    
    
}
