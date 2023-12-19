package com.ouhami.dentalbackend.services;


import com.ouhami.dentalbackend.entities.Groupe;
import com.ouhami.dentalbackend.repositories.GroupeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupeService {

    @Autowired
    private GroupeRepo groupeRepository;


    public List<Groupe> getAllGroupes() {
        return groupeRepository.findAll();
    }

    public Optional<Groupe> getGroupeById(Integer id) {
        return groupeRepository.findById(id);
    }

    public Groupe saveGroupe(Groupe groupe) {
        return groupeRepository.save(groupe);
    }

    public void deleteGroupe(Integer id) {
        groupeRepository.deleteById(id);
    }
}
