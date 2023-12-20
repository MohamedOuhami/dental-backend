package com.ouhami.dentalbackend.services;


import com.ouhami.dentalbackend.entities.StudentPW;
import com.ouhami.dentalbackend.repositories.StudentPWRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentPWService {

    @Autowired
    private StudentPWRepo studentPWRepository;


    public List<StudentPW> getAllStudentPWs() {
        return studentPWRepository.findAll();
    }

    public Optional<StudentPW> getStudentPWById(Integer id) {
        return studentPWRepository.findById(id);
    }

    public StudentPW saveStudentPW(StudentPW studentPW) {
        return studentPWRepository.save(studentPW);
    }

    public void deleteStudentPW(Integer id) {
        studentPWRepository.deleteById(id);
    }
}
