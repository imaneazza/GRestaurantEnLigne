package Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class updateCatController implements Initializable {
    private  long idingredient;

    public  long getIdingredient() {
        return idingredient;
    }

    public  void setIdingredient(long idingredient) {
        idingredient = idingredient;
    }

    @FXML
    private Pane pan1;
    @FXML
    private TextField txtlibelleupdate;

    @FXML
    private Button annulerbtn;

    @FXML
    private TextField txtuniteupdate;

    @FXML
    private ComboBox<String> combocat;

    @FXML
    private Button confirmbtn;

    @FXML
    private MenuBar menu;

       @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(idingredient);
        //getingredient byid;
           //getcategoris

           ObservableList<String> options =
                   FXCollections.observableArrayList(
                           "Cat1 ",
                           "Cat2"
                   );
                    options.add("Cat3");
                    combocat.setItems(options);
           txtlibelleupdate.setText("Old Libelle");
           txtuniteupdate.setText("Old Unite");
           combocat.setValue("Cat3");


       }

    @FXML
    void GoToOffre() throws IOException {
        Stage primaryStage=new Stage();
        pan1.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Catgerer.fxml"));
        primaryStage.setTitle("Gestion catégories des ingrédients Page");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    @FXML
    void catGerer() throws IOException {
        Stage primaryStage=new Stage();
        pan1.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Offre.fxml"));
        primaryStage.setTitle("Creation Offre Page");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @FXML
    void updateIngredient(){
        System.out.println(combocat.getSelectionModel().getSelectedItem());
        System.out.println("libelle"+txtlibelleupdate.getText());
        System.out.println("Unite"+txtuniteupdate.getText());
        //update
    }

    @FXML
    void gotolisteing(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = null;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/Catinfo.fxml"));
        root = loader.load();
        CatInfoController cat=loader.getController();
        cat.setIdingredient(idingredient);

        //get categorie
        menu.getScene().getWindow().hide();
        stage.setScene(new Scene(root));
        stage.setTitle("Détail Categorie");
        stage.setResizable(false);
        stage.setWidth(800);
        stage.setHeight(600);
        stage.show();
        //stage.initModality(Modality.WINDOW_MODAL);
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
}
