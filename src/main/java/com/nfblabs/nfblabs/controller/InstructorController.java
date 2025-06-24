package com.nfblabs.nfblabs.controller;

import com.nfblabs.nfblabs.model.Instructor;
import com.nfblabs.nfblabs.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instructores")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public List<Instructor> getAll() {
        return instructorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Instructor> getById(@PathVariable Long id) {
        return instructorService.findById(id);
    }

    @PostMapping
    public Instructor create(@RequestBody Instructor instructor) {
        return instructorService.save(instructor);
    }

    @PutMapping("/{id}")
    public Instructor update(@PathVariable Long id, @RequestBody Instructor instructor) {
        return instructorService.update(id, instructor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        instructorService.delete(id);
    }
}