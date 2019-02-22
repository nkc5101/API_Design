/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Record;

/**
 *
 * @author nate
 */
public class PayBillUI {
    /**
     * Shows the user the balance remaining for their treatment as well as the basic UI
     * @param record
     */
    public void viewBalance(Record record){
        System.out.println(record.getAppointment().getDate());
        System.out.println(record.getAppointment().getTime());
        System.out.println(record.getAppointment().getDoctor());
        System.out.println("Attended: " + record.isCompleted());
        System.out.println(record.getPrice());
    }
    /**
     * Shows the user the pay bill UI which will allow them to input their information
     */
    public void payBill(Record record){
        System.out.println("Remaining balance:" + record.getPrice());
        System.out.println("Insurance?");
        System.out.println("Credit card?");
    }
}
