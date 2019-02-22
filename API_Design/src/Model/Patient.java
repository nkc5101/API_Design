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
public class Patient extends User{
    private String firstName;
    private String lastName;
    private InsuranceCompany patientInsurance;
    private Doctor doctor;
    private ArrayList<Appointment> appointments;
    private ArrayList<Record> patientRecords;
    private ArrayList<String> prescriptions;
    /**
     * Default constructor for Patient
     * @param username
     * @param password
     * @param email
     * @param firstName
     * @param lastName
     * @param patientInsurance 
     */
    public Patient(String username, String password, String email, String firstName, String lastName, InsuranceCompany patientInsurance, Doctor doctor) {
        super(username, password, email);
        this.firstName =firstName;
        this.lastName = lastName;
        this.patientInsurance = patientInsurance;
        this.doctor = doctor;
        this.appointments = new ArrayList<>();
        this.patientRecords = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
        
    }

    /**
     * Return the patient's first name
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the patient's first name
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Return the patient's last name
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the patient's last name
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Return the patients insurance company
     * @return the patientInsurance
     */
    public InsuranceCompany getPatientInsurance() {
        return patientInsurance;
    }

    /**
     * Set the patients insurance
     * @param patientInsurance the patientInsurance to set
     */
    public void setPatientInsurance(InsuranceCompany patientInsurance) {
        this.patientInsurance = patientInsurance;
    }
    
    /**
     * Adds a new appointment to the patient's list
     * @param newAppointment the patient's added appointment
    */
    public void addAppointment(Appointment newAppointment){
        
    }
    /*
    *Return the patient's appointments
    *@return the patient's appointments
    */
    public ArrayList<Appointment> getAppointments(){
        return appointments;
    }
    
    /**
    *Adds new Record to the patient's list
    * @param record the new record to add
    */
    public void addRecord(Record record){
        
    }
    /**
     * Return the patient's medical records
     * @return patientRecords the patient's list of records
     */
    public ArrayList<Record> getPatientRecords(){
        return patientRecords;
    }

    /**
     * Return the patient's prescriptions
     * @return the prescriptions
     */
    public ArrayList<String> getPrescriptions() {
        return prescriptions;
    }
    /**
     * Adds a prescription to the patient's list
     * @param prescription 
     */
    public void addPrescription(String prescription){
        
    }

    /**
     * @return the doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
}
