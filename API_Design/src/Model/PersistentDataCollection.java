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
    private final ArrayList<Patient> patientList;
    private final ArrayList<Doctor> doctorList;
    private final ArrayList<InsuranceCompany> insuranceList;
    private final ArrayList<Pharmacist> pharmaList;
    private final ArrayList<Nurse> nurseList;
    private int loggedInPatient;
    private int loggedInDoctor;
    private int loggedInNurse;
    private int loggedInInsure;
    private int loggedInPharma;
    private int selectedRecord;

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
        loggedInPatient = -1;
        loggedInDoctor = -1;
        loggedInNurse = -1;
        loggedInInsure = -1;
        loggedInPharma = -1;
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
    public int getLoggedInPatient() {
        return loggedInPatient;
    }

    /**
     * @param loggedInPatient the loggedInPatient to set
     */
    public void setLoggedInPatient(int loggedInPatient) {
        this.loggedInPatient = loggedInPatient;
    }

    /**
     * @return the loggedInDoctor
     */
    public int getLoggedInDoctor() {
        return loggedInDoctor;
    }

    /**
     * @param loggedInDoctor the loggedInDoctor to set
     */
    public void setLoggedInDoctor(int loggedInDoctor) {
        this.loggedInDoctor = loggedInDoctor;
    }

    /**
     * @return the loggedInNurse
     */
    public int getLoggedInNurse() {
        return loggedInNurse;
    }

    /**
     * @param loggedInNurse the loggedInNurse to set
     */
    public void setLoggedInNurse(int loggedInNurse) {
        this.loggedInNurse = loggedInNurse;
    }

    /**
     * @return the loggedInInsure
     */
    public int getLoggedInInsure() {
        return loggedInInsure;
    }

    /**
     * @param loggedInInsure the loggedInInsure to set
     */
    public void setLoggedInInsure(int loggedInInsure) {
        this.loggedInInsure = loggedInInsure;
    }

    /**
     * @return the loggedInPharma
     */
    public int getLoggedInPharma() {
        return loggedInPharma;
    }

    /**
     * @param loggedInPharma the loggedInPharma to set
     */
    public void setLoggedInPharma(int loggedInPharma) {
        this.loggedInPharma = loggedInPharma;
    }

    public void setSelectedRecord(Record record) {
        for (int i = 0; i < patientList.get(loggedInPatient).getPatientRecords().size(); i++) {
            if (patientList.get(loggedInPatient).getPatientRecords().get(i).getComments().equals(record.getComments())) {
                selectedRecord = i;
            }
        }
    }

    public int getSelectedRecord() {
        return selectedRecord;
    }
}
