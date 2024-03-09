package com.example.test;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    protected void onSubmit(){
        FieldVerifier.updateFieldColor(user,EMAIL_REGEX);
        if(FieldVerifier.areValid(pass) && FieldVerifier.isValidField(getUser(), EMAIL_REGEX)){
            messageLabel.setText("");
            System.out.println(getUser()+" : "+getPass());
        }else{
            messageLabel.setText("Invalid Fields");
        }
    }
    @FXML
    protected void onSignUp() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signup.fxml"));
        Parent root = loader.load();
        SignUpController controller = loader.getController();

        Scene scene = new Scene(root);

        // Get the current stage
        Stage stage = (Stage) login.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
        controller.setMainController(this);
    }
}