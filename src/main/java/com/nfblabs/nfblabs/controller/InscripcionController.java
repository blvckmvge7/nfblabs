package com.nfblabs.nfblabs.controller;

import com.nfblabs.nfblabs.model.Inscripcion;
import com.nfblabs.nfblabs.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping
    public List<Inscripcion> getAll() {
        return inscripcionService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Inscripcion> getById(@PathVariable Long id) {
        return inscripcionService.findById(id);
    }

    @PostMapping
    public Inscripcion create(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.save(inscripcion);
    }

    @PutMapping("/{id}")
    public Inscripcion update(@PathVariable Long id, @RequestBody Inscripcion inscripcion) {
        return inscripcionService.update(id, inscripcion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        inscripcionService.delete(id);
    }
}