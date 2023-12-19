package com.ouhami.dentalbackend.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Student extends User{
    private String number;

    @ManyToMany
    private List<Groupe> groupes;
}
