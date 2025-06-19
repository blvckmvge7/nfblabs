package com.nfblabs.nfblabs.service;

import com.nfblabs.nfblabs.model.Notificacion;
import com.nfblabs.nfblabs.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NotificacionService {
    @Autowired
    private NotificacionRepository notificacionRepository;

    public List<Notificacion> findAll() {
        return notificacionRepository.findAll();
    }

    public Optional<Notificacion> findById(Long id) {
        return notificacionRepository.findById(id);
    }

    public Notificacion save(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public Notificacion update(Long id, Notificacion notificacion) {
        return notificacionRepository.update(id, notificacion);
    }

    public boolean delete(Long id) {
        return notificacionRepository.delete(id);
    }
}