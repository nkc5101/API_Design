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
public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;
    private String room;
    private String hospital;
    /**
     * The default constructor for appointment
     * @param patient
     * @param doctor
     * @param date
     * @param time
     * @param room
     * @param hospital 
     */
    public Appointment(Patient patient, Doctor doctor, String date, String time, String room, String hospital){
        this.patient = patient;
        this.doctor= doctor;
        this.date = date;
        this.time = time;
        this.room = room;
        this.hospital = hospital;
    }

    /**
     * Get the patient that has the appointment
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Set the patient that has the appointment
     * @param patient the patient to set
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Get the doctor that is performing the appointment
     * @return the doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Set the doctor that is performing the appointment
     * @param doctor the doctor to set
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * Get the date the appointment will take place
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Set the date the appointment will take place
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Get the time the appointment will take place
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * Set the time the appointment will take place
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Get the room the appointment will be in
     * @return the room
     */
    public String getRoom() {
        return room;
    }

    /**
     * Set the room the appointment will be in
     * @param room the room to set
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * Get the hospital the appointment is at
     * @return the hospital
     */
    public String getHospital() {
        return hospital;
    }

    /**
     * Set the hospital for the appointment
     * @param hospital the hospital to set
     */
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
}
