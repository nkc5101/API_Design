/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.PersistentDataCollection;

/**
 *
 * @author nate
 */
public class PersistentDataController {

    private static PersistentDataController controller;
    private PersistentDataCollection dataCollection;

    /**
     * Default constructor for PrescriptionController and displays the
     * prescriptions interface
     */
    private PersistentDataController() {
        readData();
        if (dataCollection == null) {
            dataCollection = new PersistentDataCollection();
            writeData();
            readData();
        }
    }

    public static PersistentDataController getPersistentDataController() {
        if (controller == null) {
            controller = new PersistentDataController();
        }
        return controller;
    }

    public PersistentDataCollection getPersistentDataCollection() {
        return dataCollection;
    }

    private void readData() {
        //insert read data from disk functionality
    }

    private void writeData() {
        //insert write data to disk functionality
    }
}
