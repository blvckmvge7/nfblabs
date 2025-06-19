package com.nfblabs.nfblabs.controller;

import com.nfblabs.nfblabs.model.Certificado;
import com.nfblabs.nfblabs.service.CertificadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/certificados")
public class CertificadoController {
    @Autowired
    private CertificadoService certificadoService;

    @GetMapping
    public List<Certificado> getAll() { return certificadoService.findAll(); }
    @GetMapping("/{id}")
    public Optional<Certificado> getById(@PathVariable Long id) { return certificadoService.findById(id); }
    @PostMapping
    public Certificado create(@RequestBody Certificado certificado) { return certificadoService.save(certificado); }
    @PutMapping("/{id}")
    public Certificado update(@PathVariable Long id, @RequestBody Certificado certificado) { return certificadoService.update(id, certificado); }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) { return certificadoService.delete(id); }
}