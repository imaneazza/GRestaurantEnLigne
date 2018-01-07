/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBLinking;

import Classes.PaimentMode;
import Classes.UniteMesure;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author inknown
 */
public class DAO {
    protected PreparedStatement statement;
    BDDManager manager = new BDDManager();

    public DAO() {
        manager = new BDDManager();
    }

    public PreparedStatement createStatement(String Query) {
        return manager.createStatement(Query);

    }

    public BDDManager getManager() {
        return manager;
    }


    public int executeToInt() {
        try {
             statement.executeUpdate();
            ResultSet rs=statement.getGeneratedKeys();
            if(rs.next())return rs.getInt(1);

        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode() + ex.getMessage());
        }
        return -1;
    }
    public UniteMesure StringToUniteMesure(String uniteMesure) {
        switch (uniteMesure) {
            case "ml":
                return UniteMesure.ml;
            case "cl":
                return UniteMesure.cl;
            case "litres":
                return UniteMesure.litres;
            case "mg":
                return UniteMesure.mg;
            case "cg":
                return UniteMesure.cg;
            case "g":
                return UniteMesure.g;
            case "kg":
                return UniteMesure.kg;
            default:
                return UniteMesure.autre;
        }
    }
    public PaimentMode StringToPaimentMode(String paimentMode) {
        switch (paimentMode) {
            case "ONLINE":
                return PaimentMode.onligne;
            case "DELIVERING":
                return PaimentMode.livraison;
            default:
                return PaimentMode.autre;
        }
    }
}
