/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.*;
/**
 *
 * @author nate
 */

public class BillController {
    private PayBillUI userInterface;
    private static BillController controller;
    /**
     * Default constructor for BillController and sets up user interface
     */
    private BillController(){
        this.userInterface = new PayBillUI();
        userInterface.viewBalance(PatientController.getPatientController().getPatientList().get(0).getPatientRecords().get(0));
    }
    
    public static BillController getBillController(){
        if(controller == null){
            controller = new BillController();
            return controller;
        } else {
            return controller;
        }
    }
    /**
     * Shows the patient the user interface for paying bills
     */
    public void payBill(){
        userInterface.payBill(PatientController.getPatientController().getPatientList().get(0).getPatientRecords().get(0));
    }
}
