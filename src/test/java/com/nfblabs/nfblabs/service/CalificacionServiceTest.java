package com.nfblabs.nfblabs.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.nfblabs.nfblabs.model.Calificacion;
import com.nfblabs.nfblabs.repository.CalificacionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class CalificacionServiceTest {
    @Autowired
    private CalificacionService calificacionService;

    @MockBean
    private CalificacionRepository calificacionRepository;

    @Test
    void testFindAll() {
        when(calificacionRepository.findAll()).thenReturn(List.of(new Calificacion()));
        List<Calificacion> calificaciones = calificacionService.findAll();
        assertNotNull(calificaciones);
        assertEquals(1, calificaciones.size());
    }

    @Test
    void testFindById() {
        Long id = 1L;
        Calificacion calificacion = new Calificacion();
        calificacion.setId(id);
        when(calificacionRepository.findById(id)).thenReturn(Optional.of(calificacion));
        Optional<Calificacion> found = calificacionService.findById(id);
        assertTrue(found.isPresent());
        assertEquals(id, found.get().getId());
    }

    @Test
    void testSave() {
        Calificacion calificacion = new Calificacion();
        when(calificacionRepository.save(calificacion)).thenReturn(calificacion);
        Calificacion saved = calificacionService.save(calificacion);
        assertNotNull(saved);
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        Calificacion calificacion = new Calificacion();
        when(calificacionRepository.existsById(id)).thenReturn(true);
        when(calificacionRepository.save(any(Calificacion.class))).thenReturn(calificacion);
        Calificacion updated = calificacionService.update(id, calificacion);
        assertNotNull(updated);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        doNothing().when(calificacionRepository).deleteById(id);
        calificacionService.delete(id);
        verify(calificacionRepository, times(1)).deleteById(id);
    }
}
