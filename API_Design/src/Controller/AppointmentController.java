/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Appointment;
import View.*;
import java.util.ArrayList;

/**
 *
 * @author nate
 */
public class AppointmentController {
    private ArrayList<Appointment> appointments;
    private AppointmentUI userInterface;
    /**
     * Default constructor for AppointmentController, sets up UI for viewing
     */
    public AppointmentController(){
        this.appointments = new ArrayList<>();
        this.userInterface = new AppointmentUI();
        userInterface.viewAppointments();
    }
    /**
    *Adds appointments to list
    * @param app new appointment to be added
    */
    public void addAppointment(Appointment app){
         appointments.add(app);
    }
    
    /**
     * Allows user to see appointment creator
     * 
     */
    public void viewAddAppointment(){
        userInterface.viewAppointmentCreator();
    }
}
