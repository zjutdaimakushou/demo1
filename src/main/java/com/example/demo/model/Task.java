package com.example.demo.model;

import java.util.Date;

public class Task {
    int id;
    String name;
    String description;
    float requirement;
    int award;
    int type;
    Date date;

    public Task() {
    }

    public Task(int id, String name, String description, float requirement, int award, int type, Date date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.requirement = requirement;
        this.award = award;
        this.type = type;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRequirement() {
        return requirement;
    }

    public void setRequirement(float requirement) {
        this.requirement = requirement;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
