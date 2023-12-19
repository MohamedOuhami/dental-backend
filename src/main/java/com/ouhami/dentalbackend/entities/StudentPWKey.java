package com.ouhami.dentalbackend.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class StudentPWKey implements Serializable {

    @ManyToOne
    private Student student;

    @ManyToOne
    private PW pw;

    public StudentPWKey() {
        // Default constructor is needed for Hibernate
    }

    public StudentPWKey(Student student, PW pw) {
        this.student = student;
        this.pw = pw;
    }

    // Add getters and setters
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public PW getPw() {
        return pw;
    }

    public void setPw(PW pw) {
        this.pw = pw;
    }
}
