/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Patient;
import View.RecordsUI;
import java.util.ArrayList;

/**
 *
 * @author nate
 */
public class PatientController {
    private ArrayList<Patient> patientList;
    private RecordsUI userInterface;
    /**
     * Default Constructor for PatientController 
     */
    public PatientController(){
        this.patientList = new ArrayList<>();
        this.userInterface = new RecordsUI();
        userInterface.viewPatientRecords(patientList.get(0));
        
    }
    /**
     * Adds patient to list of patients
     * @param patient patient who is being added
     */
    public void addPatient(Patient patient){
        patientList.add(patient);
    }
    /**
     * Remove patient from list of patients
     * @param index index of patient to be removed
     */
    public void removePatient(int index){
        patientList.remove(index);
    }
    /**
     * Returns the list of patients
     * @return the list of patients
     */
    public ArrayList<Patient> getPatientList(){
        return patientList;
    }
    
}
