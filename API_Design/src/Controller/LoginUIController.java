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
import java.util.ArrayList;
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
        ArrayList<Patient> patientList = PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList();
        ArrayList<Doctor> doctorList = PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList();
        ArrayList<InsuranceCompany> insuranceList = PersistentDataController.getPersistentDataController().getPersistentDataCollection().getInsuranceList();
        ArrayList<Pharmacist> pharmaList = PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPharmaList();
        
        
        for(int i = 0; i < patientList.size(); i++){
            if(username.equals(patientList.get(i).getUsername()) && password.equals(patientList.get(i).getPassword())){
                PersistentDataController.getPersistentDataController().getPersistentDataCollection().setLoggedInUser(patientList.get(i));
                NavController.getNavController(stage).setUpNavScene();
            }
        }
        
        for(int i =0; i < doctorList.size(); i++){
            if(username.equals(doctorList.get(i).getUsername()) && password.equals(doctorList.get(i).getPassword())){
                PersistentDataController.getPersistentDataController().getPersistentDataCollection().setLoggedInUser(doctorList.get(i));
                NavController.getNavController(stage).setUpNavScene();
            }
        }
        
        for(int i =0; i < insuranceList.size(); i++){
            if(username.equals(insuranceList.get(i).getUsername()) && password.equals(insuranceList.get(i).getPassword())){
                PersistentDataController.getPersistentDataController().getPersistentDataCollection().setLoggedInUser(insuranceList.get(i));
                NavController.getNavController(stage).setUpNavScene();
            }
        }
        
        for(int i =0; i < pharmaList.size(); i++){
            if(username.equals(pharmaList.get(i).getUsername()) && password.equals(pharmaList.get(i).getPassword())){
                PersistentDataController.getPersistentDataController().getPersistentDataCollection().setLoggedInUser(pharmaList.get(i));
                NavController.getNavController(stage).setUpNavScene();
            }
        }
    }
    
    @FXML 
    public void signUpAction(){
        stage = (Stage) loginButton.getScene().getWindow();
        NavController.getNavController(stage).setUpSignUpScene();
    }
}
