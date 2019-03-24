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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
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
    private TextField doctorField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField timeField;
    @FXML
    private TextField roomField;
    @FXML
    private TextField hospitalField;
    @FXML
    private MenuButton appointmentsButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void addAppointmentAction() {
        String patient = patientField.getText();
        String doctor = doctorField.getText();
        String time = timeField.getText();
        String date = dateField.getText();
        String room = roomField.getText();
        String hospital = hospitalField.getText();
       if(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInDoctor() != null){
           Doctor doc = PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInDoctor();
           Patient pat = null;
           for (int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().size(); i++) {
                if (patient.contains(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i).getFirstName()) || patient.contains(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i).getLastName())) {
                    pat = PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i);
                }
            }

            if (pat != null) {
                doc.addAppointment(new Appointment(pat, doc, date, time, room, hospital));
                pat.addAppointment(new Appointment(pat, doc, date, time, room, hospital));
                errorLabel.setText("Appointment successfully added");
            } else {
                errorLabel.setText("Patient does not exist");
            }
       } else if (PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient() != null){
           Patient pat = PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient();
           Doctor doc = null;
           
           for (int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().size(); i++) {
                if (doctor.contains(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().get(i).getLastName()) || doctor.contains(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().get(i).getFirstName())) {
                    doc = PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().get(i);
                }
            }

            if (doc != null) {
                doc.addAppointment(new Appointment(pat, doc, date, time, room, hospital));
                pat.addAppointment(new Appointment(pat, doc, date, time, room, hospital));
                errorLabel.setText("Appointment successfully added");
            } else {
                errorLabel.setText("Doctor does not exist");
            }
       } else if (PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInNurse() != null){
           Nurse nur = PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInNurse();
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
                doc.addAppointment(new Appointment(pat, doc, date, time, room, hospital));
                pat.addAppointment(new Appointment(pat, doc, date, time, room, hospital));
                nur.addAppointment(new Appointment(pat, doc, date, time, room, hospital));
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
        NavController.getNavController(stage).setUpLoginScene();
    }

}
