module com.example.test {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.test to javafx.fxml;
    exports com.example.test;
    exports com.example.test.utils;
    opens com.example.test.utils to javafx.fxml;
    exports com.example.test.entities;
}