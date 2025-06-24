package com.nfblabs.nfblabs.service;

import com.nfblabs.nfblabs.model.Comentario;
import com.nfblabs.nfblabs.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;

    public Comentario save(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> findAll() {
        return comentarioRepository.findAll();
    }

    public Optional<Comentario> findById(Long id) {
        return comentarioRepository.findById(id);
    }

    public Comentario update(Long id, Comentario comentario) {
        if (comentarioRepository.existsById(id)) {
            comentario.setId(id);
            return comentarioRepository.save(comentario);
        }
        throw new RuntimeException("Comentario not found with id " + id);
    }

    public void delete(Long id) {
        comentarioRepository.deleteById(id);
    }
}