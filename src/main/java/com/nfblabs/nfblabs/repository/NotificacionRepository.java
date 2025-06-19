package com.nfblabs.nfblabs.repository;

import com.nfblabs.nfblabs.model.Notificacion;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class NotificacionRepository {
    private final List<Notificacion> notificaciones = new ArrayList<>();

    public List<Notificacion> findAll() {
        return notificaciones;
    }

    public Optional<Notificacion> findById(Long id) {
        return notificaciones.stream().filter(n -> n.getId().equals(id)).findFirst();
    }

    public Notificacion save(Notificacion notificacion) {
        notificaciones.add(notificacion);
        return notificacion;
    }

    public Notificacion update(Long id, Notificacion notificacion) {
        for (int i = 0; i < notificaciones.size(); i++) {
            if (notificaciones.get(i).getId().equals(id)) {
                notificaciones.set(i, notificacion);
                return notificacion;
            }
        }
        return null;
    }

    public boolean delete(Long id) {
        return notificaciones.removeIf(n -> n.getId().equals(id));
    }
}