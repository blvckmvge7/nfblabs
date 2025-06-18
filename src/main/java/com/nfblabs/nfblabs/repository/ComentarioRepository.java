package com.nfblabs.nfblabs.repository;

import com.nfblabs.nfblabs.model.Comentario;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ComentarioRepository {
    private final List<Comentario> comentarios = new ArrayList<>();
    public List<Comentario> findAll() { return comentarios; }
    public Optional<Comentario> findById(Long id) {
        return comentarios.stream().filter(c -> c.getId().equals(id)).findFirst();
    }
    public Comentario save(Comentario comentario) {
        comentarios.add(comentario);
        return comentario;
    }
    public Comentario update(Long id, Comentario comentario) {
        for (int i = 0; i < comentarios.size(); i++) {
            if (comentarios.get(i).getId().equals(id)) {
                comentarios.set(i, comentario);
                return comentario;
            }
        }
        return null;
    }
    public boolean delete(Long id) {
        return comentarios.removeIf(c -> c.getId().equals(id));
    }
}