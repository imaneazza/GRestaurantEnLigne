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
import javafx.scene.text.FontWeight;
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
         ImageView im;
        int a;
        for(int i=0;i<6;i++) {
            Pane pane=new Pane();
            a=(pageIndex * 6) + i;
            if (liste.size() > a) {
                Category category = liste.get(a);
                if(category.getImageSource().length()==0)
                    im = new ImageView(new Image("images/categories/no.jpg"));
                else im = new ImageView(new Image(category.getImageSource()));
                im.setFitHeight(130);
                im.setFitWidth(130);
                im.setX(40);

                pane.getChildren().add(0,im);
                Label label=new Label("Catégorie : "+category.getName());
                label.setPrefWidth(gpanel.getPrefWidth()/3);
                label.setFont( Font.font("Cambria", FontWeight.BOLD,17));
                label.setAlignment(Pos.CENTER);
                label.setTranslateY(150);
                label.setTranslateX(0);
                pane.getChildren().add(1,label);

                gpanel.add(pane, i%3, (i <3) ? 0 : 1);
                gpanel.setHalignment(pane, HPos.CENTER);

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
             a=(page * 6) + (rowIndex*3)+colIndex;
            if (liste.size() > a) {
                pane.setOnMouseClicked(e -> {
            new Callpages().callcatdetail(e,  liste.get(a).getId(),pane);
                });
            }
        gpanel.add(pane, colIndex, rowIndex);
    }
    @FXML
    void GoToOffre() throws IOException {
        new Callpages().calllisteoffres(gpanel);
    }
    @FXML
    void catGerer() throws IOException {

        new Callpages().callcatliste(gpanel);
    }
    @FXML
    void addfct() throws IOException {
        new Callpages().calladdcat(gpanel);
         }
}
