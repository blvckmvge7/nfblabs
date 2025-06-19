package com.nfblabs.nfblabs.controller;

import com.nfblabs.nfblabs.model.Pregunta;
import com.nfblabs.nfblabs.service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {
    @Autowired
    private PreguntaService preguntaService;

    @GetMapping
    public List<Pregunta> getAll() { return preguntaService.findAll(); }
    @GetMapping("/{id}")
    public Optional<Pregunta> getById(@PathVariable Long id) { return preguntaService.findById(id); }
    @PostMapping
    public Pregunta create(@RequestBody Pregunta pregunta) { return preguntaService.save(pregunta); }
    @PutMapping("/{id}")
    public Pregunta update(@PathVariable Long id, @RequestBody Pregunta pregunta) { return preguntaService.update(id, pregunta); }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) { return preguntaService.delete(id); }
}