/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CreditCard;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class PayBillUIController implements Initializable {

    @FXML
    private TextField amountField;
    @FXML
    private TextField creditCardField;
    @FXML
    private TextField ccvField;
    @FXML
    private TextField nameField;
    @FXML
    private MenuButton appointmentsButton;
    @FXML
    private Label errorLabel;
    @FXML
    private MenuButton notificationButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient()).getPatientRecords().size() <= 0) {
            errorLabel.setText("No Bills are due");
        } else {
            amountField.setText(Integer.toString(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient()).getPatientRecords().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getSelectedRecord()).getPrice()));
        }
        
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
    public void payBill() {
        String creditCard = creditCardField.getText();
        String ccv = ccvField.getText();
        String name = nameField.getText();

        for (int i = 0; i < PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient()).getPatientRecords().size(); i++) {
            if (PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient()).getPatientRecords().get(i).getComments().equals(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient()).getPatientRecords().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getSelectedRecord()).getComments())) {
                PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient()).getPatientRecords().get(i).setPrice(0);
                PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient()).addCreditCard(new CreditCard(creditCard, ccv, name));
                PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient()).getNotifications().add("Paid bill from " + PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(PersistentDataController.getPersistentDataController().getPersistentDataCollection().getLoggedInPatient()).getPatientRecords().get(i).getAppointment().getDate());
                PersistentDataController.getPersistentDataController().writeData();
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
