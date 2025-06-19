package com.nfblabs.nfblabs.controller;

import com.nfblabs.nfblabs.model.Pago;
import com.nfblabs.nfblabs.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {
    @Autowired
    private PagoService pagoService;

    @GetMapping
    public List<Pago> getAll() { return pagoService.findAll(); }
    @GetMapping("/{id}")
    public Optional<Pago> getById(@PathVariable Long id) { return pagoService.findById(id); }
    @PostMapping
    public Pago create(@RequestBody Pago pago) { return pagoService.save(pago); }
    @PutMapping("/{id}")
    public Pago update(@PathVariable Long id, @RequestBody Pago pago) { return pagoService.update(id, pago); }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) { return pagoService.delete(id); }
}