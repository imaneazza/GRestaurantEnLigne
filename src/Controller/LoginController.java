package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField txtUsername;

    @FXML
    private Label lblStatus;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void LoginAction(ActionEvent event) throws IOException {
            if(txtUsername.getText().equals("imane") && txtPassword.getText().equals("pass")){
                lblStatus.setText("Status : Connected");
                ((Node)event.getSource()).getScene().getWindow().hide();
                Stage primaryStage=new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/Views/HomePage.fxml"));
                primaryStage.setTitle("Home Page");

                primaryStage.setScene(new Scene(root));
                primaryStage.setResizable(false);
                primaryStage.show();


            }
            else {
                lblStatus.setText("Status : Disconnected");
            }
    }

}
