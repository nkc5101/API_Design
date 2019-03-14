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
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nate
 */
public class AddAppointmentUIController implements Initializable {

    @FXML
    private MenuButton appointmentsButton;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void viewAppointmentAction(){
        Stage stage = (Stage) appointmentsButton.getScene().getWindow();
        AppointmentController.getAppointmentController(stage).setUpAppointmentScene();
    }
    
    @FXML
    public void createAppointmentAction(){
        Stage stage = (Stage) appointmentsButton.getScene().getWindow();
        AppointmentController.getAppointmentController(stage).setUpAddAppointmentScene();
    }
    
    @FXML
    public void viewRecordAction(){
         Stage stage = (Stage) appointmentsButton.getScene().getWindow();
         PatientController.getPatientController(stage).setUpViewRecordsUI();
    }
    
    @FXML
    public void addRecordAction(){
        Stage stage = (Stage) appointmentsButton.getScene().getWindow();
         PatientController.getPatientController(stage).setUpAddRecordsUI();
    }
    
    @FXML
    public void viewBillAction(){
        Stage stage = (Stage) appointmentsButton.getScene().getWindow();
        BillController.getBillController(stage).setUpViewBillUI();
    }
    
    @FXML
    public void payBillAction(){
        Stage stage = (Stage) appointmentsButton.getScene().getWindow();
        BillController.getBillController(stage).setUpPayBillUI();
    }
    
    @FXML
    public void viewPrescriptionAction(){
        Stage stage = (Stage) appointmentsButton.getScene().getWindow();
        PrescriptionController.getPrescriptionController(stage).setUpViewPrescriptionScene();
    }
    
    @FXML
    public void addPrescriptionAction(){
        Stage stage = (Stage) appointmentsButton.getScene().getWindow();
        PrescriptionController.getPrescriptionController(stage).setUpAddPrescriptionScene();
    }
    
    @FXML
    public void logOutAction(){
        Stage stage = (Stage) appointmentsButton.getScene().getWindow();
        NavController.getNavController(stage).setUpLoginScene();
    }
    
}
