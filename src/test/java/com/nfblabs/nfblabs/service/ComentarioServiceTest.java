package com.nfblabs.nfblabs.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.nfblabs.nfblabs.model.Comentario;
import com.nfblabs.nfblabs.repository.ComentarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ComentarioServiceTest {
    @Autowired
    private ComentarioService comentarioService;

    @MockBean
    private ComentarioRepository comentarioRepository;

    @Test
    void testFindAll() {
        when(comentarioRepository.findAll()).thenReturn(List.of(new Comentario()));
        List<Comentario> comentarios = comentarioService.findAll();
        assertNotNull(comentarios);
        assertEquals(1, comentarios.size());
    }

    @Test
    void testFindById() {
        Long id = 1L;
        Comentario comentario = new Comentario();
        comentario.setId(id);
        when(comentarioRepository.findById(id)).thenReturn(Optional.of(comentario));
        Optional<Comentario> found = comentarioService.findById(id);
        assertTrue(found.isPresent());
        assertEquals(id, found.get().getId());
    }

    @Test
    void testSave() {
        Comentario comentario = new Comentario();
        when(comentarioRepository.save(comentario)).thenReturn(comentario);
        Comentario saved = comentarioService.save(comentario);
        assertNotNull(saved);
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        Comentario comentario = new Comentario();
        when(comentarioRepository.existsById(id)).thenReturn(true);
        when(comentarioRepository.save(any(Comentario.class))).thenReturn(comentario);
        Comentario updated = comentarioService.update(id, comentario);
        assertNotNull(updated);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        doNothing().when(comentarioRepository).deleteById(id);
        comentarioService.delete(id);
        verify(comentarioRepository, times(1)).deleteById(id);
    }
}
