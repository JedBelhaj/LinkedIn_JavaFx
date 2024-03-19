package com.example.test;

import com.example.test.utils.FieldVerifier;
import com.example.test.utils.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class accountTypeController implements Initializable {
    public ChoiceBox<String> accountType;
    public Button next;
    public Button back;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accountType.getItems().addAll("Entreprise","Personal","Admin");
    }
    @FXML
    protected void onNext() throws IOException {
        if (FieldVerifier.choiceBoxIsValid(accountType)){
            String destination = "accountType";
            switch (accountType.getValue()){
                case "Personal":
                    destination = "signup";
                    break;
                case "Entreprise":
                    destination = "signupEntreprise";
                    break;
                case "Admin":
                    destination = "signupAdmin";
                    break;
                default:
                    break;
            }
            SceneSwitcher.goTo(getClass(),destination,next);
        }
    }
    @FXML
    protected void onBack() throws IOException {
        SceneSwitcher.previous(back);
    }
}
