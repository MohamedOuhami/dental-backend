package com.ouhami.dentalbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String photo;
    
}
