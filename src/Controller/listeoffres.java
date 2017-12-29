package Controller;

import Classes.Offer;
import DAO.DAOOffer;
import Metier.MetierOffer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class listeoffres implements Initializable {
    @FXML
    private GridPane gpanel;
    @FXML
    private Pane pan1;

    @FXML
    private Pane pan11;
    @FXML
    private MenuBar menu;

    @FXML
    private Pagination page;
    MetierOffer metierOffer=new MetierOffer();
    ArrayList<Offer> liste=metierOffer.getAll();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int a=liste.size()/6;
        if(liste.size()%6!=0)a++;
        page.setPageCount(a);
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
        for(int i=0;i<6;i++) {
            int a=(pageIndex * 6) + i;
            if (liste.size()>a) {
                    Offer x = liste.get(a);
                im = new ImageView(new Image(x.getImageSource()));
                im.setFitHeight(150);
                im.setFitWidth(150);
                if (i < 4)
                    gpanel.add(im, i, 0);
                else
                    gpanel.add(im, i, 1);
                gpanel.setHalignment(im, HPos.CENTER);

            }
        }

        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0; j < 2; j++) {
                addPane(i, j,pageIndex);
            }}

        return gpanel;

    }

    private void addPane(int colIndex, int rowIndex ,int page) {
        Pane pane = new Pane();
        int a=(page * 6) + (rowIndex*2)+colIndex;
        if (liste.size()>a) {
            pane.setOnMouseClicked(e -> {
                Stage stage = new Stage();
                Parent root = null;
                try {
                    FXMLLoader loader = new FXMLLoader();

                    loader.setLocation(getClass().getResource("/Views/offreinfo.fxml"));
                    root = loader.load();
                    offreinfo offreController = loader.getController();
                    offreController.setIdoffre(liste.get(a).getId());
                    offreController.getdata();
                    //get categorie
                    gpanel.getScene().getWindow().hide();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Détail Categorie");
                    stage.setResizable(false);
                    stage.setWidth(800);
                    stage.setHeight(600);
                    //stage.initModality(Modality.WINDOW_MODAL);
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

}
