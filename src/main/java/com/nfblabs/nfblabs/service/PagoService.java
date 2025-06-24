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

    public Pago save(Pago pago) {
        return pagoRepository.save(pago);
    }

    public List<Pago> findAll() {
        return pagoRepository.findAll();
    }

    public Optional<Pago> findById(Long id) {
        return pagoRepository.findById(id);
    }

    public Pago update(Long id, Pago pago) {
        if (pagoRepository.existsById(id)) {
            pago.setId(id);
            return pagoRepository.save(pago);
        }
        throw new RuntimeException("Pago not found with id " + id);
    }

    public void delete(Long id) {
        pagoRepository.deleteById(id);
    }
}