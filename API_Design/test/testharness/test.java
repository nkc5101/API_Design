/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testharness;

import Controller.*;
import Model.*;

/**
 *
 * @author nate
 */
public class test {

    public static void main(String args[]) {
        System.out.println("Running tests...");
        PatientController pController = PatientController.getPatientController();
        if (pController != null) {
            System.out.println("Patient Controller instanciated.");
            System.out.println("Record View created");
        } else {
            System.out.println("Patient Controller could not be created");
            System.out.println("Record View failed");
        }
        if (pController.getPatientList() != null) {
            System.out.println("Patient list created and accessible");
        } else {
            System.out.println("Patient list could not be created or accessed.");
        }
        pController.viewSingleRecord();
        System.out.println("View sucessfully switched");
        pController.addPatient(new Patient("user", "pass", "email", "test", "test", new InsuranceCompany("Test", "test"), new Doctor("test", "pass", "email", "test", "test", "test", "test")));
        if (pController.getPatientList().size() == 2) {
            System.out.println("Patient added successfully");
            pController.getPatientList().remove(1);
        } else {
            System.out.println("Patient could not be added");
        }

        AppointmentController aController = AppointmentController.getAppointmentController();
        if (aController != null) {
            System.out.println("Appointment Controller created");
            System.out.println("Appointment View created");
        } else {
            System.out.println("Appointment Controller could not be created");
            System.out.println("Appointment View could not be created");
        }
        aController.viewAddAppointment();
        System.out.println("Appointment View sucessfully switched");
        aController.addAppointment(new Appointment(pController.getPatientList().get(0), pController.getPatientList().get(0).getDoctor(), "12/30", "12:30", "120", "Hershey"));
        if (pController.getPatientList().get(0).getAppointments().size() == 2) {
            System.out.println("Appointment successfully added");
        } else {
            System.out.println("Appoint could not be added");
        }

        BillController bController = BillController.getBillController();
        if (bController != null) {
            System.out.println("Bill Controller successfully created");
            System.out.println("Bill View successfully created");
        } else {
            System.out.println("Bill Controller could not be created");
            System.out.println("Bill View could not be created");
        }

        bController.payBill();
        System.out.println("Bill View switched successfully");

        PrescriptionController prescriptController = PrescriptionController.getPrescriptionController();
        if (prescriptController != null) {
            System.out.println("Prescription Controller successfully created");
            System.out.println("Prescription View successfully created");
        } else {
            System.out.println("Prescription Controller could not be created");
            System.out.println("Prescription View could not be created");
        }

        prescriptController.addPrescription("test");
        if (pController.getPatientList().get(0).getPrescriptions().size() == 2) {
            System.out.println("Prescription successfully added");
        } else {
            System.out.println("Prescription could not be added");
        }

        pController.removePatient(0);
        if (pController.getPatientList().isEmpty()) {
            System.out.println("Patient removed successfully");
        } else {
            System.out.println("Patient not removed.");
        }
    }

}
