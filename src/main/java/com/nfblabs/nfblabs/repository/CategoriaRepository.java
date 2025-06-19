package com.nfblabs.nfblabs.repository;

import com.nfblabs.nfblabs.model.Categoria;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository {
    private final List<Categoria> categorias = new ArrayList<>();

    public List<Categoria> findAll() {
        return categorias;
    }

    public Optional<Categoria> findById(Long id) {
        return categorias.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Optional<Categoria> findByNombre(String nombre) {
        return categorias.stream().filter(c -> c.getNombre().equals(nombre)).findFirst();
    }

    public Categoria save(Categoria categoria) {
        categorias.add(categoria);
        return categoria;
    }

    public Categoria update(Long id, Categoria categoria) {
        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).getId().equals(id)) {
                categorias.set(i, categoria);
                return categoria;
            }
        }
        return null;
    }

    public boolean delete(Long id) {
        return categorias.removeIf(c -> c.getId().equals(id));
    }
}