package com.example.test;

import com.example.test.utils.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

import java.io.IOException;

public class SignUpQualificationsController {

    public TableColumn<String,String> diploma;
    public TableColumn<String,String> title;
    public TableColumn<String,String> institution;
    public TableColumn<String,String> dateStart;
    public TableColumn<String,String> dateAcq;
    public TableColumn<String,String> tech;
    public TableColumn<String,String> description;
    public Button add;
    public Button remove;
    public Button update;
    public Button back;
    public Button next;
    @FXML protected void onAdd() throws IOException {
        SceneSwitcher.openNewWindow(getClass(),"qualification","priority");
    }
    @FXML protected void onRemove(){

    }
    @FXML protected void onUpdate(){

    }
    @FXML protected void onBack(){
        SceneSwitcher.previous(back);
    }
    @FXML protected void onNext(){

    }
}
