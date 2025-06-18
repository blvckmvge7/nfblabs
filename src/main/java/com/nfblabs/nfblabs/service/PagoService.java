package com.nfblabs.nfblabs.service;

import com.nfblabs.nfblabs.model.Pago;
import com.nfblabs.nfblabs.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PagoService {
    @Autowired
    private PagoRepository pagoRepository;
    public List<Pago> findAll() { return pagoRepository.findAll(); }
    public Optional<Pago> findById(Long id) { return pagoRepository.findById(id); }
    public Pago save(Pago pago) { return pagoRepository.save(pago); }
    public Pago update(Long id, Pago pago) { return pagoRepository.update(id, pago); }
    public boolean delete(Long id) { return pagoRepository.delete(id); }
}