package com.example.test;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;

import java.util.stream.Stream;

public class MainController {
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    @FXML
    private Label forgot;
    @FXML
    private TextField user;
    @FXML
    private TextField pass;
    @FXML
    private Button login;
    @FXML
    private Label messageLabel;
    @FXML
    protected String getUser() {
        return user.getText();
    }
    @FXML
    protected String getPass() {
        return pass.getText();
    }
    @FXML
    protected void onSubmit() {
        if (getUser().isBlank() || getPass().isBlank()){
            messageLabel.setText("Empty Fields!");
            Stream.of(user,pass).filter(n -> n.getText().isBlank())
                                .forEach(this::makeRed);
        }
        else if (!getUser().matches(EMAIL_REGEX)){
            messageLabel.setText("Invalid Email Format");
        }
        else{
            System.out.println(getUser());
            System.out.println(getPass());
            //account verification logic goes here
        }
    }
    @FXML
    protected void makeRed(TextField item){
        item.setStyle("-fx-border-color: red;");
    }
}