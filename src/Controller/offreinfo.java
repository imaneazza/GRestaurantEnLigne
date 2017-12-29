package Controller;

import Classes.Offer;
import DAO.DAOOffer;
import Metier.MetierOffer;
import beans.DetailOffre;
import beans.ingredients;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class offreinfo implements Initializable{
    private  int idoffre;
    private long idingredient;
    private Offer offre;
    private MetierOffer metierOffer=new MetierOffer();


    @FXML
    private ImageView img;
    @FXML
    private ComboBox<String> formes;


    @FXML
    private TableColumn<DetailOffre, Integer> max;

    @FXML
    private TableColumn<DetailOffre, String> libelle;

    @FXML
    private TableColumn<DetailOffre, Boolean> obligatoire;
    @FXML
    private TableColumn<DetailOffre, Integer> min;

    @FXML
    private Button update;

    @FXML
    private MenuBar menu;

    @FXML
    private Button delete;

    @FXML
    private Label txtprix;


    @FXML
    private Label txtlibelle;


    @FXML
    private Pane pane;

    @FXML
    private TableView<DetailOffre> table;






    public void setIdingredient(long idingredient) {
        this.idingredient = idingredient;
    }

    public long getIdingredient() {
        return idingredient;
    }

    public int getIdoffre() {
        return idoffre;
    }

    public void setIdoffre(int idoffre) {
        this.idoffre = idoffre;
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



     private static ObservableList<DetailOffre> ingredientsliste = FXCollections.observableArrayList();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    //getingredients by offre


    }
public void getdata(){
        offre=metierOffer.find(idoffre);
    txtlibelle.setText(offre.getName());
    ObservableList<String> options =
            FXCollections.observableArrayList();
    // formes
    options.add("Grand");

    formes.setItems(options);
    formes.setValue("Select forme ");
    formes.valueProperty().addListener(new ChangeListener<String>() {
        @Override public void changed(ObservableValue ov, String t, String t1) {

            System.out.println(t1);
            //getforme
            showtable();
        }
    });
    img.setImage(new Image("images/offres/offre" + idoffre+ ".jpg"));

}

    @FXML
    void GoToOffre() throws IOException {
        Stage primaryStage=new Stage();
        menu.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Offre.fxml"));
        primaryStage.setTitle("Creation Offre Page");

        Scene x=new Scene(root);
        x.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
        primaryStage.setScene(x);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    @FXML
    void catGerer() throws IOException {
        Stage primaryStage=new Stage();
        menu.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Catgerer.fxml"));
        primaryStage.setTitle("Gestion catégories des ingrédients Page");

        Scene x=new Scene(root);
        x.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
        primaryStage.setScene(x);
        primaryStage.setResizable(false);
        primaryStage.show();
    }



    @FXML
    void updateoffre(ActionEvent event) {

        System.out.println(idoffre);

    }

    @FXML
    void deleteoffre(ActionEvent event) {

    }

    void showtable() {
        ingredientsliste.clear();
        ingredientsliste.addAll(new DetailOffre(10,"Ingredient1",15,10,true),
                new DetailOffre(10,"Ingredient2",100,80,false),
                new DetailOffre(10,"Ingredient3",2,1,true));

        libelle.setCellValueFactory(new PropertyValueFactory<DetailOffre,String>("libelle"));
        max.setCellValueFactory(new PropertyValueFactory<DetailOffre,Integer>("quantitemax"));
        min.setCellValueFactory(new PropertyValueFactory<DetailOffre,Integer>("quantitemin"));
        obligatoire.setCellValueFactory(new PropertyValueFactory<DetailOffre,Boolean>("obligatory"));

        table.setItems(ingredientsliste);
        table.refresh();



    }


}
