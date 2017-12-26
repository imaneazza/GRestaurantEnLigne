package Controller;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class addcatController implements Initializable {
    @FXML
    private Pane pan1;
    @FXML
    private Label labelx;
    @FXML
    private Pane pan11;

    @FXML
    private MenuBar menu;
    @FXML
     private Button openButton;
    @FXML
    private Button conf;
    @FXML
    private TextField txtname;
private File file;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final FileChooser fileChooser = new FileChooser();
            //getlastID;
        openButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        setExtFilters(fileChooser);
                         file = fileChooser.showOpenDialog(pan1.getScene().getWindow());
                        if (file != null) {
                            labelx.setText(file.toURI().toString());


                        }
                    }
                });

    }
    private void setExtFilters(FileChooser chooser){
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.jpg"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg")
        );
    }
    private File openNewImageWindow(int id){
        File outputFile = null;

        Image image = new Image(file.toURI().toString());


                if (file != null) {


             outputFile = new File("C:/Users/Imane azza/IdeaProjects/GRestaurantEnLigne/src/images/categories/cat"+id+".jpg");



                        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
                        try {
                            ImageIO.write(bImage, "jpg",outputFile);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                }
                return outputFile;

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
    void catGerer() throws IOException {
        Stage primaryStage=new Stage();
        pan1.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Catgerer.fxml"));
        primaryStage.setTitle("Gestion catégories des ingrédients Page");

        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    @FXML
    void annuler() throws IOException {
      catGerer();
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
    void AddCat(ActionEvent event) {
        File x=openNewImageWindow(00);
        //add Cat
        System.out.println(x.toURI().toString());
        String[] liste=x.toURI().toString().split("/");
        String a=liste[liste.length-2]+"/"+liste[liste.length-1];
        System.out.println(a);
    }


}
