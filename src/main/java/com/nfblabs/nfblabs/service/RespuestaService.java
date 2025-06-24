package com.nfblabs.nfblabs.service;

import com.nfblabs.nfblabs.model.Respuesta;
import com.nfblabs.nfblabs.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RespuestaService {
    @Autowired
    private RespuestaRepository respuestaRepository;

    public Respuesta save(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    public List<Respuesta> findAll() {
        return respuestaRepository.findAll();
    }

    public Optional<Respuesta> findById(Long id) {
        return respuestaRepository.findById(id);
    }

    public Respuesta update(Long id, Respuesta respuesta) {
        if (respuestaRepository.existsById(id)) {
            respuesta.setId(id);
            return respuestaRepository.save(respuesta);
        }
        throw new RuntimeException("Respuesta not found with id " + id);
    }

    public void delete(Long id) {
        respuestaRepository.deleteById(id);
    }
}