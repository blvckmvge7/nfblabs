package com.nfblabs.nfblabs.service;

import com.nfblabs.nfblabs.model.Modulo;
import com.nfblabs.nfblabs.repository.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ModuloService {
    @Autowired
    private ModuloRepository moduloRepository;
    public List<Modulo> findAll() { return moduloRepository.findAll(); }
    public Optional<Modulo> findById(Long id) { return moduloRepository.findById(id); }
    public Modulo save(Modulo modulo) { return moduloRepository.save(modulo); }
    public Modulo update(Long id, Modulo modulo) { return moduloRepository.update(id, modulo); }
    public boolean delete(Long id) { return moduloRepository.delete(id); }
}