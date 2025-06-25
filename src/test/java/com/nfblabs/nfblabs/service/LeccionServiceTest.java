package com.nfblabs.nfblabs.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.nfblabs.nfblabs.model.Leccion;
import com.nfblabs.nfblabs.repository.LeccionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class LeccionServiceTest {
    @Autowired
    private LeccionService leccionService;

    @MockBean
    private LeccionRepository leccionRepository;

    @Test
    void testFindAll() {
        when(leccionRepository.findAll()).thenReturn(List.of(new Leccion()));
        List<Leccion> lecciones = leccionService.findAll();
        assertNotNull(lecciones);
        assertEquals(1, lecciones.size());
    }

    @Test
    void testFindById() {
        Long id = 1L;
        Leccion leccion = new Leccion();
        leccion.setId(id);
        when(leccionRepository.findById(id)).thenReturn(Optional.of(leccion));
        Optional<Leccion> found = leccionService.findById(id);
        assertTrue(found.isPresent());
        assertEquals(id, found.get().getId());
    }

    @Test
    void testSave() {
        Leccion leccion = new Leccion();
        when(leccionRepository.save(leccion)).thenReturn(leccion);
        Leccion saved = leccionService.save(leccion);
        assertNotNull(saved);
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        Leccion leccion = new Leccion();
        when(leccionRepository.existsById(id)).thenReturn(true);
        when(leccionRepository.save(any(Leccion.class))).thenReturn(leccion);
        Leccion updated = leccionService.update(id, leccion);
        assertNotNull(updated);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        doNothing().when(leccionRepository).deleteById(id);
        leccionService.delete(id);
        verify(leccionRepository, times(1)).deleteById(id);
    }
}
