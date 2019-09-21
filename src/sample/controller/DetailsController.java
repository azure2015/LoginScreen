package sample.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class DetailsController {

    @FXML
    private Label detailsWelcomeLabel;

    @FXML
    private Label detailsName;

    @FXML
    private Label detailsAge;

    @FXML
    private Label detailsProfession;

    @FXML
    private Hyperlink detailsWeb;

    @FXML
    private Hyperlink detailsTwitter;


    @FXML
    void initialize() {
        detailsWeb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI("http://www.bbc.co.uk"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        detailsTwitter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI("http://www.twitter.co.uk"));
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    void setName(String name,int age, String profession) {
        detailsWelcomeLabel.setText("Welcome " + name);
        detailsName.setText("Name: " + name);
        detailsAge.setText("Age: " + String.valueOf(age));
        detailsProfession.setText("Profession: " + profession);
    }
}
