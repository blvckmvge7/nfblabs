package com.nfblabs.nfblabs.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.nfblabs.nfblabs.model.Inscripcion;
import com.nfblabs.nfblabs.repository.InscripcionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class InscripcionServiceTest {
    @Autowired
    private InscripcionService inscripcionService;

    @MockBean
    private InscripcionRepository inscripcionRepository;

    @Test
    void testFindAll() {
        when(inscripcionRepository.findAll()).thenReturn(List.of(new Inscripcion()));
        List<Inscripcion> inscripciones = inscripcionService.findAll();
        assertNotNull(inscripciones);
        assertEquals(1, inscripciones.size());
    }

    @Test
    void testFindById() {
        Long id = 1L;
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setId(id);
        when(inscripcionRepository.findById(id)).thenReturn(Optional.of(inscripcion));
        Optional<Inscripcion> found = inscripcionService.findById(id);
        assertTrue(found.isPresent());
        assertEquals(id, found.get().getId());
    }

    @Test
    void testSave() {
        Inscripcion inscripcion = new Inscripcion();
        when(inscripcionRepository.save(inscripcion)).thenReturn(inscripcion);
        Inscripcion saved = inscripcionService.save(inscripcion);
        assertNotNull(saved);
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        Inscripcion inscripcion = new Inscripcion();
        when(inscripcionRepository.existsById(id)).thenReturn(true);
        when(inscripcionRepository.save(any(Inscripcion.class))).thenReturn(inscripcion);
        Inscripcion updated = inscripcionService.update(id, inscripcion);
        assertNotNull(updated);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        doNothing().when(inscripcionRepository).deleteById(id);
        inscripcionService.delete(id);
        verify(inscripcionRepository, times(1)).deleteById(id);
    }
}
