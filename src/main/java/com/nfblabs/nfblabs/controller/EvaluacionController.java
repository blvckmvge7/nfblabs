package com.nfblabs.nfblabs.controller;

import com.nfblabs.nfblabs.model.Evaluacion;
import com.nfblabs.nfblabs.service.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {
    @Autowired
    private EvaluacionService evaluacionService;

    @GetMapping
    public List<Evaluacion> getAll() { return evaluacionService.findAll(); }
    @GetMapping("/{id}")
    public Optional<Evaluacion> getById(@PathVariable Long id) { return evaluacionService.findById(id); }
    @PostMapping
    public Evaluacion create(@RequestBody Evaluacion evaluacion) { return evaluacionService.save(evaluacion); }
    @PutMapping("/{id}")
    public Evaluacion update(@PathVariable Long id, @RequestBody Evaluacion evaluacion) { return evaluacionService.update(id, evaluacion); }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) { return evaluacionService.delete(id); }
}