package com.ouhami.dentalbackend.services;


import com.ouhami.dentalbackend.entities.Tooth;
import com.ouhami.dentalbackend.repositories.ToothRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToothService {

    @Autowired
    private ToothRepo toothRepository;


    public List<Tooth> getAllTooths() {
        return toothRepository.findAll();
    }

    public Optional<Tooth> getToothById(Integer id) {
        return toothRepository.findById(id);
    }

    public Tooth saveTooth(Tooth tooth) {
        return toothRepository.save(tooth);
    }

    public void deleteTooth(Integer id) {
        toothRepository.deleteById(id);
    }
}
