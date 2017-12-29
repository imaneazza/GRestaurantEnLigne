package Controller;

import Classes.Category;
import DAO.DAOCategory;
import Metier.MetierCategory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

public class CatgererController implements Initializable {
    @FXML
    private GridPane gpanel;
    @FXML
    private Pane pan1;

    @FXML
    private Pane pan11;
    MetierCategory cat=new MetierCategory();
    ArrayList<Category> liste=cat.getAll();
    @FXML
    private MenuBar menu;

    @FXML
    private Pagination page;
    private MetierCategory catmetier;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int count=liste.size()/6;
        page.setPageCount(liste.size()%6==0?count:count+1);
       page.setPageFactory((Integer pageIndex) -> createPage(pageIndex));

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
    public GridPane createPage(int pageIndex) {
        System.out.println(pageIndex);
        gpanel.setAlignment(Pos.TOP_CENTER);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100/3);
        RowConstraints constraint=new RowConstraints();
        constraint.setPercentHeight(50);
        gpanel.getRowConstraints().clear();
        gpanel.getColumnConstraints().clear();
        gpanel.getColumnConstraints().addAll(column1,column1,column1);
        gpanel.getRowConstraints().addAll(constraint,constraint);
        gpanel.setStyle("-fx-background-color: white;");
        ImageView im;


int a;
        for(int i=0;i<3;i++) {
            a = pageIndex * 6 + i;
            if (liste.size() > a) {
                Category category = liste.get(a);
                im = new ImageView(new Image(category.getImageSource()));
                im.setFitHeight(150);
                im.setFitWidth(150);

                gpanel.add(im, i, (i < 4) ? 0 : 1);
                gpanel.setHalignment(im, HPos.CENTER);

            }
        }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    addPane(i, j, pageIndex);
                }
            }

        return gpanel;

    }

    private void addPane(int colIndex, int rowIndex ,int page) {
        Pane pane = new Pane();
        int a;
             a=(page * 6) + (rowIndex*2)+colIndex;
        System.out.println(liste.size()+"hellow");
            if (liste.size() > a) {
                pane.setOnMouseClicked(e -> {
                    Stage stage = new Stage();
                    Parent root = null;
                    try {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/Views/Catinfo.fxml"));
                        root = loader.load();
                        CatInfoController cat = loader.getController();
                        System.out.println("iddd"+liste.get(a).getId());
                        cat.setId_cat(liste.get(a).getId());
                        cat.setTable();
                        gpanel.getScene().getWindow().hide();
                        Scene x = new Scene(root);
                        x.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
                        stage.setScene(x);
                        stage.setTitle("Détail Categorie");
                        stage.setResizable(false);
                        stage.setWidth(800);
                        stage.setHeight(600);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    stage.initOwner(
                            ((Node) e.getSource()).getScene().getWindow());
                    stage.show();
                });
            }
        gpanel.add(pane, colIndex, rowIndex);
    }
    @FXML
    void GoToOffre() throws IOException {
        Stage primaryStage=new Stage();
        gpanel.getScene().getWindow().hide();
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
        gpanel.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Catgerer.fxml"));
        primaryStage.setTitle("Gestion catégories des ingrédients Page");
        Scene x=new Scene(root);
        x.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
        primaryStage.setScene(x);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    @FXML
    void addfct() throws IOException {
        Stage primaryStage=new Stage();
        gpanel.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/addcat.fxml"));
        primaryStage.setTitle("Ajouter Catégorie Page");
        Scene x=new Scene(root);
        x.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
        primaryStage.setScene(x);
        primaryStage.setResizable(false);
        primaryStage.show();    }
}
