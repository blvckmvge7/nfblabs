package com.nfblabs.nfblabs.controller;

import com.nfblabs.nfblabs.model.Comentario;
import com.nfblabs.nfblabs.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comentarios")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    public List<Comentario> getAll() { return comentarioService.findAll(); }
    @GetMapping("/{id}")
    public Optional<Comentario> getById(@PathVariable Long id) { return comentarioService.findById(id); }
    @PostMapping
    public Comentario create(@RequestBody Comentario comentario) { return comentarioService.save(comentario); }
    @PutMapping("/{id}")
    public Comentario update(@PathVariable Long id, @RequestBody Comentario comentario) { return comentarioService.update(id, comentario); }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) { return comentarioService.delete(id); }
}