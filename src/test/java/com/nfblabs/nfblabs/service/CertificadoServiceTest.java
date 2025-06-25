package com.nfblabs.nfblabs.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.nfblabs.nfblabs.model.Certificado;
import com.nfblabs.nfblabs.repository.CertificadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class CertificadoServiceTest {
    @Autowired
    private CertificadoService certificadoService;

    @MockBean
    private CertificadoRepository certificadoRepository;

    @Test
    void testFindAll() {
        when(certificadoRepository.findAll()).thenReturn(List.of(new Certificado()));
        List<Certificado> certificados = certificadoService.findAll();
        assertNotNull(certificados);
        assertEquals(1, certificados.size());
    }

    @Test
    void testFindById() {
        Long id = 1L;
        Certificado certificado = new Certificado();
        certificado.setId(id);
        when(certificadoRepository.findById(id)).thenReturn(Optional.of(certificado));
        Optional<Certificado> found = certificadoService.findById(id);
        assertTrue(found.isPresent());
        assertEquals(id, found.get().getId());
    }

    @Test
    void testSave() {
        Certificado certificado = new Certificado();
        when(certificadoRepository.save(certificado)).thenReturn(certificado);
        Certificado saved = certificadoService.save(certificado);
        assertNotNull(saved);
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        Certificado certificado = new Certificado();
        when(certificadoRepository.existsById(id)).thenReturn(true);
        when(certificadoRepository.save(any(Certificado.class))).thenReturn(certificado);
        Certificado updated = certificadoService.update(id, certificado);
        assertNotNull(updated);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        doNothing().when(certificadoRepository).deleteById(id);
        certificadoService.delete(id);
        verify(certificadoRepository, times(1)).deleteById(id);
    }
}
