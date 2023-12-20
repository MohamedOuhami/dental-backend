package com.ouhami.dentalbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ouhami.dentalbackend.entities.StudentPW;

public interface StudentPWRepo extends JpaRepository<StudentPW,Integer> {
    
}
