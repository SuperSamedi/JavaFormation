package com.digitalcity.advanced.jdbc;

import java.sql.Date;
import java.time.LocalDate;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String login;
    private Integer sectionID;
    private Integer yearResult;
    private String courseID;
    private Section section;

    // Default constructor. Does not work for transferring data from database
//    public Student(int id, String firstName, String lastName, LocalDate dateOfBirth, Integer sectionID, String courseID) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.dateOfBirth = dateOfBirth;
//        setBaseLogin();
//        this.sectionID = sectionID;
//        this.yearResult = null;
//        this.courseID = courseID;
//    }

    // Full constructor to reconstruct a student object from the database.
    public Student(int id, String firstName, String lastName, LocalDate dateOfBirth, String login, Integer yearResult, String courseID, Section section) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.login = login;
        this.yearResult = yearResult;
        this.courseID = courseID;
        this.section = section;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        lastName = value;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate value) {
        dateOfBirth = value;
    }

    public String getLogin() {
        return login;
    }

    private void setBaseLogin() {
        login = String.valueOf(this.firstName.charAt(0)).toLowerCase() + this.lastName.substring(0, 7).toLowerCase();
    }

    public Integer getYearResult() {
        return yearResult;
    }

    public void setYearResult(Integer value) {
        yearResult = value;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String value) {
        courseID = value;
    }

    public Section getSection() {
        return section;
    }

    public Integer getSectionID() {
        return section.getId();
    }

    @Override
    public String toString() {
        return "Student{ " +
                "id : " + id +
                ", first name : " + firstName +
                ", last name : " + lastName +
                ", date of birth : " + dateOfBirth +
                ", login : " + login +
                ", year result : " + yearResult +
                ", course id : " + courseID +
                ", section id : " + section.getId() +
                ", section name : " + section.getName() +
                ", section delegate id : " + section.getDelegateID() +
                " }";
    }


}
