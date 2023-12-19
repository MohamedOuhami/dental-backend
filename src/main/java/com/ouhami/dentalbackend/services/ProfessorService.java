package com.ouhami.dentalbackend.services;


import com.ouhami.dentalbackend.entities.Professor;
import com.ouhami.dentalbackend.repositories.ProfessorRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepo professorRepository;


    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    public Optional<Professor> getProfessorById(Integer id) {
        return professorRepository.findById(id);
    }

    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public void deleteProfessor(Integer id) {
        professorRepository.deleteById(id);
    }
}
