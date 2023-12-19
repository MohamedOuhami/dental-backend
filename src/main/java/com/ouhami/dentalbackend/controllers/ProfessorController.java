package com.ouhami.dentalbackend.controllers;

import com.ouhami.dentalbackend.entities.Professor;
import com.ouhami.dentalbackend.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Integer id) {
        Optional<Professor> professor = professorService.getProfessorById(id);
        return professor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Professor> saveProfessor(@RequestBody Professor professor) {
        Professor savedProfessor = professorService.saveProfessor(professor);
        return ResponseEntity.ok(savedProfessor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Integer id) {
        professorService.deleteProfessor(id);
        return ResponseEntity.noContent().build();
    }
}
