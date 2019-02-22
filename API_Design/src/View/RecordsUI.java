/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Patient;
import Model.Record;

/**
 *
 * @author nate
 */
public class RecordsUI {
    
    /**
     * Allows the user to view a list of records for a single patient
     * @param patient patient who's records are being shown
     */
    public void viewPatientRecords(Patient patient){
        for(int i=0; i<patient.getPatientRecords().size(); i++){
            System.out.println(patient.getPatientRecords().get(i).getAppointment().getDate() + ": " + patient.getPatientRecords().get(i).getAppointment().getTime());
        }
    }
    
    /**
     * Allows the user to view an individual record for a single patient
     * @param record
     */
    public void viewPatientSingleRecord(Record record){
        System.out.println(record.getAppointment().getDate());
        System.out.println(record.getAppointment().getTime());
        System.out.println(record.getAppointment().getDoctor());
        System.out.println(record.getAppointment().getHospital());
        System.out.println(record.getAppointment().getRoom());
        System.out.println("Was Completed: " + record.isCompleted());
        
    }
}
