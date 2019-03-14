/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nate
 */
public class LoginUIController implements Initializable {

    @FXML
    private Button loginButton;
    @FXML Stage stage;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void loginAction(){
        stage = (Stage) loginButton.getScene().getWindow();
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        if(username.equals("username") && password.equals("password")){
            NavController.getNavController(stage).setUpNavScene();
        }
    }
}
