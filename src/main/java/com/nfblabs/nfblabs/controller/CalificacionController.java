package com.nfblabs.nfblabs.controller;

import com.nfblabs.nfblabs.model.Calificacion;
import com.nfblabs.nfblabs.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/calificaciones")
public class CalificacionController {
    @Autowired
    private CalificacionService calificacionService;

    @GetMapping
    public List<Calificacion> getAll() {
        return calificacionService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Calificacion> getById(@PathVariable Long id) {
        return calificacionService.findById(id);
    }

    @PostMapping
    public Calificacion create(@RequestBody Calificacion calificacion) {
        return calificacionService.save(calificacion);
    }

    @PutMapping("/{id}")
    public Calificacion update(@PathVariable Long id, @RequestBody Calificacion calificacion) {
        return calificacionService.update(id, calificacion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        calificacionService.delete(id);
    }
}