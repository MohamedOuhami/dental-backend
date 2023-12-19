package com.ouhami.dentalbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ouhami.dentalbackend.entities.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer>{
    
}
