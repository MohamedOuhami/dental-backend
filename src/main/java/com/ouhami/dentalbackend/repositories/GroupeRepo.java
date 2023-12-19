package com.ouhami.dentalbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ouhami.dentalbackend.entities.Groupe;

@Repository
public interface GroupeRepo extends JpaRepository<Groupe,Integer>{
    
}
