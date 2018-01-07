package Classes;

public class Line {
    private int idLine;
    private Form form ;
    private int idCommande;
    private int quantity;

    /**
     *
     * @return int ( Commande ID)
     */
    public int getComamnde() {
        return idCommande;
    }

    /**
     *
     * @return the form
     */
    public Form getForm() {
        return form;
    }

    /**
     *
     * @return Line id
     */
    public int getIdLine() {
        return idLine;
    }

    /**
     *
     * @return Quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param idLine
     * @param form
     * @param idCommande
     * @param quantity
     */
    public Line(int idLine, Form form, int idCommande, int quantity) {
        this.idLine = idLine;
        this.form = form;
        this.idCommande = idCommande;
        this.quantity = quantity;
    }

    /**
     * No param
     */
    public Line() {
    }

    /**
     *
     * @param idLine
     */
    public void setIdLine(int idLine) {
        this.idLine = idLine;
    }

    /**
     *
     * @param form
     */
    public void setForm(Form form) {
        this.form = form;
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
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
