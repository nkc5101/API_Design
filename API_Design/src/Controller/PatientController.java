/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Patient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author nate
 */
public class PatientController {
    @FXML
    private Stage stage;
     private static PatientController controller;
    /**
     * Default Constructor for PatientController 
     */
    private PatientController(Stage stage){
        this.stage = stage;
    }
    
    public static PatientController getPatientController(Stage stage){
        if(controller == null){
            controller = new PatientController(stage);
            return controller;
        } else {
            return controller;
        }
    }
    /**
     * Adds patient to list of patients
     * @param patient patient who is being added
     */
    public void addPatient(Patient patient){
        PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().add(patient);
    }
    /**
     * Remove patient from list of patients
     * @param index index of patient to be removed
     */
    public void removePatient(int index){
        PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().remove(index);
    }
    /**
     * Returns the list of patients
     * @return the list of patients
     */
    
    public void setUpViewRecordsUI(){
        Parent root;
        Scene scene;

        try {
            root = FXMLLoader.load(getClass().getResource("/View/RecordsUI.fxml"));
            scene = new Scene(root, 600, 600);
            stage.setTitle("Records");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
}
    }
    public void setUpAddRecordsUI(){
        Parent root;
        Scene scene;

        try {
            root = FXMLLoader.load(getClass().getResource("/View/AddRecordUI.fxml"));
            scene = new Scene(root, 600, 600);
            stage.setTitle("View Record");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
}
}
}
