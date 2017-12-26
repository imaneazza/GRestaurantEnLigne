package Controller;

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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        page.setPageCount(1);
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
        stage.setScene(new Scene(root));
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



        for(int i=0;i<1;i++) {

              im = new ImageView(new Image("images/offres/offre" + (pageIndex * 9 + (i + 1)) + ".jpg"));
              im.setFitHeight(150);
              im.setFitWidth(150);

              gpanel.add(im, i, 0);
              gpanel.setHalignment(im, HPos.CENTER);

        }
       /* for(int i=0;i<3;i++) {

                im = new ImageView(new Image("images/categories/cat" + (pageIndex * 9 + (i+1)) + ".jpg"));
                im.setFitHeight(150);
                im.setFitWidth(150);

                gpanel.add(im,i,1); gpanel.setHalignment(im, HPos.CENTER);



        }*/
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0; j < 2; j++) {
                addPane(i, j,pageIndex);
            }}

        return gpanel;

    }

    private void addPane(int colIndex, int rowIndex ,int page) {
        Pane pane = new Pane();
        pane.setOnMouseClicked(e -> {
            Stage stage = new Stage();
            Parent root = null;
            try {
                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource("/Views/offreinfo.fxml"));
                root = loader.load();
                offreinfo offreController=loader.getController();
                offreController.setIdoffre( (page)*9+((rowIndex)*3+(colIndex+1)));
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
                    ((Node)e.getSource()).getScene().getWindow() );
            stage.show();
        });
        gpanel.add(pane, colIndex, rowIndex);
    }
    @FXML
    void GoToOffre() throws IOException {
        Stage primaryStage=new Stage();
        gpanel.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Offre.fxml"));
        primaryStage.setTitle("Creation Offre Page");

        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    @FXML
    void catGerer() throws IOException {
        Stage primaryStage=new Stage();
        gpanel.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Catgerer.fxml"));
        primaryStage.setTitle("Gestion catégories des ingrédients Page");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
