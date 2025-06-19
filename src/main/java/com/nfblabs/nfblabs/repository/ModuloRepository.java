package com.nfblabs.nfblabs.repository;

import com.nfblabs.nfblabs.model.Modulo;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ModuloRepository {
    private final List<Modulo> modulos = new ArrayList<>();
    public List<Modulo> findAll() { return modulos; }
    public Optional<Modulo> findById(Long id) {
        return modulos.stream().filter(m -> m.getId().equals(id)).findFirst();
    }
    public Modulo save(Modulo modulo) {
        modulos.add(modulo);
        return modulo;
    }
    public Modulo update(Long id, Modulo modulo) {
        for (int i = 0; i < modulos.size(); i++) {
            if (modulos.get(i).getId().equals(id)) {
                modulos.set(i, modulo);
                return modulo;
            }
        }
        return null;
    }
    public boolean delete(Long id) {
        return modulos.removeIf(m -> m.getId().equals(id));
    }
}