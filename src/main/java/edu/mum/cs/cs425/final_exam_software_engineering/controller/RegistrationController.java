package edu.mum.cs.cs425.final_exam_software_engineering.controller;

import edu.mum.cs.cs425.final_exam_software_engineering.model.Registration;
import edu.mum.cs.cs425.final_exam_software_engineering.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public ResponseEntity<List<Registration>> getAll() {
        return ResponseEntity.ok(registrationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registration> getById(@PathVariable Long id) {
        return ResponseEntity.ok(registrationService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        registrationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}