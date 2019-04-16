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
public class Prescription {
    private final Doctor doctor;
    private final String drugName;
    private final String doseage;
    private final String date;
    
    public Prescription(Doctor doctor, String drugName, String doseage, String date){
        this.doctor = doctor;
        this.drugName = drugName;
        this.doseage = doseage;
        this.date = date;
    }

    /**
     * @return the doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * @return the drugName
     */
    public String getDrugName() {
        return drugName;
    }

    /**
     * @return the dosage
     */
    public String getDosage() {
        return doseage;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }
}
