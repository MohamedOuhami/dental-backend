package com.ouhami.dentalbackend.services;


import com.ouhami.dentalbackend.entities.PW;
import com.ouhami.dentalbackend.repositories.PWRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PWService {

    @Autowired
    private PWRepo pwRepository;


    public List<PW> getAllPWs() {
        return pwRepository.findAll();
    }

    public Optional<PW> getPWById(Integer id) {
        return pwRepository.findById(id);
    }

    public PW savePW(PW pw) {
        return pwRepository.save(pw);
    }

    public void deletePW(Integer id) {
        pwRepository.deleteById(id);
    }
}
