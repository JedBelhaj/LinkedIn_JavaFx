package com.example.test.entities;

import java.time.LocalDate;

public class Project {
    private String title;
    private LocalDate dateStart;
    private LocalDate dateFinish;
    private String Description;

    public Project(String title, LocalDate dateStart, LocalDate dateFinish, String description) {

        this.title = title;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        Description = description;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(LocalDate dateFinish) {
        this.dateFinish = dateFinish;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return
                ", title: " + title +
                        ", dateStart: " + dateStart +
                        ", dateFinish: " + dateFinish +
                        ", Description: " + Description;
    }
}
