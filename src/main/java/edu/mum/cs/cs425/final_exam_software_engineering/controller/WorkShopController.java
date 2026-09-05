package edu.mum.cs.cs425.final_exam_software_engineering.controller;

import edu.mum.cs.cs425.final_exam_software_engineering.model.Registration;
import edu.mum.cs.cs425.final_exam_software_engineering.model.WorkShop;
import edu.mum.cs.cs425.final_exam_software_engineering.service.RegistrationService;
import edu.mum.cs.cs425.final_exam_software_engineering.service.WorkShopService;
import edu.mum.cs.cs425.final_exam_software_engineering.service.impl.RegistrationServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workShops")
public class WorkShopController {

    private final WorkShopService workShopService;
    private final RegistrationService registrationService;

    @Autowired
    public WorkShopController(WorkShopService workShopService, RegistrationServiceImpl registrationService) {
        this.workShopService = workShopService;
        this.registrationService = registrationService;
    }

    @GetMapping
    public ResponseEntity<List<WorkShop>> getAll() {
        return ResponseEntity.ok(workShopService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkShop> getById(@PathVariable Long id) {
        return ResponseEntity.ok(workShopService.findById(id));
    }

    @PostMapping
    public ResponseEntity<WorkShop> create(@Valid @RequestBody WorkShop workShop) {
        return ResponseEntity.status(HttpStatus.CREATED).body(workShopService.save(workShop));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkShop> update(@PathVariable Long id, @Valid @RequestBody WorkShop workShop) {
        workShopService.findById(id);
        workShop.setWorkShopId(id);
        return ResponseEntity.ok(workShopService.save(workShop));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        workShopService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/add-registration")
    public ResponseEntity<Registration> addRegistration(@PathVariable Long id, @Valid @RequestBody Registration registration) {
        return ResponseEntity.ok(registrationService.registerWorkShop(id, registration));
    }

    @PostMapping("/{id}/registations")
    public ResponseEntity<List<Registration>> getRegistrations(@PathVariable Long id) {
        return ResponseEntity.ok(registrationService.findAllByWorkShop(id));
    }
}