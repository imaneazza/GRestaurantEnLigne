package Classes;

import java.util.List;

public class Comment {
    private int id;
    private int idCommande;
    private Line line;
    private String content;

    /**
     *
     * @param id
     * @param idCommande
     * @param line
     * @param content
     */
    public Comment(int id, int idCommande, Line line, String content) {
        this.id = id;
        this.idCommande = idCommande;
        this.line = line;
        this.content = content;
    }

    /**
     * No Param
     */
    public Comment() {
    }

    /**
     *
     * @return Comment ID
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return Commande
     */
    public int getIdCommande() {
        return idCommande;
    }

    /**
     *
     * @param idCommande
     */
    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    /**
     *
     * @return Line Id
     */
    public Line getLine() {
        return line;
    }

    /**
     *
     * @param line
     */
    public void setIdLine(Line line) {
        this.line = line;
    }

    /**
     *
     * @return Content
     */
    public String getContent() {
        return content;
    }

    /**
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}
