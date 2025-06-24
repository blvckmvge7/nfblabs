package com.nfblabs.nfblabs.service;

import com.nfblabs.nfblabs.model.Calificacion;
import com.nfblabs.nfblabs.repository.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CalificacionService {
    @Autowired
    private CalificacionRepository calificacionRepository;

    public Calificacion save(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    public List<Calificacion> findAll() {
        return calificacionRepository.findAll();
    }

    public Optional<Calificacion> findById(Long id) {
        return calificacionRepository.findById(id);
    }

    public Calificacion update(Long id, Calificacion calificacion) {
        if (calificacionRepository.existsById(id)) {
            calificacion.setId(id);
            return calificacionRepository.save(calificacion);
        }
        throw new RuntimeException("Calificacion not found with id " + id);
    }

    public void delete(Long id) {
        calificacionRepository.deleteById(id);
    }
}