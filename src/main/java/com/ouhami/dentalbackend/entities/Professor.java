package com.ouhami.dentalbackend.entities;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Professor extends User{

    private String grade;

}
