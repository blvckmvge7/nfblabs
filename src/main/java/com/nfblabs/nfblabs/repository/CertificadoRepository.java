package com.nfblabs.nfblabs.repository;

import com.nfblabs.nfblabs.model.Certificado;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CertificadoRepository {
    private final List<Certificado> certificados = new ArrayList<>();
    public List<Certificado> findAll() { return certificados; }
    public Optional<Certificado> findById(Long id) {
        return certificados.stream().filter(c -> c.getId().equals(id)).findFirst();
    }
    public Certificado save(Certificado certificado) {
        certificados.add(certificado);
        return certificado;
    }
    public Certificado update(Long id, Certificado certificado) {
        for (int i = 0; i < certificados.size(); i++) {
            if (certificados.get(i).getId().equals(id)) {
                certificados.set(i, certificado);
                return certificado;
            }
        }
        return null;
    }
    public boolean delete(Long id) {
        return certificados.removeIf(c -> c.getId().equals(id));
    }
}