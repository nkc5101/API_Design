/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Doctor;
import View.PrescriptionUI;
import java.util.ArrayList;

/**
 *
 * @author nate
 */
public class PrescriptionController {
    private PrescriptionUI userInterface;
    private ArrayList<Doctor> doctors;
    private static PrescriptionController controller;
    /**
     * Default constructor for PrescriptionController and displays the prescriptions interface
     */
    private PrescriptionController(){
        this.doctors = new ArrayList<>();
        userInterface = new PrescriptionUI();
        userInterface.viewPrescriptions(PatientController.getPatientController().getPatientList().get(0));
        this.controller = new PrescriptionController();
    }
    
    public static PrescriptionController getPrescriptionController(){
        return controller;
    }
    /**
     * Adds prescription to the patients list
     * @param prescription 
     */
    public void addPrescripiton(String prescription){
        PatientController.getPatientController().getPatientList().get(0).addPrescription(prescription);
    }
    /**
     * Sets allows user to see interface for prescribing medication
     */
    public void viewPrescriptionForm(){
        userInterface.viewPrescriptionForm();
    }
}
