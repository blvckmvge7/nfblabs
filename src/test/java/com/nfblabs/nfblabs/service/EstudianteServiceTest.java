package com.nfblabs.nfblabs.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.nfblabs.nfblabs.model.Estudiante;
import com.nfblabs.nfblabs.repository.EstudianteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class EstudianteServiceTest {
    @Autowired
    private EstudianteService estudianteService;

    @MockBean
    private EstudianteRepository estudianteRepository;

    @Test
    void testFindAll() {
        when(estudianteRepository.findAll()).thenReturn(List.of(new Estudiante()));
        List<Estudiante> estudiantes = estudianteService.findAll();
        assertNotNull(estudiantes);
        assertEquals(1, estudiantes.size());
    }

    @Test
    void testFindById() {
        Long id = 1L;
        Estudiante estudiante = new Estudiante();
        estudiante.setId(id);
        when(estudianteRepository.findById(id)).thenReturn(Optional.of(estudiante));
        Optional<Estudiante> found = estudianteService.findById(id);
        assertTrue(found.isPresent());
        assertEquals(id, found.get().getId());
    }

    @Test
    void testSave() {
        Estudiante estudiante = new Estudiante();
        when(estudianteRepository.save(estudiante)).thenReturn(estudiante);
        Estudiante saved = estudianteService.save(estudiante);
        assertNotNull(saved);
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        Estudiante estudiante = new Estudiante();
        when(estudianteRepository.existsById(id)).thenReturn(true);
        when(estudianteRepository.save(any(Estudiante.class))).thenReturn(estudiante);
        Estudiante updated = estudianteService.update(id, estudiante);
        assertNotNull(updated);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        doNothing().when(estudianteRepository).deleteById(id);
        estudianteService.delete(id);
        verify(estudianteRepository, times(1)).deleteById(id);
    }
}
