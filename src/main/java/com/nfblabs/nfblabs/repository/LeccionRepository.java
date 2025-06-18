package com.nfblabs.nfblabs.repository;


import com.nfblabs.nfblabs.model.Leccion;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LeccionRepository {
    private final List<Leccion> lecciones = new ArrayList<>();
    public List<Leccion> findAll() { return lecciones; }
    public Optional<Leccion> findById(Long id) {
        return lecciones.stream().filter(l -> l.getId().equals(id)).findFirst();
    }
    public Leccion save(Leccion leccion) {
        lecciones.add(leccion);
        return leccion;
    }
    public Leccion update(Long id, Leccion leccion) {
        for (int i = 0; i < lecciones.size(); i++) {
            if (lecciones.get(i).getId().equals(id)) {
                lecciones.set(i, leccion);
                return leccion;
            }
        }
        return null;
    }
    public boolean delete(Long id) {
        return lecciones.removeIf(l -> l.getId().equals(id));
    }
}