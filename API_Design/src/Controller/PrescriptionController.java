/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author nate
 */
public class PrescriptionController {

    @FXML
    private Stage stage;
    private static PrescriptionController controller;

    private PrescriptionController(Stage stage) {
        this.stage = stage;

    }

    public static PrescriptionController getPrescriptionController(Stage stage) {
        if (controller != null) {
            return controller;
        } else {
            controller = new PrescriptionController(stage);
        }
        return controller;
    }

    public void setUpViewPrescriptionScene() {
        Parent root;
        Scene scene;

        try {
            root = FXMLLoader.load(getClass().getResource("/View/ViewPrescriptionUI.fxml"));
            scene = new Scene(root, 600, 600);
            stage.setTitle("Navigation");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUpAddPrescriptionScene() {
        Parent root;
        Scene scene;

        try {
            root = FXMLLoader.load(getClass().getResource("/View/AddPrescriptionUI.fxml"));
            scene = new Scene(root, 600, 600);
            stage.setTitle("Navigation");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
