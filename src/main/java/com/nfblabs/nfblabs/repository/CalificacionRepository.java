package com.nfblabs.nfblabs.repository;


import com.nfblabs.nfblabs.model.Calificacion;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CalificacionRepository {
    private final List<Calificacion> calificaciones = new ArrayList<>();
    public List<Calificacion> findAll() { return calificaciones; }
    public Optional<Calificacion> findById(Long id) {
        return calificaciones.stream().filter(c -> c.getId().equals(id)).findFirst();
    }
    public Calificacion save(Calificacion calificacion) {
        calificaciones.add(calificacion);
        return calificacion;
    }
    public Calificacion update(Long id, Calificacion calificacion) {
        for (int i = 0; i < calificaciones.size(); i++) {
            if (calificaciones.get(i).getId().equals(id)) {
                calificaciones.set(i, calificacion);
                return calificacion;
            }
        }
        return null;
    }
    public boolean delete(Long id) {
        return calificaciones.removeIf(c -> c.getId().equals(id));
    }
}