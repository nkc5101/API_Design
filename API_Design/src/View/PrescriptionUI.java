/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Patient;
import java.util.ArrayList;

/**
 *
 * @author nate
 */
public class PrescriptionUI {
    /**
     * Shows the user the available prescriptions and where they can pick it up
     * @param patient patient who's prescriptions are being shown
     */
    public void viewPrescriptions(Patient patient){
        ArrayList<String> prescriptions = patient.getPrescriptions();
        System.out.println(patient.getFirstName() + " " + patient.getLastName() + "'s Prescriptions");
        for(int i=0; i<prescriptions.size(); i++){
            System.out.println(prescriptions.get(i));
        }
    }
    /**
     * Shows the doctor the user interface for filling out a prescription
     */
    public void viewPrescriptionForm(){
        System.out.println("Patient:");
        System.out.println("Prescription:");
        System.out.println("Dosage:");
        System.out.println("Docotor Signature:");
    }
}
