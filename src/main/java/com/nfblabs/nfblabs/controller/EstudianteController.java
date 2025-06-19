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
    private EstudianteService service;

    @GetMapping
    public List<Estudiante> obtenerTodos() {
        return service.getAllEstudiantes();
    }

    @GetMapping("/{id}")
    public Optional<Estudiante> obtenerPorId(@PathVariable Long id) {
        return service.getEstudianteById(id);
    }

    @PostMapping
    public Estudiante crear(@RequestBody Estudiante estudiante) {
        return service.saveEstudiante(estudiante);
    }

    @PutMapping("/{id}")
    public Estudiante actualizar(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        return service.updateEstudiante(id, estudiante);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        boolean eliminado = service.deleteEstudiante(id);
        return eliminado ? "Estudiante eliminado" : "Estudiante no encontrado";
    }
}
