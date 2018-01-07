package DAO;

import Classes.Commande;
import Classes.Comment;
import DBLinking.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOComment extends DAO implements IDAOComment{
    private String idComment="id";
    private String lineId="lineId";
    private String content="content";
    private String commandeId="commandeId";

    @Override
    public int create(Comment object) {
        object.setId(executeQuery(String.format("INSERT INTO comment( %s, %s, %s ,%s) VALUES(?,?,?,?);",commandeId,lineId,content,idComment),object));
        return object.getId();
    }

    @Override
    public int update(Comment object) {
        return executeQuery(String.format("UPDATE comment SET %s=? ,%s=?,%s=? WHERE %s=?",commandeId,lineId,content,idComment),object);

    }

    @Override
    public int delete(int id) {
        statement = createStatement(String.format("DELETE FROM comment WHERE %s=?;",idComment));
        try {
            statement.setInt(1, id);
            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Comment find(int id) {
        try {
            statement = createStatement(String.format("SELECT * FROM comment WHERE %s=?",idComment));
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return ResultSetToObject(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Comment> getAll() {
        statement = createStatement("SELECT * FROM comment ");
        return executeToArray();
    }

    @Override
    public Comment ResultSetToObject(ResultSet rs) {
        try {
            DAOLine line=new DAOLine();
            Comment comment = new Comment(rs.getInt(idComment), rs.getInt(commandeId),line.find(rs.getInt(lineId)) ,rs.getString(content));
            line.getManager().close();
            return comment;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int executeQuery(String query, Comment o) {
        statement = createStatement(query);
        try {
            statement.setInt(1, o.getIdCommande());
            statement.setInt(2, o.getLine().getIdLine());
            statement.setString(3, o.getContent());
            statement.setInt(4, o.getId());
            return executeToInt();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Comment> executeToArray() {
        try {
            ResultSet rs = statement.executeQuery();
            ArrayList<Comment> list = new ArrayList<Comment>();
            while (rs.next()) {
                Comment comment = ResultSetToObject(rs);
                list.add(comment);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Comment> findbyCommande(Commande cmd) {
        return findByInt(String.format("SELECT * FROM comment WHERE %s =?",commandeId),cmd.getId());

    }
    public ArrayList<Comment> findByInt(String query, int value) {
        try {
            statement = createStatement(query);
            statement.setInt(1,value);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executeToArray();
    }
}
