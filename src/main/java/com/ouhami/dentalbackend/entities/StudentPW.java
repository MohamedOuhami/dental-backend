package com.ouhami.dentalbackend.entities;

import java.time.LocalDate;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class StudentPW {
    
    @EmbeddedId
    private StudentPWKey id;

    private String time;
    private String imageFront;
    private String imageSide;
    private LocalDate date;
}
