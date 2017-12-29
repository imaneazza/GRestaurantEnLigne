package Controller;

import Classes.Category;
import Classes.Ingrediant;
import Metier.MetierCategory;
import beans.ingredients;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CatInfoController implements Initializable{
    private  int id_cat;
    private int idingredient;
    private MetierCategory catmetier=new MetierCategory();
    private Category cat;

    public void setIdingredient(int idingredient) {
        this.idingredient = idingredient;
    }

    public int getIdingredient() {
        return idingredient;
    }

    @FXML
    private MenuBar menu;
    @FXML
    private TableView<ingredients> table;

    @FXML
    private Pane pan1;

    @FXML
    private Label txtlibelle;

    @FXML
    private Button update;

    @FXML
    private Label txtunite;

    @FXML
    private Pane pane;

    @FXML
    private Button delete;


    @FXML
    private Label txtprix;




    @FXML
    void gotoUpdate(ActionEvent event) {

        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Views/updateCat.fxml"));

            root = loader.load();
            updateCatController cat=loader.getController();
            cat.setIdingredient(idingredient);
            cat.ajouterdetail();
            pan1.getScene().getWindow().hide();
            Scene x=new Scene(root);
            x.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
            stage.setScene(x);
            stage.setTitle("Update Categorie");
            stage.setResizable(false);
            stage.setWidth(800);
            stage.setHeight(600);
            stage.show();
            //stage.initModality(Modality.WINDOW_MODAL);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    @FXML
    void DeleteIng(ActionEvent event) {
        //delete
        System.out.println(idingredient);
    }









    public  void setId_cat(int id_cat) {
        this.id_cat = id_cat;

    }

    public  long getId_cat() {
        return id_cat;
    }
    @FXML
    private ImageView image1;
    @FXML
    private TableColumn<ingredients, String> unite;

    @FXML
    private TableColumn<ingredients, Double> price;

    @FXML
    private TableColumn<ingredients, String> libelle;
    @FXML
    private TableColumn<ingredients, String> btn;
     private static ObservableList<ingredients> ingredientsliste = FXCollections.observableArrayList();

    public static ObservableList<ingredients> getIngredientsliste() {
        return ingredientsliste;
    }

    public static void setIngredientsliste(ObservableList<ingredients> ingredientsliste) {
        CatInfoController.ingredientsliste = ingredientsliste;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
public void setTable(){

    cat=catmetier.find(id_cat);

    ArrayList<Ingrediant> listeingredients=catmetier.getIngrediants(cat);


    ingredientsliste=FXCollections.observableArrayList();
    ingredientsliste.clear();
    for(Ingrediant ing:listeingredients){
        ingredientsliste.addAll(new ingredients(ing.getId(),ing.getName(),ing.getUnitMesure().toString(),ing.getCurrentPrice().getPrice()));
    }

    libelle.setCellValueFactory(new PropertyValueFactory<ingredients,String>("libelle"));
    unite.setCellValueFactory(new PropertyValueFactory<ingredients,String>("unite"));
    price.setCellValueFactory(new PropertyValueFactory<ingredients,Double>("prix"));
    table.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                show(newValue);
                setIdingredient(newValue.getId());
                update.setDisable(false);
                delete.setDisable(false);

            });

    update.setDisable(true);
    delete.setDisable(true);

    table.setItems(ingredientsliste);
}
    private void show(ingredients ing) {
        if (ing != null) {
            // Fill the labels with info from the person object.
            txtlibelle.setText(ing.getLibelle());
            txtprix.setText(String.valueOf(ing.getPrix()));
            txtunite.setText(ing.getUnite());

        } else {
            txtlibelle.setText("");
            txtprix.setText("");
            txtunite.setText("");

        }
    }

    @FXML
    void GoToOffre() throws IOException {
        Stage primaryStage=new Stage();
        pan1.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Offre.fxml"));
        primaryStage.setTitle("Creation Offre Page");

        Scene x=new Scene(root);
        x.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
        primaryStage.setScene(x);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @FXML
    void gotoliste(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = null;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/listeoffres.fxml"));
        root = loader.load();

        menu.getScene().getWindow().hide();
        Scene x=new Scene(root);
        x.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
        stage.setScene(x);
        stage.setTitle("Liste des Offres ");
        stage.setResizable(false);
        stage.setWidth(800);
        stage.setHeight(600);
        stage.show();
        //stage.initModality(Modality.WINDOW_MODAL);
    }
    @FXML
    void catGerer() throws IOException {
        Stage primaryStage=new Stage();
        pan1.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Catgerer.fxml"));
        primaryStage.setTitle("Gestion catégories des ingrédients Page");

        Scene x=new Scene(root);
        x.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
        primaryStage.setScene(x);
        primaryStage.setResizable(false);
        primaryStage.show();
    }




}
