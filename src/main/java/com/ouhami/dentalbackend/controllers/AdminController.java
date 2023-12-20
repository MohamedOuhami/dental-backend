package com.ouhami.dentalbackend.controllers;

import com.ouhami.dentalbackend.entities.Admin;
import com.ouhami.dentalbackend.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public String getAllAdmins(Model model) {
        List<Admin> admins = adminService.getAllAdmins();
        model.addAttribute("admins", admins);
        model.addAttribute("admin", new Admin()); // Add an empty Admin object for the form
        return "/admin/List";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Integer id) {
        Optional<Admin> admin = adminService.getAdminById(id);
        return admin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public String saveAdmin(@ModelAttribute Admin admin) {
        Admin savedAdmin = adminService.saveAdmin(admin);
        // Redirect to the Admin list page after saving
        return "redirect:/admins";
    }

    @PostMapping("/{id}")
    public String deleteAdmin(@PathVariable Integer id) {
        adminService.deleteAdmin(id);
        return "redirect:/admins";
    }
}
