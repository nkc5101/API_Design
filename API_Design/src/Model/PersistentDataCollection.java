/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author nate
 */
public class PersistentDataCollection {
    private static PersistentDataCollection dataCollection;
    private ArrayList<Patient> patientList;
    private ArrayList<Doctor> doctorList;
    private ArrayList<InsuranceCompany> insuranceList;
    private ArrayList<Pharmacist> pharmaList;
    private User loggedInUser;
    
    public PersistentDataCollection(){
        patientList = new ArrayList<>();
        doctorList = new ArrayList<>();
        insuranceList = new ArrayList<>();
        pharmaList = new ArrayList<>();
    }
    
    public static PersistentDataCollection getPersistentDataCollection(){
        if(dataCollection == null){
            dataCollection = new PersistentDataCollection();
        } 
        return dataCollection;
    }
    
    public ArrayList<Patient> getPatientList(){
        return patientList;
    }

    /**
     * @return the doctorList
     */
    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

    /**
     * @return the insuranceList
     */
    public ArrayList<InsuranceCompany> getInsuranceList() {
        return insuranceList;
    }

    /**
     * @return the pharmaList
     */
    public ArrayList<Pharmacist> getPharmaList() {
        return pharmaList;
    }
    
    public User getLoggedInUser(){
        return loggedInUser;
    }
    
    public void setLoggedInUser(User user){
        this.loggedInUser = user;
    }
}
