package com.nfblabs.nfblabs.controller;

import com.nfblabs.nfblabs.model.Categoria;
import com.nfblabs.nfblabs.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAll() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> getById(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    @GetMapping("/nombre/{nombre}")
    public Optional<Categoria> getByNombre(@PathVariable String nombre) {
        return categoriaService.findByNombre(nombre);
    }

    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    @PutMapping("/{id}")
    public Categoria update(@PathVariable Long id, @RequestBody Categoria categoria) {
        return categoriaService.update(id, categoria);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return categoriaService.delete(id);
    }
}