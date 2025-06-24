package com.nfblabs.nfblabs.repository;

import com.nfblabs.nfblabs.model.Certificado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificadoRepository extends JpaRepository<Certificado, Long> {
}