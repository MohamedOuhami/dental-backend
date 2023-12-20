package com.ouhami.dentalbackend.controllers;

import com.ouhami.dentalbackend.entities.Tooth;
import com.ouhami.dentalbackend.services.ToothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tooths")
public class ToothController {

    @Autowired
    private ToothService toothService;

    @GetMapping
    public String getAllTooths(Model model) {
        List<Tooth> teeth = toothService.getAllTooths();
        model.addAttribute("tooths", teeth);
        model.addAttribute("tooth", new Tooth()); // Add an empty Tooth object for the form
        return "/tooth/List";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tooth> getToothById(@PathVariable Integer id) {
        Optional<Tooth> tooth = toothService.getToothById(id);
        return tooth.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public String saveTooth(@ModelAttribute Tooth tooth) {
        Tooth savedTooth = toothService.saveTooth(tooth);
        // Redirect to the tooth list page after saving
        return "redirect:/tooths";
    }

    @PostMapping("/{id}")
    public String deleteTooth(@PathVariable Integer id) {
        toothService.deleteTooth(id);
        return "redirect:/tooths";
    }
}
