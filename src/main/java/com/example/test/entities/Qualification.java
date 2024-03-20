package com.example.test.entities;

import java.time.LocalDate;

public class Qualification {
    private String diploma;
    private String title;
    private String institution;
    private String technology;
    private LocalDate dateStart;
    private LocalDate dateFinish;
    private String Description;

    public Qualification(String diploma, String title, String institution, String technology, LocalDate dateStart, LocalDate dateFinish, String description) {
        this.diploma = diploma;
        this.title = title;
        this.institution = institution;
        this.technology = technology;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        Description = description;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
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
        return "diploma: " + diploma  +
                ", title: " + title +
                ", institution: " + institution +
                ", technology: " + technology +
                ", dateStart: " + dateStart +
                ", dateFinish: " + dateFinish +
                ", Description: " + Description;
    }
}
