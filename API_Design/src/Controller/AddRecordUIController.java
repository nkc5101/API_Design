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
                        errorLabel.setText("Record added");
                    } else {
                        PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(patient).addRecord(new Record(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(patient).getAppointments().get(i), comments, false, priceVal));
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
        NavController.getNavController(stage).setUpLoginScene();
    }

}
