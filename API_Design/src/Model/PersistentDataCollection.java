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
    private Patient loggedInPatient;
    private Doctor loggedInDoctor;
    private Nurse loggedInNurse;
    private InsuranceCompany loggedInInsure;
    private Pharmacist loggedInPharma;

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
        loggedInPatient = null;
        loggedInDoctor = null;
        loggedInNurse = null;
        loggedInInsure = null;
        loggedInPharma = null;
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

    

    /**
     * @return the nurseList
     */
    public ArrayList<Nurse> getNurseList() {
        return nurseList;
    }

    /**
     * @return the loggedInPatient
     */
    public Patient getLoggedInPatient() {
        return loggedInPatient;
    }

    /**
     * @param loggedInPatient the loggedInPatient to set
     */
    public void setLoggedInPatient(Patient loggedInPatient) {
        this.loggedInPatient = loggedInPatient;
    }

    /**
     * @return the loggedInDoctor
     */
    public Doctor getLoggedInDoctor() {
        return loggedInDoctor;
    }

    /**
     * @param loggedInDoctor the loggedInDoctor to set
     */
    public void setLoggedInDoctor(Doctor loggedInDoctor) {
        this.loggedInDoctor = loggedInDoctor;
    }

    /**
     * @return the loggedInNurse
     */
    public Nurse getLoggedInNurse() {
        return loggedInNurse;
    }

    /**
     * @param loggedInNurse the loggedInNurse to set
     */
    public void setLoggedInNurse(Nurse loggedInNurse) {
        this.loggedInNurse = loggedInNurse;
    }

    /**
     * @return the loggedInInsure
     */
    public InsuranceCompany getLoggedInInsure() {
        return loggedInInsure;
    }

    /**
     * @param loggedInInsure the loggedInInsure to set
     */
    public void setLoggedInInsure(InsuranceCompany loggedInInsure) {
        this.loggedInInsure = loggedInInsure;
    }

    /**
     * @return the loggedInPharma
     */
    public Pharmacist getLoggedInPharma() {
        return loggedInPharma;
    }

    /**
     * @param loggedInPharma the loggedInPharma to set
     */
    public void setLoggedInPharma(Pharmacist loggedInPharma) {
        this.loggedInPharma = loggedInPharma;
    }
}
