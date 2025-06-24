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

    public Leccion save(Leccion leccion) {
        return leccionRepository.save(leccion);
    }

    public List<Leccion> findAll() {
        return leccionRepository.findAll();
    }

    public Optional<Leccion> findById(Long id) {
        return leccionRepository.findById(id);
    }

    public Leccion update(Long id, Leccion leccion) {
        if (leccionRepository.existsById(id)) {
            leccion.setId(id);
            return leccionRepository.save(leccion);
        }
        throw new RuntimeException("Leccion not found with id " + id);
    }

    public void delete(Long id) {
        leccionRepository.deleteById(id);
    }
}