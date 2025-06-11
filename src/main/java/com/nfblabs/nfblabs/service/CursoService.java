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

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }

    public Optional<Curso> findByCodigo(String codigo) {
        return cursoRepository.findByCodigo(codigo);
    }

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Optional<Curso> update(Long id, Curso curso) {
        return cursoRepository.findById(id).map(c -> {
            c.setNombre(curso.getNombre());
            c.setCodigo(curso.getCodigo());
            c.setDescripcion(curso.getDescripcion());
            return cursoRepository.save(c);
        });
    }

    public boolean delete(Long id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}