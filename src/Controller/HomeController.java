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
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomeController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

           ObservableList<Data> liste= FXCollections.observableArrayList(
                new Data("A",20),
                new Data("B",40),
                new Data("C",30),
                new Data("D",10));
        piechart.setData(liste);
    }
    @FXML
    private PieChart piechart;
    @FXML
    private Pane head;
    @FXML
    private MenuBar menu;

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
    void GoToOffre() throws IOException {
        Stage primaryStage=new Stage();
        piechart.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Offre.fxml"));
        primaryStage.setTitle("Creation Offre Page");

        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    @FXML
    void catGerer() throws IOException {
        Stage primaryStage=new Stage();
        piechart.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Catgerer.fxml"));
        primaryStage.setTitle("Gérer Catégories des Ingrédients  Page");

        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
