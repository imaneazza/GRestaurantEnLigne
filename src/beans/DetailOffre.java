package beans;

import javafx.beans.property.*;

public class DetailOffre {
    private final SimpleLongProperty Forme;
    private final SimpleStringProperty libelle;
    private final SimpleIntegerProperty quantitemin,quantitemax;
    private final SimpleBooleanProperty  obligatory;


    public DetailOffre(long forme, String libelle, int max, int min,boolean obl) {
        this.Forme = new SimpleLongProperty(forme);
        this.libelle = new SimpleStringProperty(libelle);
        this.quantitemax = new SimpleIntegerProperty(max);
        this.quantitemin = new SimpleIntegerProperty(min);
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



    public int getQuantitemin() {
        return quantitemin.get();
    }


    public int getQuantitemax() {
        return quantitemax.get();
    }


}
