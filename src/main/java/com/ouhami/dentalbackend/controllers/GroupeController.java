package com.ouhami.dentalbackend.controllers;

import com.ouhami.dentalbackend.entities.Groupe;
import com.ouhami.dentalbackend.services.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/groupes")
public class GroupeController {

    @Autowired
    private GroupeService groupeService;

    @GetMapping
    public List<Groupe> getAllGroupes() {
        return groupeService.getAllGroupes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Groupe> getGroupeById(@PathVariable Integer id) {
        Optional<Groupe> groupe = groupeService.getGroupeById(id);
        return groupe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Groupe> saveGroupe(@RequestBody Groupe groupe) {
        Groupe savedGroupe = groupeService.saveGroupe(groupe);
        return ResponseEntity.ok(savedGroupe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroupe(@PathVariable Integer id) {
        groupeService.deleteGroupe(id);
        return ResponseEntity.noContent().build();
    }
}
