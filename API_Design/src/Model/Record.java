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
public class Record {
    private Appointment appointment;
    private String comments;
    private boolean completed;
    /**
     * The default constructor for Record
     * @param appointment
     * @param comments
     * @param completed 
     */
    public Record(Appointment appointment, String comments, boolean completed){
        this.appointment = appointment;
        this.comments = comments;
        this.completed = completed;
    }

    /**
     * Return the appointment
     * @return the appointment
     */
    public Appointment getAppointment() {
        return appointment;
    }

    /**
     * Set the appointment in the record
     * @param appointment the appointment to set
     */
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    /**
     * Grab the comments left by the staff and patients
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * Set the comments left by the staff and patients
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Return whether the appointment was completed or not
     * @return the completed
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Set whether the appointment was completed or not
     * @param completed the completed to set
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    
}
