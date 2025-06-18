package com.nfblabs.nfblabs.controller;

import com.nfblabs.nfblabs.model.Modulo;
import com.nfblabs.nfblabs.service.ModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/modulos")
public class ModuloController {
    @Autowired
    private ModuloService moduloService;

    @GetMapping
    public List<Modulo> getAll() { return moduloService.findAll(); }
    @GetMapping("/{id}")
    public Optional<Modulo> getById(@PathVariable Long id) { return moduloService.findById(id); }
    @PostMapping
    public Modulo create(@RequestBody Modulo modulo) { return moduloService.save(modulo); }
    @PutMapping("/{id}")
    public Modulo update(@PathVariable Long id, @RequestBody Modulo modulo) { return moduloService.update(id, modulo); }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) { return moduloService.delete(id); }
}