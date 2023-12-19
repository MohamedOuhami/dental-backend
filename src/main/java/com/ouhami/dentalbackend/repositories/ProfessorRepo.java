package com.ouhami.dentalbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ouhami.dentalbackend.entities.Professor;

@Repository
public interface ProfessorRepo extends JpaRepository<Professor,Integer>{
    
}
