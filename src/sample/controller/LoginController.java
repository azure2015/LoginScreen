package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private JFXTextField loginUsername;

    @FXML
    private JFXPasswordField loginPassword;

    @FXML
    private JFXButton loginButton;

    @FXML
    void initialize() {

        loginUsername.setStyle("-fx-text-inner-color: #a0a2ab");
        loginPassword.setStyle("-fx-text-inner-color: #a0a2ab");

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginUser();
                System.out.println("Login was clicked");
            }
        });
    }

    private void loginUser() {

        //Get the main window
        loginButton.getScene().getWindow().hide();

        if (!loginUsername.getText().toString().trim().equals("") &&
                 !loginPassword.getText().toString().trim().equals("")) {


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/details.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            DetailsController detailsController = loader.getController();
            detailsController.setName(loginUsername.getText(),32,"Java developer");

            stage.show();

            //Error code
//            //Login in Sucessful
//            Stage detailStage = new Stage();
//            try {
//
//                FXMLLoader loader = new FXMLLoader();
//
//                Parent root = FXMLLoader.load(getClass().getResource("/sample/view/details.fxml"));
//                Scene scene = new Scene(root);
//                detailStage.setScene(scene);
//
//                DetailsController detailsController = loader.getController();
//                detailsController.initialize();
//                detailsController.setName(loginUsername.getText().trim());
//                detailStage.show();
//                detailStage.setResizable(false);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }


        }
    }
}
