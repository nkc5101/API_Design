/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Doctor;
import Model.Patient;
import View.PrescriptionUI;
import java.util.ArrayList;

/**
 *
 * @author nate
 */
public class PrescriptionController {
    private PrescriptionUI userInterface;
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    /**
     * Default constructor for PrescriptionController and displays the prescriptions interface
     */
    public PrescriptionController(){
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
        userInterface = new PrescriptionUI();
        userInterface.viewPrescriptions();
    }
    /**
     * Adds prescription to the patients list
     * @param prescription 
     */
    public void addPrescripiton(String prescription){
        
    }
    /**
     * Sets allows user to see interface for prescribing medication
     */
    public void viewPrescriptionForm(){
        userInterface.viewPrecriptionForm();
    }
}
