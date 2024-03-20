package com.example.test;

import com.example.test.entities.Project;
import com.example.test.utils.FieldVerifier;
import com.example.test.utils.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SignUpProjectsController {
    public Button remove;
    public Button update;
    public Button back;
    public Button next;
    public ListView<Project> projectsList;
    private List<Project> projects = new ArrayList<>();
    public TextField title;
    public DatePicker dateStart;
    public DatePicker dateFinish;
    public TextArea description;
    public Button clear;
    public Button add;

    public Project onRemove() {
        if (!projectsList.getItems().isEmpty()){
            Project selectedProject = projectsList.getSelectionModel().getSelectedItem();
            projectsList.getItems().remove(selectedProject);
            projects.remove(selectedProject);
            return selectedProject;
        }
        return null;
    }

    public void onUpdate() {
        if (!projectsList.getItems().isEmpty()){
            Project updateProject = projectsList.getSelectionModel().getSelectedItem();
            if (updateProject !=null){
                title.setText(updateProject.getTitle());
                dateStart.setValue(updateProject.getDateStart());
                dateFinish.setValue(updateProject.getDateFinish());
                description.setText(updateProject.getDescription());
            }
            onRemove();
        }
    }

    public void onBack() {
        SceneSwitcher.previous(back);
    }

    public void onNext() {

    }

    public void onClear() {
        Stream.of(title,description).forEach(TextInputControl::clear);
        dateStart.setValue(null);
        dateFinish.setValue(null);
        Stream.of(title,description,dateStart,dateFinish).forEach(n -> n.setStyle("-fx-border-color: grey"));
    }

    public void onAdd() {
        boolean fieldsAreValid = FieldVerifier.areValid(title,description);
        boolean dateStartIsValid = FieldVerifier.dateIsValid(dateStart);
        boolean dateFinishIsValid = FieldVerifier.dateIsValid(dateFinish);
        if (fieldsAreValid && dateStartIsValid && dateFinishIsValid){
            Project project = new Project(
                    title.getText(),
                    dateStart.getValue(),
                    dateFinish.getValue(),
                    description.getText()
            );
            projectsList.getItems().add(project);
            projects.add(project);

            onClear();
        }
        System.out.println();
        projects.forEach(System.out::println);
    }
}
