package com.nfblabs.nfblabs.controller;

import com.nfblabs.nfblabs.model.Estudiante;
import com.nfblabs.nfblabs.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<Estudiante> getAll() {
        return estudianteService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Estudiante> getById(@PathVariable Long id) {
        return estudianteService.findById(id);
    }

    @PostMapping
    public Estudiante create(@RequestBody Estudiante estudiante) {
        return estudianteService.save(estudiante);
    }

    @PutMapping("/{id}")
    public Estudiante update(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        return estudianteService.update(id, estudiante);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        estudianteService.delete(id);
    }
}