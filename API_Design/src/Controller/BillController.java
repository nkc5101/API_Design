/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Record;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author nate
 */
public class BillController {

    private final Stage stage;
    private static BillController controller;

    /**
     * Default constructor for BillController and sets up user interface
     */
    private BillController(Stage stage) {
        this.stage = stage;

    }

    public static BillController getBillController(Stage stage) {
        if (controller == null) {
            controller = new BillController(stage);
            return controller;
        } else {
            return controller;
        }
    }

    /**
     * Shows the patient the user interface for paying bills
     */
    public void setUpPayBillUI() {
        Parent root;
        Scene scene;

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/PayBillUI.fxml"));
            root = (Parent) fxmlLoader.load();
            scene = new Scene(root, 600, 600);
            stage.setTitle("Pay Bill");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void setUpViewBillUI() {
        Parent root;
        Scene scene;

        try {
            root = FXMLLoader.load(getClass().getResource("/View/ViewBillUI.fxml"));
            scene = new Scene(root, 600, 600);
            stage.setTitle("View Bill");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
