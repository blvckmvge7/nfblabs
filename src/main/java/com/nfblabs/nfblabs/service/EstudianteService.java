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
    private EstudianteRepository repository;

    public List<Estudiante> getAllEstudiantes() {
        return repository.findAll();
    }

    public Optional<Estudiante> getEstudianteById(Long id) {
        return repository.findById(id);
    }

    public Estudiante saveEstudiante(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    public Estudiante updateEstudiante(Long id, Estudiante estudiante) {
        return repository.update(id, estudiante);
    }

    public boolean deleteEstudiante(Long id) {
        return repository.deleteById(id);
    }
}
