package com.nfblabs.nfblabs.service;

import com.nfblabs.nfblabs.model.Pregunta;
import com.nfblabs.nfblabs.repository.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PreguntaService {
    @Autowired
    private PreguntaRepository preguntaRepository;

    public Pregunta save(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    public List<Pregunta> findAll() {
        return preguntaRepository.findAll();
    }

    public Optional<Pregunta> findById(Long id) {
        return preguntaRepository.findById(id);
    }

    public Pregunta update(Long id, Pregunta pregunta) {
        if (preguntaRepository.existsById(id)) {
            pregunta.setId(id);
            return preguntaRepository.save(pregunta);
        }
        throw new RuntimeException("Pregunta not found with id " + id);
    }

    public void delete(Long id) {
        preguntaRepository.deleteById(id);
    }
}