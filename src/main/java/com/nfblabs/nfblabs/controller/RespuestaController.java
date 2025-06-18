package com.nfblabs.nfblabs.controller;

import com.nfblabs.nfblabs.model.Respuesta;
import com.nfblabs.nfblabs.service.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {
    @Autowired
    private RespuestaService respuestaService;

    @GetMapping
    public List<Respuesta> getAll() { return respuestaService.findAll(); }
    @GetMapping("/{id}")
    public Optional<Respuesta> getById(@PathVariable Long id) { return respuestaService.findById(id); }
    @PostMapping
    public Respuesta create(@RequestBody Respuesta respuesta) { return respuestaService.save(respuesta); }
    @PutMapping("/{id}")
    public Respuesta update(@PathVariable Long id, @RequestBody Respuesta respuesta) { return respuestaService.update(id, respuesta); }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) { return respuestaService.delete(id); }
}