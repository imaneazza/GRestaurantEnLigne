/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Classes.Detail;
import  Classes.Form;
import  Classes.Offer;
import  DBLinking.DAO;

/**
 *
 * @author mk
 */
public class DAOForm extends DAO implements IDAOForm{

    private String id = "id";
    private String name = "name";
    private String idOffer = "OfferId";
    private DAODetail daoDetails=new DAODetail();

    public DAOForm() {
        super();
    }
    @Override
    public int executeQuery(String query,Form o){
        statement = createStatement(query+"SELECT LAST_INSERT_ID();");
        try {
           statement.setString(1, o.getName());
            statement.setInt(2, o.getId());
            statement.setInt(3, o.getOfferId());

            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAOForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int getlastID() throws SQLException {

        ResultSet rs = statement.executeQuery("Select LAST_INSERT_ID() from form limit 1");
        rs.next(); //para posicionar el puntero en la primer fila
        return rs.getInt("LAST_INSERT_ID()");
    }
    @Override
    public int create(Form o) {
        return executeQuery("INSERT INTO form(name,id,OfferId) Values(?,?,?);",o);

    }

    @Override
    public int update(Form o) {
        return executeQuery("UPDATE form SET nom=?,OfferId=? WHERE id=?;",o);

    }

    @Override
    public int delete(int id) {
        statement = createStatement("DELETE FROM form WHERE id=?;");
        try {
            statement.setInt(1, id);

            daoDetails.delete(id);
            return statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Form find(int id) {
        try {
            statement = createStatement("SELECT * FROM form WHERE id=?;");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Form o = ResultSetToObject(rs);
                o.setDetails(getDetails(o));
                return o;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Form> getAll() {
        ArrayList<Form> list = new ArrayList<Form>();
            statement = createStatement("SELECT * FROM form");
            return executeToArray();
    }

    @Override
    public Form ResultSetToObject(ResultSet rs) {
        try {
            Form o = new Form(rs.getInt(id), rs.getString(name),rs.getInt(idOffer));
            return o;
        } catch (SQLException ex) {
            Logger.getLogger(DAOForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @param
     * @return ArrayList<Form>
     */
    @Override
    public ArrayList<Form> findByOffer(Offer Offer) {
        try {
            statement = createStatement("SELECT * FROM form WHERE OfferId=?;");
            statement.setInt(1,Offer.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executeToArray();
    }
    public ArrayList<Form> executeToArray(){
        try {
            ArrayList<Form> list=new ArrayList<Form>();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Form o = ResultSetToObject(rs);
                o.setDetails(getDetails(o));
                list.add( o);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public ArrayList<Detail> getDetails(Form o) {

        return daoDetails.findByForm(o);
    }
}
