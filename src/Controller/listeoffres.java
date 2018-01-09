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
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
        System.out.println(liste.size());
       page.setPageFactory((Integer pageIndex) -> createPage(pageIndex));

    }

    @FXML
    void gotoliste(ActionEvent event) throws IOException {
       new Callpages().calllisteoffres(gpanel);
    }
    public GridPane createPage(int pageIndex) {
        gpanel.setAlignment(Pos.TOP_CENTER);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(33);
        RowConstraints constraint=new RowConstraints();
        constraint.setPercentHeight(50);
        gpanel.getRowConstraints().clear();
        gpanel.getColumnConstraints().clear();
        gpanel.getColumnConstraints().addAll(column1,column1,column1);
        gpanel.getRowConstraints().addAll(constraint,constraint);
        ImageView im;
        for(int i=0;i<6;i++) {
            int a=(pageIndex * 6) + i;
            if (liste.size()>a) {
                    Offer x = liste.get(a);
                Pane pane=new Pane();

                     if(x.getImageSource().length()==0)  im = new ImageView(new Image("images/offres/default.png"));

                         else im = new ImageView(new Image(x.getImageSource()));
                im.setFitHeight(150);
                im.setFitWidth(150);
                im.setX(40);
                pane.getChildren().add(0,im);
                Label label=new Label("Offre : "+x.getName());
                label.setPrefWidth(gpanel.getPrefWidth()/3);
                label.setFont( Font.font("Cambria", FontWeight.BOLD,17));
                label.setAlignment(Pos.CENTER);
                label.setTranslateY(150);
                label.setTranslateX(20);
                pane.getChildren().add(1,label);

                gpanel.add(pane, i%3, (i <3) ? 0 : 1);
                gpanel.setHalignment(pane, HPos.CENTER);

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
        int a=(page * 6) + (rowIndex*3)+colIndex;
        System.out.println(a);
        if (liste.size()>a) {
            pane.setOnMouseClicked(e -> {
                new Callpages().calloffredetail(e,liste.get(a).getId(),gpanel);

            });
        }
        gpanel.add(pane, colIndex, rowIndex);
    }
    @FXML
    void GoToOffre() throws IOException {
       new Callpages().calladdoffre(gpanel);
    }
    @FXML
    void catGerer() throws IOException {
        new Callpages().callcatliste(gpanel);
    }

}
