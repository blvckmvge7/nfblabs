package com.nfblabs.nfblabs.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.nfblabs.nfblabs.model.Respuesta;
import com.nfblabs.nfblabs.repository.RespuestaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class RespuestaServiceTest {
    @Autowired
    private RespuestaService respuestaService;

    @MockBean
    private RespuestaRepository respuestaRepository;

    @Test
    void testFindAll() {
        when(respuestaRepository.findAll()).thenReturn(List.of(new Respuesta()));
        List<Respuesta> respuestas = respuestaService.findAll();
        assertNotNull(respuestas);
        assertEquals(1, respuestas.size());
    }

    @Test
    void testFindById() {
        Long id = 1L;
        Respuesta respuesta = new Respuesta();
        respuesta.setId(id);
        when(respuestaRepository.findById(id)).thenReturn(Optional.of(respuesta));
        Optional<Respuesta> found = respuestaService.findById(id);
        assertTrue(found.isPresent());
        assertEquals(id, found.get().getId());
    }

    @Test
    void testSave() {
        Respuesta respuesta = new Respuesta();
        when(respuestaRepository.save(respuesta)).thenReturn(respuesta);
        Respuesta saved = respuestaService.save(respuesta);
        assertNotNull(saved);
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        Respuesta respuesta = new Respuesta();
        when(respuestaRepository.existsById(id)).thenReturn(true);
        when(respuestaRepository.save(any(Respuesta.class))).thenReturn(respuesta);
        Respuesta updated = respuestaService.update(id, respuesta);
        assertNotNull(updated);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        doNothing().when(respuestaRepository).deleteById(id);
        respuestaService.delete(id);
        verify(respuestaRepository, times(1)).deleteById(id);
    }
}
