/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Record;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nate
 */
public class AddRecordUIController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private MenuButton appointmentsButton;
    @FXML
    private ComboBox patientBox;
    @FXML
    private ComboBox appointmentBox;
    @FXML
    private ComboBox attendanceBox;
    @FXML
    private TextField commentsField;
    @FXML
    private TextField priceField;
    @FXML
    private MenuButton notificationButton;
    @FXML
    private Label errorLabel;
    private int patient;
    private int appointment;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInDoctor() >= 0 || PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInNurse() >= 0) {
            ArrayList<String> patients = new ArrayList<>();
            for (int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().size(); i++) {
                patients.add(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i).getFirstName() + " " + PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i).getLastName());
            }
            patientBox.getItems().addAll(patients);
        } else {
            errorLabel.setText("User is not allowed to add records");
        }
        ArrayList<String> attendance = new ArrayList<>();
        attendance.add("Yes");
        attendance.add("No");
        attendanceBox.getItems().addAll(attendance);
        
        if(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInDoctor() >= 0){
                    for(int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInDoctor()).getNotifications().size(); i++){
            MenuItem temp = new MenuItem(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInDoctor()).getNotifications().get(i));
            notificationButton.getItems().add(temp);
                    }
    }else if(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInInsure() >= 0){
            for(int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getInsuranceList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInInsure()).getNotifications().size(); i++){
            MenuItem temp = new MenuItem(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getInsuranceList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInInsure()).getNotifications().get(i));
            notificationButton.getItems().add(temp);
        }
        }else if(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient() >= 0){
            for(int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient()).getNotifications().size(); i++){
            MenuItem temp = new MenuItem(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient()).getNotifications().get(i));
            notificationButton.getItems().add(temp);
        } 
        } else if(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPharma() >= 0){
            for(int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPharmaList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPharma()).getNotifications().size(); i++){
            MenuItem temp = new MenuItem(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPharmaList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPharma()).getNotifications().get(i));
            notificationButton.getItems().add(temp);
        } 
        } else {
            for(int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getNurseList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInNurse()).getNotifications().size(); i++){
            MenuItem temp = new MenuItem(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getNurseList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInNurse()).getNotifications().get(i));
            notificationButton.getItems().add(temp);
        }
    }
    }

    @FXML
    public void addRecord() {
        String comments = commentsField.getText();
        String price = priceField.getText();
        String attendance = attendanceBox.getValue().toString();
        String app = appointmentBox.getValue().toString();
        for (int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(patient).getAppointments().size(); i++) {
            if (app.contains(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(patient).getAppointments().get(i).getDate())) {
                int priceVal = Integer.parseInt(price);
                if (priceVal == 0) {
                    errorLabel.setText("Price is not an integer");

                } else {
                    if (attendance.equals("Yes")) {
                        PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(patient).addRecord(new Record(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(patient).getAppointments().get(i), comments, true, priceVal));
                        PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(patient).getNotifications().add("Record added for " + PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(patient).getAppointments().get(i).getDate());
                        PersistentDataController.getPersistentDataController().writeData();
                        errorLabel.setText("Record added");
                    } else {
                        PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(patient).addRecord(new Record(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(patient).getAppointments().get(i), comments, false, priceVal));
                        PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(patient).getNotifications().add("Record added for " + PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(patient).getAppointments().get(i).getDate());
                        PersistentDataController.getPersistentDataController().writeData();
                        errorLabel.setText("Record added");
                    }
                }
            }
        }

    }

    @FXML
    public void addAppointments() {
        ArrayList<String> appointments = new ArrayList<>();
        String pat = patientBox.getValue().toString();
        for (int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().size(); i++) {
            if (PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i).getFirstName().contains(pat)) {
                patient = i;
            }
        }
        for (int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(patient).getAppointments().size(); i++) {
            appointments.add(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(patient).getAppointments().get(i).getDate());
        }
        appointmentBox.getItems().addAll(appointments);
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
        PersistentDataController.getPersistentDataController().getPersistentDataCollection().logOutAccounts();
        NavController.getNavController(stage).setUpLoginScene();
    }

}
