package com.ouhami.dentalbackend.controllers;

import com.ouhami.dentalbackend.entities.Professor;
import com.ouhami.dentalbackend.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public String getAllProfessors(Model model) {
        List<Professor> professors = professorService.getAllProfessors();
        model.addAttribute("professors", professors);
        model.addAttribute("professor", new Professor()); // Add an empty Professor object for the form
        return "/professor/List";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Integer id) {
        Optional<Professor> professor = professorService.getProfessorById(id);
        return professor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public String saveProfessor(@ModelAttribute Professor professor) {
        Professor savedProfessor = professorService.saveProfessor(professor);
        // Redirect to the professor list page after saving
        return "redirect:/professors";
    }

    @PostMapping("/{id}")
    public String deleteProfessor(@PathVariable Integer id) {
        professorService.deleteProfessor(id);
        return "redirect:/professors";
    }
}
