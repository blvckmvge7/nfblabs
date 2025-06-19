package com.nfblabs.nfblabs.repository;

import com.nfblabs.nfblabs.model.Inscripcion;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InscripcionRepository {
    private final List<Inscripcion> inscripciones = new ArrayList<>();

    public List<Inscripcion> findAll() {
        return inscripciones;
    }

    public Optional<Inscripcion> findById(Long id) {
        return inscripciones.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public Inscripcion save(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
        return inscripcion;
    }

    public Inscripcion update(Long id, Inscripcion inscripcion) {
        for (int i = 0; i < inscripciones.size(); i++) {
            if (inscripciones.get(i).getId().equals(id)) {
                inscripciones.set(i, inscripcion);
                return inscripcion;
            }
        }
        return null;
    }

    public boolean delete(Long id) {
        return inscripciones.removeIf(i -> i.getId().equals(id));
    }
}