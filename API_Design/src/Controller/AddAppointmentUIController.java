/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Appointment;
import Model.Doctor;
import Model.Nurse;
import Model.Patient;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nate
 */
public class AddAppointmentUIController implements Initializable {

    @FXML
    private Label errorLabel;
    @FXML
    private TextField patientField;
    @FXML
    private ComboBox doctorBox;
    @FXML
    private DatePicker date;
    @FXML
    private ComboBox timeBox;
    @FXML
    private ComboBox roomBox;
    @FXML
    private ComboBox hospitalBox;
    @FXML
    private MenuButton appointmentsButton;
    @FXML
    private MenuButton notificationButton;
    private final ObservableList<String> docOptions = FXCollections.observableArrayList();
    private final ObservableList<String> timeOptions = FXCollections.observableArrayList("12:00", "1:00", "2:00");
    private final ObservableList<String> roomOptions = FXCollections.observableArrayList("111", "112", "113");
    private final ObservableList<String> hospitalOptions = FXCollections.observableArrayList("Hershey Medical Center", "Geisinger", "Mount Nittany Medical Center");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().size(); i++) {
            docOptions.add(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().get(i).getFirstName() + " " + PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().get(i).getLastName());
        }

        doctorBox.getItems().addAll(docOptions);
        timeBox.getItems().addAll(timeOptions);
        roomBox.getItems().addAll(roomOptions);
        hospitalBox.getItems().addAll(hospitalOptions);
        
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
    public void addAppointmentAction() {
        String patient = patientField.getText();
        String doctor = doctorBox.getValue().toString();
        String time = timeBox.getValue().toString();
        String dateVal = date.getValue().toString();
        String room = roomBox.getValue().toString();
        String hospital = hospitalBox.getValue().toString();
        if (PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInDoctor() >= 0) {
            Doctor doc = PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInDoctor());
            Patient pat = null;
            for (int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().size(); i++) {
                if (patient.contains(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i).getFirstName()) || patient.contains(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i).getLastName())) {
                    pat = PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i);
                }
            }

            if (pat != null) {
                doc.addAppointment(new Appointment(pat, doc, dateVal, time, room, hospital));
                pat.addAppointment(new Appointment(pat, doc, dateVal, time, room, hospital));
                doc.getNotifications().add("Appointment for " + dateVal + " at " + time);
                pat.getNotifications().add("Appointment for " + dateVal + " at " + time);
                PersistentDataController.getPersistentDataController().writeData();
                errorLabel.setText("Appointment successfully added");

            } else {
                errorLabel.setText("Patient does not exist");
            }
        } else if (PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient() >= 0) {
            Patient pat = PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient());
            Doctor doc = null;

            for (int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().size(); i++) {
                if (doctor.contains(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().get(i).getLastName()) || doctor.contains(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().get(i).getFirstName())) {
                    doc = PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().get(i);
                }
            }

            if (doc != null) {
                doc.addAppointment(new Appointment(pat, doc, dateVal, time, room, hospital));
                pat.addAppointment(new Appointment(pat, doc, dateVal, time, room, hospital));
                doc.getNotifications().add("Appointment for " + dateVal + " at " + time);
                pat.getNotifications().add("Appointment for " + dateVal + " at " + time);
                PersistentDataController.getPersistentDataController().writeData();
                errorLabel.setText("Appointment successfully added");

            } else {
                errorLabel.setText("Doctor does not exist");
            }
        } else if (PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInNurse() >= 0) {
            Nurse nur = PersistentDataController.getPersistentDataController().getPersistentDataCollection().getNurseList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInNurse());
            Patient pat = null;
            Doctor doc = null;

            for (int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().size(); i++) {
                if (patient.contains(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i).getFirstName()) || patient.contains(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i).getLastName())) {
                    pat = PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i);
                }
            }

            for (int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().size(); i++) {
                if (doctor.contains(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().get(i).getLastName()) || doctor.contains(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().get(i).getFirstName())) {
                    doc = PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().get(i);
                }
            }

            if (pat != null && doc != null) {
                doc.addAppointment(new Appointment(pat, doc, dateVal, time, room, hospital));
                pat.addAppointment(new Appointment(pat, doc, dateVal, time, room, hospital));
                nur.addAppointment(new Appointment(pat, doc, dateVal, time, room, hospital));
                doc.getNotifications().add("Appointment for " + dateVal + " at " + time);
                pat.getNotifications().add("Appointment for " + dateVal + " at " + time);
                PersistentDataController.getPersistentDataController().writeData();
                errorLabel.setText("Appointment successfully added");
            } else {
                errorLabel.setText("Patient does not exist");
            }
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
        PersistentDataController.getPersistentDataController().getPersistentDataCollection().logOutAccounts();
        NavController.getNavController(stage).setUpLoginScene();
    }

}
