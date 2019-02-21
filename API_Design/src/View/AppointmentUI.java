/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Appointment;
import java.util.ArrayList;

/**
 *
 * @author nate
 */
public class AppointmentUI {
    
    /**
     * Allows the user to see the appointment creator
     */
    public void viewAppointmentCreator(){
        System.out.println("Create an appointment");
        System.out.println("Name:");
        System.out.println("Date:");
        System.out.println("Time:");
        System.out.println("Doctor:");
    }
    /**
     * Allows the user to see the scheduled appointments
     */
    public void viewAppointments(ArrayList<Appointment> apps){
        for(int i=0; i<apps.size(); i++){
            System.out.println(apps.get(i).getDate());
            System.out.println(apps.get(i).getTime());
            System.out.println(apps.get(i).getDoctor());
            System.out.println(apps.get(i).getRoom());
            System.out.println();
            System.out.println();
        }
    }
}
