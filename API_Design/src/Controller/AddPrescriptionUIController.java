/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Doctor;
import Model.Patient;
import Model.Prescription;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nate
 */
public class AddPrescriptionUIController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ComboBox patientBox;
    @FXML
    private ComboBox doctorBox;
    @FXML
    private TextField drugBox;
    @FXML
    private TextField dosageBox;
    @FXML
    private DatePicker presDate;
    @FXML
    private Label errorLabel;
    @FXML
    private MenuButton appointmentsButton;
    private final ObservableList<String> docOptions = FXCollections.observableArrayList();
    private final ObservableList<String> patientOptions = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInDoctor() >= 0){
            for(int i = 0; i <PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().size(); i++){
            patientOptions.add(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i).getFirstName() + " " + PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i).getLastName());
        }
        
        docOptions.add(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInDoctor()).getFirstName() + " " + PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInDoctor()).getLastName());
        
        patientBox.getItems().addAll(patientOptions);
        doctorBox.getItems().addAll(docOptions);
        } else {
            errorLabel.setText("User is not authorized to add a prescription");
        }
    }
    
    @FXML
    public void addPrescription(){
        String dateVal = presDate.getValue().toString();
        String dosage = dosageBox.getText();
        String drugName = drugBox.getText();
        Doctor doc = PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInDoctor());
        String patient = patientBox.getValue().toString();
        Patient pat = null;
        
        for (int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().size(); i++) {
                if (patient.contains(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i).getFirstName()) || patient.contains(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i).getLastName())) {
                    pat = PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i);
                }
            }
        
        if(pat != null){
            pat.addPrescription(new Prescription(doc, drugName, dosage, dateVal));
            PersistentDataController.getPersistentDataController().writeData();
        } else {
            errorLabel.setText("Patient Not Found");
        }
    }

    @FXML
    public void viewAppointmentAction() {
        Stage stage = (Stage) appointmentsButton.getScene().getWindow();
        AppointmentController.getAppointmentController(stage).setUpAppointmentScene();
    }

    @FXML
    public void createAppointmentAction() {
        Stage stage = (Stage) appointmentsButton.getScene().getWindow();
        AppointmentController.getAppointmentController(stage).setUpAddAppointmentScene();
    }

    @FXML
    public void viewRecordAction() {
        Stage stage = (Stage) appointmentsButton.getScene().getWindow();
        PatientController.getPatientController(stage).setUpViewRecordsUI();
    }

    @FXML
    public void addRecordAction() {
        Stage stage = (Stage) appointmentsButton.getScene().getWindow();
        PatientController.getPatientController(stage).setUpAddRecordsUI();
    }

    @FXML
    public void viewBillAction() {
        Stage stage = (Stage) appointmentsButton.getScene().getWindow();
        BillController.getBillController(stage).setUpViewBillUI();
    }

    @FXML
    public void payBillAction() {
        Stage stage = (Stage) appointmentsButton.getScene().getWindow();
        BillController.getBillController(stage).setUpPayBillUI();
    }

    @FXML
    public void viewPrescriptionAction() {
        Stage stage = (Stage) appointmentsButton.getScene().getWindow();
        PrescriptionController.getPrescriptionController(stage).setUpViewPrescriptionScene();
    }

    @FXML
    public void addPrescriptionAction() {
        Stage stage = (Stage) appointmentsButton.getScene().getWindow();
        PrescriptionController.getPrescriptionController(stage).setUpAddPrescriptionScene();
    }

    @FXML
    public void logOutAction() {
        Stage stage = (Stage) appointmentsButton.getScene().getWindow();
        NavController.getNavController(stage).setUpLoginScene();
        
    }

}
