package Controller;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Callpages {
    public  void calllisteoffres(Pane pane) throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/listeoffres.fxml"));
        primaryStage.setTitle("Liste Offres");
        Scene x=new Scene(root);
        if(pane!=null) pane.getScene().getWindow().hide();

        x.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
        primaryStage.setScene(x);

        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public void calllogin() throws IOException {
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/LoginPage.fxml"));
        primaryStage.setTitle("Authentification");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public void calloffredetail(Event e, int id, Pane pane){
        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("/Views/offreinfo.fxml"));
            root = loader.load();
            offreinfo offreController = loader.getController();
            offreController.setIdoffre(id);
            offreController.getdata();
            pane.getScene().getWindow().hide();
            stage.setScene(new Scene(root));
            stage.setTitle("Détail OFFRE");
            stage.setResizable(false);
            stage.setWidth(800);
            stage.setHeight(600);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        stage.initOwner(
                ((Node) e.getSource()).getScene().getWindow());
        stage.show();
    }
    public void calladdoffre(Pane pane) throws IOException {
        Stage primaryStage=new Stage();
        pane.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Offre.fxml"));
        primaryStage.setTitle("Creation Offre Page");

        Scene x=new Scene(root);
        x.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
        primaryStage.setScene(x);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public void callcatliste(Pane pane) throws IOException {
        Stage primaryStage=new Stage();
        pane.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Catgerer.fxml"));
        primaryStage.setTitle("Gestion catégories des ingrédients Page");
        Scene x=new Scene(root);
        x.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
        primaryStage.setScene(x);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public void callcatdetail(Event e,int id,Pane pane){
        Stage stage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Views/Catinfo.fxml"));
            root = loader.load();
            CatInfoController cat = loader.getController();
             cat.setId_cat(id);
            cat.setTable();
            pane.getScene().getWindow().hide();
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
    }
    public void calladdcat(Pane pane) throws IOException {
        Stage primaryStage=new Stage();
        pane.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/addcat.fxml"));
        primaryStage.setTitle("Ajouter Catégorie Page");
        Scene x=new Scene(root);
        x.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
        primaryStage.setScene(x);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
