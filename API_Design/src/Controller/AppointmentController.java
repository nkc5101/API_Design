/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Appointment;
import View.*;

/**
 *
 * @author nate
 */
public class AppointmentController {
    private AppointmentUI userInterface;
    private static AppointmentController controller;
    /**
     * Default constructor for AppointmentController, sets up UI for viewing
     * @param appointments
     */
    private AppointmentController(){
        this.userInterface = new AppointmentUI();
        userInterface.viewAppointments(PatientController.getPatientController().getPatientList().get(0).getAppointments());
        controller = new AppointmentController();
    }
    
    public static AppointmentController getAppointmentController(){
        return controller;
    }
    /**
    *Adds appointments to list
    * @param app new appointment to be added
    */
    public void addAppointment(Appointment app){
         PatientController.getPatientController().getPatientList().get(0).getAppointments().add(app);
    }
    
    /**
     * Allows user to see appointment creator
     * 
     */
    public void viewAddAppointment(){
        userInterface.viewAppointmentCreator();
    }
}
