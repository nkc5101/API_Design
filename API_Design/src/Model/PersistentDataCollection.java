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
    private ArrayList<Nurse> nurseList;
    private User loggedInUser;

    public PersistentDataCollection() {
        patientList = new ArrayList<>();
        doctorList = new ArrayList<>();
        insuranceList = new ArrayList<>();
        pharmaList = new ArrayList<>();
        nurseList = new ArrayList<>();
        patientList.add(new Patient("username", "password", "uesr@email.com", "Joe", "Shmoe"));
        doctorList.add(new Doctor("doctor", "rulez", "doctor@email.com", "Jane", "Doe", "Hershey Medical Center", "Surgery"));
        insuranceList.add(new InsuranceCompany("insurance", "sucks", "insurance@email.com", "ATZ Healthcare", "123 E Main St"));
        pharmaList.add(new Pharmacist("pharma", "password", "pharma@email.com", "John", "Doe", "Bayer", "Giant Pharmacy"));
        nurseList.add(new Nurse("nurse", "password", "nurse@email.com", "Jennifer", "James", doctorList.get(0), "General", "Hershey"));
    }

    public static PersistentDataCollection getPersistentDataCollection() {
        if (dataCollection == null) {
            dataCollection = new PersistentDataCollection();
        }
        return dataCollection;
    }

    public ArrayList<Patient> getPatientList() {
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

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    /**
     * @return the nurseList
     */
    public ArrayList<Nurse> getNurseList() {
        return nurseList;
    }
}
