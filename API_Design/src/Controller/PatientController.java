/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Doctor;
import Model.InsuranceCompany;
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
    private static PatientController controller;
    /**
     * Default Constructor for PatientController 
     */
    private PatientController(){
        this.patientList = new ArrayList<>();
        this.userInterface = new RecordsUI();
        this.controller = new PatientController();
        userInterface.viewPatientRecords(patientList.get(0));
        patientList.add(new Patient("user", "pass", "user@gmail.com", "Joe", "Shmoe", new InsuranceCompany("Blue cross", "123 Atherton St"), new Doctor("test", "pass","test@email.com","Jane", "Doe", "Hershey", "Surgery")));
        
    }
    
    public static PatientController getPatientController(){
        return controller;
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
    
    public void viewSingleRecord(){
        userInterface.viewPatientSingleRecord(patientList.get(0).getPatientRecords().get(0));
    }
    
}
