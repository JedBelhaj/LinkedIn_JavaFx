package com.example.test;

import com.example.test.entities.PersonalAccount;
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
    public PasswordField password;
    public PasswordField confirmPassword;
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

        boolean passwordIsValid = FieldVerifier.isValid(password , (p) -> ((PasswordField)p).getText().length()>=8);
        boolean passwordsMatch = FieldVerifier.isValid(confirmPassword , (p) -> password.getText().equals(confirmPassword.getText()) && ((PasswordField)p).getText().length()>=8);



        boolean fieldsAreValid = FieldVerifier.areValid(firstName, lastName);
        boolean emailIsValid = FieldVerifier.emailIsValid(email);
        boolean phoneIsValid = FieldVerifier.phoneIsValid(phoneNumber);
        boolean dateIsValid = FieldVerifier.dateIsValid(dateOfBirth);
        boolean genderIsValid = FieldVerifier.choiceBoxIsValid(gender);
        boolean countryIsValid = FieldVerifier.choiceBoxIsValid(country);
        if (fieldsAreValid && emailIsValid && phoneIsValid && dateIsValid && genderIsValid && countryIsValid && passwordIsValid && passwordsMatch){

            PersonalAccount p = PersonalAccount.getInstance();
            p.setFirstName(firstName.getText());
            p.setLastName(lastName.getText());
            p.setPhoneNumber(phoneNumber.getText());
            p.setEmail(email.getText());
            p.setCountry(country.getValue());
            p.setGender(gender.getValue());
            p.setDateOfBirth(dateOfBirth.getValue());
            p.setPassword(password.getText());
            PersonalAccount.setInstance(p);

            SceneSwitcher.goTo(getClass(),"signupQualifications",next);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        country.getItems().addAll(ComboUtils.countries);
        gender.getItems().addAll("Male","Female");
    }
}
