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
public class Doctor extends User {
    
    private String firstName;
    private String lastName;
    private String hospital;
    private String specialty;
    private ArrayList<Appointment> appointments;

    /**
     * Default constructor for Doctor
     *
     * @param username
     * @param password
     * @param email
     * @param firstName
     * @param lastName
     * @param hospital
     * @param specialty
     */
    public Doctor(String username, String password, String email, String firstName, String lastName, String hospital, String specialty) {
        super(username, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.hospital = hospital;
        this.specialty = specialty;
        this.appointments = new ArrayList<>();
    }

    /**
     * Return the doctor's first name
     *
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the doctor's first name
     *
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Return the doctor's last name
     *
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the doctor's last name
     *
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Return the doctor's hospital
     *
     * @return the hospital
     */
    public String getHospital() {
        return hospital;
    }

    /**
     * Set the hospital the doctor works at
     *
     * @param hospital the hospital to set
     */
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    /**
     * Return the doctor's specialty
     *
     * @return the specialty
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * Set the doctor's specialty
     *
     * @param specialty the specialty to set
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /**
     * @return the appointments
     */
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }
    
    public void addAppointment(Appointment app) {
        appointments.add(app);
    }
    
}
