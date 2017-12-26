package Controller;

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
import java.util.ResourceBundle;

public class CatInfoController implements Initializable{
    private  long id_cat;
    private long idingredient;

    public void setIdingredient(long idingredient) {
        this.idingredient = idingredient;
    }

    public long getIdingredient() {
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

            //get categorie
            pan1.getScene().getWindow().hide();
            stage.setScene(new Scene(root));
            stage.setTitle("Update Categorie");
            stage.setResizable(false);
            //set Stage boundaries to visible bounds of the main screen
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









    public  void setId_cat(long id_cat) {
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
    //getingredients by cat
       Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
       ingredientsliste.clear();
        ingredientsliste.addAll(new ingredients(1,"ingredient1","gramme",20.20),
                new ingredients(10,"ingredient1555","litres",20.20));

      libelle.setCellValueFactory(new PropertyValueFactory<ingredients,String>("libelle"));
        unite.setCellValueFactory(new PropertyValueFactory<ingredients,String>("unite"));
        price.setCellValueFactory(new PropertyValueFactory<ingredients,Double>("prix"));
        table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    show(newValue);setIdingredient(newValue.getId());
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
            System.out.println("id"+ing.getId());

        } else {
            // Person is null, remove all the text.
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

        primaryStage.setScene(new Scene(root));
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
        stage.setScene(new Scene(root));
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

        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }




}
