package com.ouhami.dentalbackend.controllers;

import com.ouhami.dentalbackend.entities.PW;
import com.ouhami.dentalbackend.services.PWService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pws")
public class PWController {

    @Autowired
    private PWService pwService;

    @GetMapping
    public List<PW> getAllPWs() {
        return pwService.getAllPWs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PW> getPWById(@PathVariable Integer id) {
        Optional<PW> pw = pwService.getPWById(id);
        return pw.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PW> savePW(@RequestBody PW pw) {
        PW savedPW = pwService.savePW(pw);
        return ResponseEntity.ok(savedPW);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePW(@PathVariable Integer id) {
        pwService.deletePW(id);
        return ResponseEntity.noContent().build();
    }
}
