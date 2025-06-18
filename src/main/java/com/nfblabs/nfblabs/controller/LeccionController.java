package com.nfblabs.nfblabs.controller;

import com.nfblabs.nfblabs.model.Leccion;
import com.nfblabs.nfblabs.service.LeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lecciones")
public class LeccionController {
    @Autowired
    private LeccionService leccionService;

    @GetMapping
    public List<Leccion> getAll() { return leccionService.findAll(); }
    @GetMapping("/{id}")
    public Optional<Leccion> getById(@PathVariable Long id) { return leccionService.findById(id); }
    @PostMapping
    public Leccion create(@RequestBody Leccion leccion) { return leccionService.save(leccion); }
    @PutMapping("/{id}")
    public Leccion update(@PathVariable Long id, @RequestBody Leccion leccion) { return leccionService.update(id, leccion); }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) { return leccionService.delete(id); }
}