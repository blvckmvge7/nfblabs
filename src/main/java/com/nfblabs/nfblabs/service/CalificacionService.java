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
    public List<Calificacion> findAll() { return calificacionRepository.findAll(); }
    public Optional<Calificacion> findById(Long id) { return calificacionRepository.findById(id); }
    public Calificacion save(Calificacion calificacion) { return calificacionRepository.save(calificacion); }
    public Calificacion update(Long id, Calificacion calificacion) { return calificacionRepository.update(id, calificacion); }
    public boolean delete(Long id) { return calificacionRepository.delete(id); }
}