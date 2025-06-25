package com.nfblabs.nfblabs.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.nfblabs.nfblabs.model.Categoria;
import com.nfblabs.nfblabs.repository.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class CategoriaServiceTest {
    @Autowired
    private CategoriaService categoriaService;

    @MockBean
    private CategoriaRepository categoriaRepository;

    @Test
    void testFindAll() {
        when(categoriaRepository.findAll()).thenReturn(List.of(new Categoria()));
        List<Categoria> categorias = categoriaService.findAll();
        assertNotNull(categorias);
        assertEquals(1, categorias.size());
    }

    @Test
    void testFindById() {
        Long id = 1L;
        Categoria categoria = new Categoria();
        categoria.setId(id);
        when(categoriaRepository.findById(id)).thenReturn(Optional.of(categoria));
        Optional<Categoria> found = categoriaService.findById(id);
        assertTrue(found.isPresent());
        assertEquals(id, found.get().getId());
    }

    @Test
    void testSave() {
        Categoria categoria = new Categoria();
        when(categoriaRepository.save(categoria)).thenReturn(categoria);
        Categoria saved = categoriaService.save(categoria);
        assertNotNull(saved);
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        Categoria categoria = new Categoria();
        when(categoriaRepository.existsById(id)).thenReturn(true);
        when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);
        Categoria updated = categoriaService.update(id, categoria);
        assertNotNull(updated);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        doNothing().when(categoriaRepository).deleteById(id);
        categoriaService.delete(id);
        verify(categoriaRepository, times(1)).deleteById(id);
    }
}
