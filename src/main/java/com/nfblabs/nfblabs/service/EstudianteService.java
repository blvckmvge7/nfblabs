package com.nfblabs.nfblabs.service;

import com.nfblabs.nfblabs.model.Estudiante;
import com.nfblabs.nfblabs.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    public Estudiante save(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> findById(Long id) {
        return estudianteRepository.findById(id);
    }

    public Estudiante update(Long id, Estudiante estudiante) {
        if (estudianteRepository.existsById(id)) {
            estudiante.setId(id);
            return estudianteRepository.save(estudiante);
        }
        throw new RuntimeException("Estudiante not found with id " + id);
    }

    public void delete(Long id) {
        estudianteRepository.deleteById(id);
    }
}