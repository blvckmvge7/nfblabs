package com.nfblabs.nfblabs.repository;

import com.nfblabs.nfblabs.model.Respuesta;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RespuestaRepository {
    private final List<Respuesta> respuestas = new ArrayList<>();
    public List<Respuesta> findAll() { return respuestas; }
    public Optional<Respuesta> findById(Long id) {
        return respuestas.stream().filter(r -> r.getId().equals(id)).findFirst();
    }
    public Respuesta save(Respuesta respuesta) {
        respuestas.add(respuesta);
        return respuesta;
    }
    public Respuesta update(Long id, Respuesta respuesta) {
        for (int i = 0; i < respuestas.size(); i++) {
            if (respuestas.get(i).getId().equals(id)) {
                respuestas.set(i, respuesta);
                return respuesta;
            }
        }
        return null;
    }
    public boolean delete(Long id) {
        return respuestas.removeIf(r -> r.getId().equals(id));
    }
}