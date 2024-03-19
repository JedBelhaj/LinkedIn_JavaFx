package com.example.test;

import com.example.test.utils.FieldVerifier;
import com.example.test.utils.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    private final String[] countries = {
            "Afghanistan", "Albania", "Algeria", "Andorra", "Angola",
            "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria",
            "Azerbaijan", "The Bahamas", "Bahrain", "Bangladesh", "Barbados",
            "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia",
            "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria",
            "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia", "Cameroon",
            "Canada", "Central African Republic", "Chad", "Chile", "China",
            "Colombia", "Comoros", "Congo, Democratic Republic of the",
            "Congo, Republic of the", "Costa Rica", "Côte d’Ivoire", "Croatia",
            "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica",
            "Dominican Republic", "East Timor (Timor-Leste)", "Ecuador", "Egypt",
            "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini",
            "Ethiopia", "Fiji", "Finland", "France", "Gabon", "The Gambia",
            "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala",
            "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary",
            "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel",
            "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati",
            "Korea, North", "Korea, South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos",
            "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein",
            "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives",
            "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico",
            "Micronesia, Federated States of", "Moldova", "Monaco", "Mongolia",
            "Montenegro", "Morocco", "Mozambique", "Myanmar (Burma)", "Namibia",
            "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger",
            "Nigeria", "North Macedonia", "Norway", "Oman", "Pakistan", "Palau",
            "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland",
            "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis",
            "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino",
            "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles",
            "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands",
            "Somalia", "South Africa", "Spain", "Sri Lanka", "Sudan", "Sudan, South",
            "Suriname", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan",
            "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia",
            "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine",
            "United Arab Emirates", "United Kingdom", "United States", "Uruguay",
            "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen",
            "Zambia", "Zimbabwe"
    };
    public ChoiceBox<String> country;
    public Button next;
    public Button back;
    @FXML
    private LogInController mainController;
    public TextField firstName;
    public TextField lastName;
    public TextField phoneNumber;
    public DatePicker dateOfBirth;
    public TextField email;
    public ChoiceBox<String> gender;

    @FXML
    protected void onBack() throws IOException {
        SceneSwitcher.previous(back);
    }
    @FXML
    protected void onNext(){
        //check validity of all fields
        boolean fieldsAreValid = FieldVerifier.areValid(firstName, lastName);
        boolean emailIsValid = FieldVerifier.emailIsValid(email);
        boolean phoneIsValid = FieldVerifier.phoneIsValid(phoneNumber);
        boolean dateIsValid = FieldVerifier.dateIsValid(dateOfBirth);
        boolean genderIsValid = FieldVerifier.choiceBoxIsValid(gender);
        boolean countryIsValid = FieldVerifier.choiceBoxIsValid(country);

        if (fieldsAreValid && emailIsValid && phoneIsValid && dateIsValid && genderIsValid && countryIsValid){
            System.out.println("good");
        }
    }

    public void setMainController(LogInController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        country.getItems().addAll(countries);
        gender.getItems().addAll("Male","Female");
    }
}
