/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Patient;

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
        viewPatientSingleRecord(0);
    }
    
    /**
     * Allows the user to view an individual record for a single patient
     * @param index index of record to select
     */
    public void viewPatientSingleRecord(int index){
        
    }
}
