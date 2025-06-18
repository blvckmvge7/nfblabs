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
    public List<Pregunta> findAll() { return preguntaRepository.findAll(); }
    public Optional<Pregunta> findById(Long id) { return preguntaRepository.findById(id); }
    public Pregunta save(Pregunta pregunta) { return preguntaRepository.save(pregunta); }
    public Pregunta update(Long id, Pregunta pregunta) { return preguntaRepository.update(id, pregunta); }
    public boolean delete(Long id) { return preguntaRepository.delete(id); }
}