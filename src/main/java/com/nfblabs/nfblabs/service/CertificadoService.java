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
    public List<Certificado> findAll() { return certificadoRepository.findAll(); }
    public Optional<Certificado> findById(Long id) { return certificadoRepository.findById(id); }
    public Certificado save(Certificado certificado) { return certificadoRepository.save(certificado); }
    public Certificado update(Long id, Certificado certificado) { return certificadoRepository.update(id, certificado); }
    public boolean delete(Long id) { return certificadoRepository.delete(id); }
}