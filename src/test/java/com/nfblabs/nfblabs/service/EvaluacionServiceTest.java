package com.nfblabs.nfblabs.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.nfblabs.nfblabs.model.Evaluacion;
import com.nfblabs.nfblabs.repository.EvaluacionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class EvaluacionServiceTest {
    @Autowired
    private EvaluacionService evaluacionService;

    @MockBean
    private EvaluacionRepository evaluacionRepository;

    @Test
    void testFindAll() {
        when(evaluacionRepository.findAll()).thenReturn(List.of(new Evaluacion()));
        List<Evaluacion> evaluaciones = evaluacionService.findAll();
        assertNotNull(evaluaciones);
        assertEquals(1, evaluaciones.size());
    }

    @Test
    void testFindById() {
        Long id = 1L;
        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setId(id);
        when(evaluacionRepository.findById(id)).thenReturn(Optional.of(evaluacion));
        Optional<Evaluacion> found = evaluacionService.findById(id);
        assertTrue(found.isPresent());
        assertEquals(id, found.get().getId());
    }

    @Test
    void testSave() {
        Evaluacion evaluacion = new Evaluacion();
        when(evaluacionRepository.save(evaluacion)).thenReturn(evaluacion);
        Evaluacion saved = evaluacionService.save(evaluacion);
        assertNotNull(saved);
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        Evaluacion evaluacion = new Evaluacion();
        when(evaluacionRepository.existsById(id)).thenReturn(true);
        when(evaluacionRepository.save(any(Evaluacion.class))).thenReturn(evaluacion);
        Evaluacion updated = evaluacionService.update(id, evaluacion);
        assertNotNull(updated);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        doNothing().when(evaluacionRepository).deleteById(id);
        evaluacionService.delete(id);
        verify(evaluacionRepository, times(1)).deleteById(id);
    }
}
