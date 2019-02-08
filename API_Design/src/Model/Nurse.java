/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author nate
 */
public class Nurse extends User{
    private String firstName;
    private String lastName;
    private Doctor doctor;
    private String type;
    private String hospital;
    /**
     * Default constructor for Nurse
     * @param username
     * @param password
     * @param email
     * @param firstName
     * @param lastName
     * @param doctor
     * @param type
     * @param hospital 
     */
    public Nurse(String username, String password, String email, String firstName, String lastName, Doctor doctor, String type, String hospital){
        super(username, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.doctor = doctor;
        this.type = type;
        this.hospital = hospital;
    }

    /**
     * Return the nurse's first name
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the nurse's first name
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Return the nurse's last name
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the nurse's last name
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Return the nurse's doctor
     * @return the doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Set the nurse's doctor
     * @param doctor the doctor to set
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * Return the type of nurse
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Set the type of nurse
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the nurse's hospital
     * @return the hospital
     */
    public String getHospital() {
        return hospital;
    }

    /**
     * Set the nurse's hospital
     * @param hospital the hospital to set
     */
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
}
