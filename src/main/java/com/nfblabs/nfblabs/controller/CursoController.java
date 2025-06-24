package com.nfblabs.nfblabs.controller;

import com.nfblabs.nfblabs.model.Curso;
import com.nfblabs.nfblabs.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> getAll() {
        return cursoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Curso> getById(@PathVariable Long id) {
        return cursoService.findById(id);
    }

    @PostMapping
    public Curso create(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }

    @PutMapping("/{id}")
    public Curso update(@PathVariable Long id, @RequestBody Curso curso) {
        return cursoService.update(id, curso);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cursoService.delete(id);
    }
}