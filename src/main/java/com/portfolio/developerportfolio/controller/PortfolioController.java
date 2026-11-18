package com.portfolio.developerportfolio.controller;

import com.portfolio.developerportfolio.model.ContactMessage;
import com.portfolio.developerportfolio.model.PortfolioProject;
import com.portfolio.developerportfolio.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PortfolioController {

    private final ContactService contactService;

    public PortfolioController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/")
    public String home(@RequestParam(name = "sent", defaultValue = "false") boolean sent, Model model) {
        model.addAttribute("contactForm", new ContactMessage());
        model.addAttribute("sent", sent);
        addProjects(model);
        return "index";
    }

    @PostMapping("/contact")
    public String submitContact(
            @Valid @ModelAttribute("contactForm") ContactMessage contactForm,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("sent", false);
            addProjects(model);
            return "index";
        }

        contactService.submit(contactForm);
        return "redirect:/?sent=true#contact";
    }

    private void addProjects(Model model) {
        List<PortfolioProject> projects = List.of(
                new PortfolioProject(
                        "01", "JAVA APPLICATION", "School Management System",
                        "A desktop application for managing students, teachers, courses, subjects and academic records with role-based access.",
                        List.of("Java", "JavaFX", "MySQL"),
                        "https://github.com/yourusername/school-management-system", ""),
                new PortfolioProject(
                        "02", "COMPUTER GRAPHICS", "Cyberpunk Train Cabin Simulator",
                        "A 3D neon train-cabin environment featuring camera movement, lighting, transformations and an animated night scene.",
                        List.of("C++", "OpenGL", "FreeGLUT"),
                        "https://github.com/yourusername/cyberpunk-train-cabin", ""),
                new PortfolioProject(
                        "03", "WEB DEVELOPMENT", "Developer Portfolio",
                        "A responsive personal portfolio built with Spring Boot, Thymeleaf and Bootstrap, prepared for Docker-based deployment.",
                        List.of("Java 21", "Spring Boot", "Thymeleaf", "Docker"),
                        "https://github.com/yourusername/developer-portfolio", "")
        );
        model.addAttribute("projects", projects);
    }
}
