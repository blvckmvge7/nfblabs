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
    private InstructorService service;

    @GetMapping
    public List<Instructor> obtenerTodos() {
        return service.getAllInstructores();
    }

    @GetMapping("/{id}")
    public Optional<Instructor> obtenerPorId(@PathVariable Long id) {
        return service.getInstructorById(id);
    }

    @PostMapping
    public Instructor crear(@RequestBody Instructor instructor) {
        return service.saveInstructor(instructor);
    }

    @PutMapping("/{id}")
    public Instructor actualizar(@PathVariable Long id, @RequestBody Instructor instructor) {
        return service.updateInstructor(id, instructor);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        boolean eliminado = service.deleteInstructor(id);
        return eliminado ? "Instructor eliminado" : "Instructor no encontrado";
    }
}
