/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;
import View.*;
import java.util.ArrayList;
/**
 *
 * @author nate
 */
public class BillController {
    private PayBillUI userInterface;
    private ArrayList<Patient> patients;
    private ArrayList<InsuranceCompany> insurance;
    /**
     * Default constructor for BillController and sets up user interface
     */
    public BillController(){
        this.patients = new ArrayList<>();
        this.insurance = new ArrayList<>();
        this.userInterface = new PayBillUI();
        userInterface.viewBalance();
    }
    /**
     * Shows the patient the user interface for paying bills
     */
    public void payBill(){
        
    }
}
