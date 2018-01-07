package Classes;

public class Personalization {
    private  int idLine;
    private Ingrediant ing;
    private  double qte;

    /**
     *
     * @param idLine
     * @param ing
     * @param qte
     */
    public Personalization(int idLine, Ingrediant ing, double qte) {
        this.idLine = idLine;
        this.ing = ing;
        this.qte = qte;
    }

    /**
     * no param
     */
    public Personalization() {
    }

    /**
     *
     * @return Line ID
     */
    public int getIdLine() {
        return idLine;
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
     * @return Ingredient
     */
    public Ingrediant getIng() {
        return ing;
    }

    /**
     *
     * @param ing
     */
    public void setIng(Ingrediant ing) {
        this.ing = ing;
    }

    /**
     *
     * @return Quantity
     */
    public double getQte() {
        return qte;
    }

    /**
     *
     * @param qte
     */
    public void setQte(double qte) {
        this.qte = qte;
    }
    public double getTotal() {
        return ing.getCurrentPrice().getPrice()*qte;
    }
    @Override
    public String toString() {
        return String.format("%d\t%s\t%f",idLine,ing.getName(),qte);
    }
}
