package com.ouhami.dentalbackend.services;


import com.ouhami.dentalbackend.entities.Admin;
import com.ouhami.dentalbackend.repositories.AdminRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepository;


    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Integer id) {
        return adminRepository.findById(id);
    }

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public void deleteAdmin(Integer id) {
        adminRepository.deleteById(id);
    }
}
