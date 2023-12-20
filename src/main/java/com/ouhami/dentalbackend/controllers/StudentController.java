package com.ouhami.dentalbackend.controllers;

import com.ouhami.dentalbackend.entities.Student;
import com.ouhami.dentalbackend.services.StudentService;

import jakarta.mail.Multipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        model.addAttribute("student", new Student()); // Add an empty Student object for the form
        return "/student/List";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public String saveStudent(@ModelAttribute Student student) {
        Student savedStudent = studentService.saveStudent(student);
        // Redirect to the student list page after saving
        return "redirect:/students";
    }

    @PostMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/image")
    public String checkImage(Model model) {
        
        return "image";
    }

    @PostMapping("/imageProcessing")
    public String processImage(@RequestParam("file") MultipartFile file, Model model,
            RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please, select a proper image to process");
            return "redirect:/students/image";
        }

        try {
            String uploadFolder = "src/main/resources/static/images/";
            Path uploadPath = Paths.get(uploadFolder);
            Path filePath = uploadPath.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            String inputFilePath = filePath.toString(); // Path to the saved uploaded image
            String outputFilePath = "src/main/resources/static/images/processed_image.jpg"; // Set the correct output path
                                                                // output path

            String pythonScriptPath = "src/main/java/com/ouhami/dentalbackend/controllers/image_processing.py";
            System.out.println("Starting the processing");

            ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScriptPath, inputFilePath,
                    outputFilePath);
            processBuilder.redirectErrorStream(true); // Redirect the error stream to the output stream

            Process process = processBuilder.start();
            process.waitFor();

            // Read the output from the process
            java.util.Scanner s = new java.util.Scanner(process.getInputStream()).useDelimiter("\\A");
            String output = s.hasNext() ? s.next() : "";

            System.out.println("Script output: " + output);

            model.addAttribute("ProcessedImage", outputFilePath);
            model.addAttribute("original_image", inputFilePath);

        } catch (Exception err) {
            err.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Failed to process the image");
            return "redirect:/students/image";
        }

        return "imageProcessed";
    }

}
