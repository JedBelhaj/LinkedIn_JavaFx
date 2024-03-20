package com.example.test;

import com.example.test.utils.ComboUtils;
import com.example.test.utils.FieldVerifier;
import com.example.test.utils.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    public ComboBox<String> country;
    public Button next;
    public Button back;
    @FXML
    private LogInController mainController;
    public TextField firstName;
    public TextField lastName;
    public TextField phoneNumber;
    public DatePicker dateOfBirth;
    public TextField email;
    public ComboBox<String> gender;

    @FXML
    protected void onBack() throws IOException {
        SceneSwitcher.previous(back);
    }
    @FXML
    protected void onNext() throws IOException {
        //check validity of all fields
        boolean fieldsAreValid = FieldVerifier.areValid(firstName, lastName);
        boolean emailIsValid = FieldVerifier.emailIsValid(email);
        boolean phoneIsValid = FieldVerifier.phoneIsValid(phoneNumber);
        boolean dateIsValid = FieldVerifier.dateIsValid(dateOfBirth);
        boolean genderIsValid = FieldVerifier.choiceBoxIsValid(gender);
        boolean countryIsValid = FieldVerifier.choiceBoxIsValid(country);
        //uncomment this after you're done with testing the app
        /*if (fieldsAreValid && emailIsValid && phoneIsValid && dateIsValid && genderIsValid && countryIsValid){
            System.out.println("good");
            SceneSwitcher.goTo(getClass(),"signupQualifications",next);
        }*/
        SceneSwitcher.goTo(getClass(),"signupQualifications",next);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        country.getItems().addAll(ComboUtils.countries);
        gender.getItems().addAll("Male","Female");
    }
}
