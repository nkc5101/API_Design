/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Appointment;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author nate
 */
public class AppointmentController {
     @FXML
    private Stage stage;
    private static AppointmentController controller;
    /**
     * Default constructor for AppointmentController, sets up UI for viewing
     * @param appointments
     */

    private AppointmentController(Stage stage){
        this.stage = stage;
        this.setUpAppointmentScene();
        
    }
    
    public static AppointmentController getAppointmentController(Stage stage){
        if(controller == null){
           controller = new AppointmentController(stage);
           
        }
        return controller;
    }
    /**
    *Adds appointments to list
    * @param app new appointment to be added
    */
    public void addAppointment(Appointment app){
        PersistentDataController.getPersistentDataController().getPersistentDataCollection().getPatientList().get(0).addAppointment(app);
    }
    
    /**
     * Allows user to see appointment creator
     * 
     */
    public void setUpAddAppointmentScene(){
        Parent root;
        Scene scene;
        
        try{ root = FXMLLoader.load(getClass().getResource("/View/AddAppointmentUI.fxml"));
            scene = new Scene(root, 600, 600);
            stage.setTitle("Add appointment");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
}
}

    public void setUpAppointmentScene() {
        Parent root;
        Scene scene;
        
        try{ 
            root = FXMLLoader.load(getClass().getResource("/View/AppointmentUI.fxml"));
            scene = new Scene(root, 600, 600);
            stage.setTitle("View Appointment");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
}
    }
}
