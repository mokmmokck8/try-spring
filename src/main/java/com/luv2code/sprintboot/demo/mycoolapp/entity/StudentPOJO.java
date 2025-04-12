package com.luv2code.sprintboot.demo.mycoolapp.entity;

public class StudentPOJO {
    private String firstName;
    private String lastName;

    public StudentPOJO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public StudentPOJO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
