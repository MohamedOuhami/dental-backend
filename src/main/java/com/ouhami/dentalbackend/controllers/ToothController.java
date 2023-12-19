package com.ouhami.dentalbackend.controllers;

import com.ouhami.dentalbackend.entities.Tooth;
import com.ouhami.dentalbackend.services.ToothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tooths")
public class ToothController {

    @Autowired
    private ToothService toothService;

    @GetMapping
    public List<Tooth> getAllTooths() {
        return toothService.getAllTooths();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tooth> getToothById(@PathVariable Integer id) {
        Optional<Tooth> tooth = toothService.getToothById(id);
        return tooth.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tooth> saveTooth(@RequestBody Tooth tooth) {
        Tooth savedTooth = toothService.saveTooth(tooth);
        return ResponseEntity.ok(savedTooth);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTooth(@PathVariable Integer id) {
        toothService.deleteTooth(id);
        return ResponseEntity.noContent().build();
    }
}
