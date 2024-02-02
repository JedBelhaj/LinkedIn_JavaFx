package com.example.test;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private TextField user;
    @FXML
    private TextField pass;
    @FXML
    private Button login;

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
        System.out.println(getUser());
        System.out.println(getPass());
        //account verification logic goes here
    }
}