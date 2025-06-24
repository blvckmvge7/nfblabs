package com.nfblabs.nfblabs.service;

import com.nfblabs.nfblabs.model.Certificado;
import com.nfblabs.nfblabs.repository.CertificadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CertificadoService {
    @Autowired
    private CertificadoRepository certificadoRepository;

    public Certificado save(Certificado certificado) {
        return certificadoRepository.save(certificado);
    }

    public List<Certificado> findAll() {
        return certificadoRepository.findAll();
    }

    public Optional<Certificado> findById(Long id) {
        return certificadoRepository.findById(id);
    }

    public Certificado update(Long id, Certificado certificado) {
        if (certificadoRepository.existsById(id)) {
            certificado.setId(id);
            return certificadoRepository.save(certificado);
        }
        throw new RuntimeException("Certificado not found with id " + id);
    }

    public void delete(Long id) {
        certificadoRepository.deleteById(id);
    }
}