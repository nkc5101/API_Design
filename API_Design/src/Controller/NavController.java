/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author nate
 */
public class NavController {

    @FXML
    private final Stage stage;
    private static NavController controller;

    private NavController(Stage stage) {
        this.stage = stage;
        this.setUpNavScene();
        this.stage.show();
    }

    public static NavController getNavController(Stage stage) {
        if (controller != null) {
            controller.setUpNavScene();
            return controller;
        } else {
            controller = new NavController(stage);
        }
        return controller;
    }

    public void setUpNavScene() {
        Parent root;
        Scene scene;

        try {
            root = FXMLLoader.load(getClass().getResource("/View/NavUI.fxml"));
            scene = new Scene(root, 600, 600);
            stage.setTitle("AlphaCare");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void setUpLoginScene() {
        Parent root;
        Scene scene;

        try {
            root = FXMLLoader.load(getClass().getResource("/View/LoginUI.fxml"));
            scene = new Scene(root, 600, 600);
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    void setUpSignUpScene() {
        Parent root;
        Scene scene;

        try {
            root = FXMLLoader.load(getClass().getResource("/View/SignUpUI.fxml"));
            scene = new Scene(root, 600, 600);
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
