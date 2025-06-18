package com.nfblabs.nfblabs.repository;

import com.nfblabs.nfblabs.model.Estudiante;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EstudianteRepository {

    private List<Estudiante> estudiantes = new ArrayList<>();

    public List<Estudiante> findAll() {
        return estudiantes;
    }

    public Optional<Estudiante> findById(Long id) {
        return estudiantes.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public Optional<Estudiante> findByIsbn(String isbn) {
        return estudiantes.stream().filter(e -> e.getIsbn().equals(isbn)).findFirst();
    }

    public Estudiante save(Estudiante estudiante) {
        estudiantes.add(estudiante);
        return estudiante;
    }

    public Estudiante update(Long id, Estudiante updatedEstudiante) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getId().equals(id)) {
                estudiantes.set(i, updatedEstudiante);
                return updatedEstudiante;
            }
        }
        return null;
    }

    public boolean deleteById(Long id) {
        return estudiantes.removeIf(e -> e.getId().equals(id));
    }
}
