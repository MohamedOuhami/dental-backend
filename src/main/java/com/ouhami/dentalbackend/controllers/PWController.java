package com.ouhami.dentalbackend.controllers;

import com.ouhami.dentalbackend.entities.PW;
import com.ouhami.dentalbackend.services.PWService;
import com.ouhami.dentalbackend.services.ToothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pws")
public class PWController {

    @Autowired
    private PWService pwService;

    @Autowired
    private ToothService toothService;

    @GetMapping
    public String getAllPWs(Model model) {
        List<PW> pws = pwService.getAllPWs();
        model.addAttribute("pws", pws);
        model.addAttribute("pw", new PW()); // Add an empty PW object for the form
        model.addAttribute("teeth", toothService.getAllTooths()); // Add a list of teeth for the form
        return "/pw/List";
    }

    @GetMapping("/{id}")
    public String getPWById(@PathVariable Integer id, Model model) {
        Optional<PW> pw = pwService.getPWById(id);
        pw.ifPresent(value -> model.addAttribute("pw", value));
        return "/pw/List";
    }

    @PostMapping
    public String savePW(@ModelAttribute PW pw, RedirectAttributes redirectAttributes) {
        PW savedPW = pwService.savePW(pw);
        // Redirect to the PW list page after saving
        redirectAttributes.addFlashAttribute("message", "PW saved successfully!");
        return "redirect:/pws";
    }

    @PostMapping("/{id}")
    public String deletePW(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        pwService.deletePW(id);
        redirectAttributes.addFlashAttribute("message", "PW deleted successfully!");
        return "redirect:/pws";
    }
}
