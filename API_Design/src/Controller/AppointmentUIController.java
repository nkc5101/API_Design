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
import Model.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nate
 */
public class AppointmentUIController implements Initializable {

    @FXML
    private ListView appointmentsList;
    @FXML
    private MenuButton appointmentsButton;
    private User user = PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInUser();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (user instanceof Patient) {
            ObservableList<Appointment> appointments = FXCollections.observableArrayList(((Patient) user).getAppointments());
            appointmentsList.setItems(appointments);
        } else if (user instanceof Doctor) {
            ObservableList<Appointment> appointments = FXCollections.observableArrayList(((Doctor) user).getAppointments());
            appointmentsList.setItems(appointments);
        } else if (user instanceof Nurse) {
            ObservableList<Appointment> appointments = FXCollections.observableArrayList(((Nurse) user).getAppointments());
            appointmentsList.setItems(appointments);
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
