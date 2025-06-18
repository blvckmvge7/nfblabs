package com.nfblabs.nfblabs.repository;

import com.nfblabs.nfblabs.model.Pregunta;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PreguntaRepository {
    private final List<Pregunta> preguntas = new ArrayList<>();
    public List<Pregunta> findAll() { return preguntas; }
    public Optional<Pregunta> findById(Long id) {
        return preguntas.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
    public Pregunta save(Pregunta pregunta) {
        preguntas.add(pregunta);
        return pregunta;
    }
    public Pregunta update(Long id, Pregunta pregunta) {
        for (int i = 0; i < preguntas.size(); i++) {
            if (preguntas.get(i).getId().equals(id)) {
                preguntas.set(i, pregunta);
                return pregunta;
            }
        }
        return null;
    }
    public boolean delete(Long id) {
        return preguntas.removeIf(p -> p.getId().equals(id));
    }
}