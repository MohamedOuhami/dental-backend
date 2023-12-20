package com.ouhami.dentalbackend.controllers;

import com.ouhami.dentalbackend.entities.StudentPW;
import com.ouhami.dentalbackend.services.StudentPWService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/studentPWs")
public class StudentPWController {

    @Autowired
    private StudentPWService studentPWService;

    @GetMapping
    public String getAllStudentPWs(Model model) {
        List<StudentPW> studentPWs = studentPWService.getAllStudentPWs();
        model.addAttribute("studentPWs", studentPWs);
        model.addAttribute("studentPW", new StudentPW()); // Add an empty StudentPW object for the form
        return "/studentPW/List";
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentPW> getStudentPWById(@PathVariable Integer id) {
        Optional<StudentPW> studentPW = studentPWService.getStudentPWById(id);
        return studentPW.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public String saveStudentPW(@ModelAttribute StudentPW studentPW) {
        StudentPW savedStudentPW = studentPWService.saveStudentPW(studentPW);
        // Redirect to the StudentPW list page after saving
        return "redirect:/studentPWs";
    }

    @PostMapping("/{id}")
    public String deleteStudentPW(@PathVariable Integer id) {
        studentPWService.deleteStudentPW(id);
        return "redirect:/studentPWs";
    }
}
