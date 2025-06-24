package com.nfblabs.nfblabs.service;

import com.nfblabs.nfblabs.model.Curso;
import com.nfblabs.nfblabs.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso update(Long id, Curso curso) {
        if (cursoRepository.existsById(id)) {
            curso.setId(id);
            return cursoRepository.save(curso);
        }
        throw new RuntimeException("Curso not found with id " + id);
    }

    public void delete(Long id) {
        cursoRepository.deleteById(id);
    }
}