package Controller;

import Classes.Detail;
import Classes.Form;
import Classes.Offer;
import DAO.DAOOffer;
import Metier.MetierDetail;
import Metier.MetierIngredient;
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

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
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
    private TableColumn<DetailOffre, Double> max;

    @FXML
    private TableColumn<DetailOffre, String> libelle;

    @FXML
    private TableColumn<DetailOffre, Boolean> obligatoire;
    @FXML
    private TableColumn<DetailOffre, Double> min;



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

    private static ObservableList<DetailOffre> ingredientsliste = FXCollections.observableArrayList();

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

        new Callpages().calllisteoffres(pane);
    }





    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
    public void getdata(){
        offre=metierOffer.find(idoffre);
    txtlibelle.setText(offre.getName());
    ObservableList<String> options =
            FXCollections.observableArrayList();

    for(Form f:offre.getForms())
        options.add(f.getName());

    formes.setItems(options);
    formes.setValue("Select forme ");
    formes.valueProperty().addListener(new ChangeListener<String>() {
        @Override public void changed(ObservableValue ov, String t, String t1) {
            showtable();
        }
    });
    if(offre.getImageSource().length()==0)img.setImage(new Image("images/offres/default.png"));
    else img.setImage(new Image(offre.getImageSource()));

}

    @FXML
    void GoToOffre() throws IOException {
       new Callpages().calladdoffre(pane);
    }
    @FXML
    void catGerer() throws IOException {

    new Callpages().callcatliste(pane);
    }

    @FXML
    void deleteoffre(ActionEvent event) throws IOException {

        if(offre.getImageSource().length()>0){
            try
            {
                Files.deleteIfExists(Paths.get("C:/Users/Imane azza/Desktop/GRestaurantEnLigne/GRestaurantEnLigne/src/"+offre.getImageSource()));
            }
            catch(NoSuchFileException e)
            {
                System.out.println("No such file/directory exists");
            }
            catch(DirectoryNotEmptyException e)
            {
                System.out.println("Directory is not empty.");
            }
            catch(IOException e)
            {
                System.out.println("Invalid permissions.");
            }

            System.out.println("Deletion successful.");
        }
        metierOffer.delete(offre.getId());
        new Callpages().calllisteoffres(pane);
    }

    void showtable() {

        System.out.println(formes.getSelectionModel().getSelectedIndex());
        ingredientsliste.clear();
        MetierDetail det=new MetierDetail();
       ArrayList<Detail> details=det.findByForm(offre.getForms().get(formes.getSelectionModel().getSelectedIndex()));
for(Detail d:details){
    ingredientsliste.add(new DetailOffre(formes.getSelectionModel().getSelectedIndex(),
            d.getIngredient().getName(),d.getMax(),d.getMin(),d.getObligatory()));
}

        libelle.setCellValueFactory(new PropertyValueFactory<DetailOffre,String>("libelle"));
        max.setCellValueFactory(new PropertyValueFactory<DetailOffre,Double>("quantitemax"));
        min.setCellValueFactory(new PropertyValueFactory<DetailOffre,Double>("quantitemin"));
        obligatoire.setCellValueFactory(new PropertyValueFactory<DetailOffre,Boolean>("obligatory"));

        table.setItems(ingredientsliste);
        table.refresh();



    }


}
