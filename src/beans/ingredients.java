package beans;

import Controller.CatInfoController;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import Controller.updateCatController;
import java.io.IOException;

public class ingredients {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty libelle;
    private final SimpleStringProperty unite;
    private final SimpleDoubleProperty prix;


    public ingredients(int id, String libelle, String unite, double prix) {
        this.id = new SimpleIntegerProperty(id);
        this.libelle = new SimpleStringProperty(libelle);
        this.unite = new SimpleStringProperty(unite);
        this.prix = new SimpleDoubleProperty(prix);




    }

    public int getId() {
        return id.get();
    }

    public String getLibelle() {
        return libelle.get();
    }

    public String getUnite() {
        return unite.get();
    }

    public double getPrix() {
        return prix.get();
    }


}
