package com.example.test;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;

import java.time.LocalDate;
import java.util.Date;
import java.util.stream.Stream;

public class SignUpController {
    @FXML
    private MainController mainController;
    @FXML
    private TextField name;
    @FXML
    private TextField title;
    @FXML
    private TextField profession;
    @FXML
    private DatePicker date;
    @FXML
    private TextField email;
    @FXML
    private TextField diploma;
    @FXML
    private TextArea skills;

    @FXML
    protected void onNext(){
        if (FieldVerifier.areValid(name,title,profession,email,diploma,skills) &&
        FieldVerifier.isValid(date, d -> {
            DatePicker datePicker = (DatePicker) d;
            LocalDate selectedDate = datePicker.getValue();
            return selectedDate != null;
        })){
            Stream.of(name,title,profession,email,diploma,skills)
                  .map(TextInputControl::getText)
                  .forEach(System.out::println);
            System.out.println(date.getValue());
        }
    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
