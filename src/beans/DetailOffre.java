package beans;

import javafx.beans.property.*;

public class DetailOffre {
    private final SimpleLongProperty Forme;
    private final SimpleStringProperty libelle;
    private final SimpleDoubleProperty quantitemin,quantitemax;
    private final SimpleBooleanProperty  obligatory;


    public DetailOffre(long forme, String libelle, double max, double min,boolean obl) {
        this.Forme = new SimpleLongProperty(forme);
        this.libelle = new SimpleStringProperty(libelle);
        this.quantitemax = new SimpleDoubleProperty(max);
        this.quantitemin = new SimpleDoubleProperty(min);
        this.obligatory=new SimpleBooleanProperty(obl);




    }

    public boolean isObligatory() {
        return obligatory.get();
    }

    public long getForme() {
        return Forme.get();
    }



    public String getLibelle() {
        return libelle.get();
    }



    public double getQuantitemin() {
        return quantitemin.get();
    }


    public double getQuantitemax() {
        return quantitemax.get();
    }


}
