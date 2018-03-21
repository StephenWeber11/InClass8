package com.app.inclass8;

/**
 * Created by CHINU on 3/20/2018.
 */

import java.io.Serializable;

public class Student implements Serializable{

    private String name;
    private String email;
    private String department;
    private String mood;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", mood='" + mood + '\'' +
                '}';
    }


}
