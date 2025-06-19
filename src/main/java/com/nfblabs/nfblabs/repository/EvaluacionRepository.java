package com.nfblabs.nfblabs.repository;

import com.nfblabs.nfblabs.model.Evaluacion;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EvaluacionRepository {
    private final List<Evaluacion> evaluaciones = new ArrayList<>();

    public List<Evaluacion> findAll() {
        return evaluaciones;
    }

    public Optional<Evaluacion> findById(Long id) {
        return evaluaciones.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public Evaluacion save(Evaluacion evaluacion) {
        evaluaciones.add(evaluacion);
        return evaluacion;
    }

    public Evaluacion update(Long id, Evaluacion evaluacion) {
        for (int i = 0; i < evaluaciones.size(); i++) {
            if (evaluaciones.get(i).getId().equals(id)) {
                evaluaciones.set(i, evaluacion);
                return evaluacion;
            }
        }
        return null;
    }

    public boolean delete(Long id) {
        return evaluaciones.removeIf(e -> e.getId().equals(id));
    }
}