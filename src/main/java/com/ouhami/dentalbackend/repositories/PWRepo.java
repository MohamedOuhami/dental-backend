package com.ouhami.dentalbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ouhami.dentalbackend.entities.PW;

@Repository
public interface PWRepo extends JpaRepository<PW,Integer>{
    
}
