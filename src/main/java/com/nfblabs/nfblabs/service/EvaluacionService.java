package com.nfblabs.nfblabs.service;

import com.nfblabs.nfblabs.model.Evaluacion;
import com.nfblabs.nfblabs.repository.EvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EvaluacionService {
    @Autowired
    private EvaluacionRepository evaluacionRepository;
    public List<Evaluacion> findAll() { return evaluacionRepository.findAll(); }
    public Optional<Evaluacion> findById(Long id) { return evaluacionRepository.findById(id); }
    public Evaluacion save(Evaluacion evaluacion) { return evaluacionRepository.save(evaluacion); }
    public Evaluacion update(Long id, Evaluacion evaluacion) { return evaluacionRepository.update(id, evaluacion); }
    public boolean delete(Long id) { return evaluacionRepository.delete(id); }
}