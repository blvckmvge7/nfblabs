package com.nfblabs.nfblabs.repository;

import com.nfblabs.nfblabs.model.Leccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeccionRepository extends JpaRepository<Leccion, Long> {
}