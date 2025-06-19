package com.nfblabs.nfblabs.controller;

import com.nfblabs.nfblabs.model.Notificacion;
import com.nfblabs.nfblabs.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {
    @Autowired
    private NotificacionService notificacionService;

    @GetMapping
    public List<Notificacion> getAll() {
        return notificacionService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Notificacion> getById(@PathVariable Long id) {
        return notificacionService.findById(id);
    }

    @PostMapping
    public Notificacion create(@RequestBody Notificacion notificacion) {
        return notificacionService.save(notificacion);
    }

    @PutMapping("/{id}")
    public Notificacion update(@PathVariable Long id, @RequestBody Notificacion notificacion) {
        return notificacionService.update(id, notificacion);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return notificacionService.delete(id);
    }
}