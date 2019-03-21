/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Doctor;
import Model.InsuranceCompany;
import Model.Patient;
import Model.Pharmacist;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nate
 */
public class SignUpUIController implements Initializable {
    @FXML
    private Label errorLabel;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private ComboBox accountType;
    private ObservableList<String> options = FXCollections.observableArrayList("Patient", "Doctor", "Insurance Company", "Pharmacist");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        accountType.getItems().addAll(options);
    }  
    
    @FXML
    public void registerAction(){
        Stage stage = (Stage) accountType.getScene().getWindow();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();

        
        
        if((username.equals("")) || (password.equals("")) || (firstName.equals("")) || (lastName.equals("")) || (email.equals("")) || (accountType.getValue() == null)){
            errorLabel.setText("Please fill in all the fields");
        } else{
            String typeOfAccount = accountType.getValue().toString();
            if(typeOfAccount.equals("Patient")){
                PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().add(new Patient(username, password, email, firstName, lastName));
            } else if(typeOfAccount.equals("Doctor")){
                System.out.println("doctor");
                PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().add(new Doctor(username, password, email, firstName, lastName, "Hershey Medical Center", "surgeon"));
            } else if(typeOfAccount.equals("Insurance Company")){
                PersistentDataController.getPersistentDataController().getPersistentDataCollection().getInsuranceList().add(new InsuranceCompany(username, password, email, "AlphaCare", "test"));
            } else if(typeOfAccount.equals("Pharmacist")){
                PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPharmaList().add(new Pharmacist(username, password, email, firstName, lastName, "Bayer", "123 E Market S"));
            }
            
            NavController.getNavController(stage).setUpLoginScene();
        }
    }
    
}
