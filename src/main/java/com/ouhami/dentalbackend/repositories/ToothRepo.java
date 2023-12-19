package com.ouhami.dentalbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ouhami.dentalbackend.entities.Tooth;

@Repository
public interface ToothRepo extends JpaRepository<Tooth,Integer>{
    
}
