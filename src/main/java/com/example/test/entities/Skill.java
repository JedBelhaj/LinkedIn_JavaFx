package com.example.test.entities;

import java.time.LocalDate;

public abstract class Skill extends Project {

    private String technology;

    public Skill(String title, LocalDate dateStart, LocalDate dateFinish, String description,String technology) {
        super(title, dateStart, dateFinish, description);
        this.technology = technology;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    @Override
    public String toString() {
        return
                ", technology: " + technology + super.toString();
    }
}
