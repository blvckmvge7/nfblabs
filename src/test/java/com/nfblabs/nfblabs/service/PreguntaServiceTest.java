package com.nfblabs.nfblabs.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.nfblabs.nfblabs.model.Pregunta;
import com.nfblabs.nfblabs.repository.PreguntaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class PreguntaServiceTest {
    @Autowired
    private PreguntaService preguntaService;

    @MockBean
    private PreguntaRepository preguntaRepository;

    @Test
    void testFindAll() {
        when(preguntaRepository.findAll()).thenReturn(List.of(new Pregunta()));
        List<Pregunta> preguntas = preguntaService.findAll();
        assertNotNull(preguntas);
        assertEquals(1, preguntas.size());
    }

    @Test
    void testFindById() {
        Long id = 1L;
        Pregunta pregunta = new Pregunta();
        pregunta.setId(id);
        when(preguntaRepository.findById(id)).thenReturn(Optional.of(pregunta));
        Optional<Pregunta> found = preguntaService.findById(id);
        assertTrue(found.isPresent());
        assertEquals(id, found.get().getId());
    }

    @Test
    void testSave() {
        Pregunta pregunta = new Pregunta();
        when(preguntaRepository.save(pregunta)).thenReturn(pregunta);
        Pregunta saved = preguntaService.save(pregunta);
        assertNotNull(saved);
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        Pregunta pregunta = new Pregunta();
        when(preguntaRepository.existsById(id)).thenReturn(true);
        when(preguntaRepository.save(any(Pregunta.class))).thenReturn(pregunta);
        Pregunta updated = preguntaService.update(id, pregunta);
        assertNotNull(updated);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        doNothing().when(preguntaRepository).deleteById(id);
        preguntaService.delete(id);
        verify(preguntaRepository, times(1)).deleteById(id);
    }
}
