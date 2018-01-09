package Controller;

import Classes.Role;
import Classes.Compte;
import DAO.DAORole;
import DAO.DAOCompte;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Optional;

public class LoginController {
    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void LoginAction(ActionEvent event) throws IOException {
        DAOCompte comptedao=new DAOCompte();
        Compte compte =comptedao.connect(txtUsername.getText(), txtPassword.getText());
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
                    ((Node)event.getSource()).getScene().getWindow().hide();
                    new Callpages().calllisteoffres(null);
                }


        }


    }

}
