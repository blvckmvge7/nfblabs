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
    public List<Comentario> findAll() { return comentarioRepository.findAll(); }
    public Optional<Comentario> findById(Long id) { return comentarioRepository.findById(id); }
    public Comentario save(Comentario comentario) { return comentarioRepository.save(comentario); }
    public Comentario update(Long id, Comentario comentario) { return comentarioRepository.update(id, comentario); }
    public boolean delete(Long id) { return comentarioRepository.delete(id); }
}