package Controller;

import Classes.Role;
import Classes.Compte;
import DAO.DAORole;
import DAO.DAOCompte;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class LoginController {
    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void LoginAction(ActionEvent event) throws IOException {
        //recherche login
        DAOCompte userdao=new DAOCompte();
        Compte compte =userdao.connect(txtUsername.getText(), txtPassword.getText());
        if(compte ==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur d'Authentification");
            alert.setHeaderText(null);
            alert.setContentText("Login ou Mot de Passe Incorrecte");
            Optional<ButtonType> result =alert.showAndWait();
            if (result.isPresent()){
                txtUsername.clear();
                txtPassword.clear();
            }
        }
        else {
            System.out.println(compte.getRoleId());
            DAORole roles=new DAORole();
            Role role=roles.find(compte.getRoleId());
            if(role!=null){
                if(role.getName().equalsIgnoreCase("Chef Cuisinier")){
                    ((Node)event.getSource()).getScene().getWindow().hide();
                    Stage primaryStage=new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/Views/listeoffres.fxml"));

                    primaryStage.setTitle("Liste Offres");
                    Scene x=new Scene(root);
                    x.getStylesheets().add(getClass().getResource("/Style/Style.css").toExternalForm());
                    primaryStage.setScene(x);

                    primaryStage.setResizable(false);
                    primaryStage.show();
                }
            }

        }


    }

}
