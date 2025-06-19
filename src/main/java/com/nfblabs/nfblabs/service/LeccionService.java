package com.nfblabs.nfblabs.service;

import com.nfblabs.nfblabs.model.Leccion;
import com.nfblabs.nfblabs.repository.LeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LeccionService {
    @Autowired
    private LeccionRepository leccionRepository;
    public List<Leccion> findAll() { return leccionRepository.findAll(); }
    public Optional<Leccion> findById(Long id) { return leccionRepository.findById(id); }
    public Leccion save(Leccion leccion) { return leccionRepository.save(leccion); }
    public Leccion update(Long id, Leccion leccion) { return leccionRepository.update(id, leccion); }
    public boolean delete(Long id) { return leccionRepository.delete(id); }
}