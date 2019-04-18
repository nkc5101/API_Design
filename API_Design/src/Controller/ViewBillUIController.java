/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Appointment;
import Model.Record;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nate
 */
public class ViewBillUIController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Record> billTable;
    @FXML
    private TableColumn<Record, String> billDate;
    @FXML
    private TableColumn<Record, Boolean> billCompleted;
    @FXML
    private TableColumn<Record, String> billBalance;
    @FXML
    private MenuButton appointmentsButton;
    @FXML
    private Label errorLabel;
    @FXML
    private MenuButton notificationButton;
    @FXML
    private ComboBox patientBox;
    private final ObservableList<String> patientOptions = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInInsure() >= 0) {
            for (int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().size(); i++) {
                patientOptions.add(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i).getFirstName() + " " + PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i).getLastName());
                patientBox.getItems().addAll(patientOptions);
            }
        } else if (PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient() >= 0) {
            ObservableList<Record> records = FXCollections.observableArrayList(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient()).getPatientRecords());
            billDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAppointment().getDate()));
            billCompleted.setCellValueFactory(new PropertyValueFactory<>("isCompleted"));
            billBalance.setCellValueFactory(new PropertyValueFactory<>("price"));
            billTable.setItems(records);
        } else {
            errorLabel.setText("User is not authorized to view Bills");

        }

        if (PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInDoctor() >= 0) {
            for (int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInDoctor()).getNotifications().size(); i++) {
                MenuItem temp = new MenuItem(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getDoctorList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInDoctor()).getNotifications().get(i));
                notificationButton.getItems().add(temp);
            }
        } else if (PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInInsure() >= 0) {
            for (int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getInsuranceList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInInsure()).getNotifications().size(); i++) {
                MenuItem temp = new MenuItem(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getInsuranceList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInInsure()).getNotifications().get(i));
                notificationButton.getItems().add(temp);
            }
        } else if (PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient() >= 0) {
            for (int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient()).getNotifications().size(); i++) {
                MenuItem temp = new MenuItem(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient()).getNotifications().get(i));
                notificationButton.getItems().add(temp);
            }
        } else if (PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPharma() >= 0) {
            for (int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPharmaList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPharma()).getNotifications().size(); i++) {
                MenuItem temp = new MenuItem(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPharmaList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPharma()).getNotifications().get(i));
                notificationButton.getItems().add(temp);
            }
        } else {
            for (int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getNurseList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInNurse()).getNotifications().size(); i++) {
                MenuItem temp = new MenuItem(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getNurseList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInNurse()).getNotifications().get(i));
                notificationButton.getItems().add(temp);
            }
        }
    }

    @FXML
    public void setBill() {
        String patient = patientBox.getValue().toString();
        for (int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().size(); i++) {
            if (patient.contains(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i).getFirstName()) || patient.contains(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i).getLastName())) {
                ObservableList<Record> records = FXCollections.observableArrayList(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(i).getPatientRecords());
                billDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAppointment().getDate()));
                billCompleted.setCellValueFactory(new PropertyValueFactory<>("isCompleted"));
                billBalance.setCellValueFactory(new PropertyValueFactory<>("price"));
                billTable.setItems(records);
            }
        }
    }

    @FXML
    public void viewBill() {
        Record tempRecord = billTable.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Bill Info");
        alert.setHeaderText(tempRecord.getAppointment().getDate());
        alert.setContentText("Time: " + tempRecord.getAppointment().getTime() + "\nHospital: " + tempRecord.getAppointment().getHospital()
                + "\nRoom Number: " + tempRecord.getAppointment().getRoom() + "\nDoctor: " + tempRecord.getAppointment().getDoctorFirst() + " " + tempRecord.getAppointment().getDoctorLast()
                + "\nAttended: " + tempRecord.isCompleted() + "\nBalance: " + tempRecord.getPrice() + "\nAdditional Comments: " + tempRecord.getComments());
        alert.showAndWait();
    }

    @FXML
    public void payBill() {
        Record tempRecord = billTable.getSelectionModel().getSelectedItem();
        PersistentDataController.getPersistentDataController().getPersistentDataCollection().setSelectedRecord(tempRecord);
        Stage stage = (Stage) appointmentsButton.getScene().getWindow();
        BillController.getBillController(stage).setUpPayBillUI();
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
