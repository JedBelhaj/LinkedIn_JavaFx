package com.example.test;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextInputControl;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class FieldVerifier {

    public static boolean isValidField(String value, String regex) {
        if (regex == null && !value.isBlank()) return true;
        else if (regex!=null) return value.matches(regex);
        return false;
    }
    @FXML
    public static boolean areValid(TextInputControl... fields) {
        Stream.of(fields).forEach(f ->
                f.setStyle(f.getText().isBlank() ? "-fx-border-color: red" : "-fx-border-color: grey")
        );
        return Stream.of(fields).noneMatch(f -> f.getText().isBlank());
    }
    @FXML
    public static void updateFieldColor(TextInputControl field, String regex) {
        String value = field.getText();
        if (value.isBlank() || (regex != null && !isValidField(value, regex))) {
            field.setStyle("-fx-border-color: red");
        } else {
            field.setStyle("-fx-border-color: grey");
        }
    }
    @FXML
    public static boolean isValid(Node node, Predicate<Node> test){
        if (test.test(node)) {
            node.setStyle("-fx-border-color: grey");
            return true;
        }
        else node.setStyle("-fx-border-color: red");
        return false;
    }
}

