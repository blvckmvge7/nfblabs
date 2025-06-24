package com.nfblabs.nfblabs.service;

import com.nfblabs.nfblabs.model.Inscripcion;
import com.nfblabs.nfblabs.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InscripcionService {
    @Autowired
    private InscripcionRepository inscripcionRepository;

    public Inscripcion save(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    public List<Inscripcion> findAll() {
        return inscripcionRepository.findAll();
    }

    public Optional<Inscripcion> findById(Long id) {
        return inscripcionRepository.findById(id);
    }

    public Inscripcion update(Long id, Inscripcion inscripcion) {
        if (inscripcionRepository.existsById(id)) {
            inscripcion.setId(id);
            return inscripcionRepository.save(inscripcion);
        }
        throw new RuntimeException("Inscripcion not found with id " + id);
    }

    public void delete(Long id) {
        inscripcionRepository.deleteById(id);
    }
}