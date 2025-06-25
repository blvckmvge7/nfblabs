package com.nfblabs.nfblabs.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.nfblabs.nfblabs.model.Modulo;
import com.nfblabs.nfblabs.repository.ModuloRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ModuloServiceTest {
    @Autowired
    private ModuloService moduloService;

    @MockBean
    private ModuloRepository moduloRepository;

    @Test
    void testFindAll() {
        when(moduloRepository.findAll()).thenReturn(List.of(new Modulo()));
        List<Modulo> modulos = moduloService.findAll();
        assertNotNull(modulos);
        assertEquals(1, modulos.size());
    }

    @Test
    void testFindById() {
        Long id = 1L;
        Modulo modulo = new Modulo();
        modulo.setId(id);
        when(moduloRepository.findById(id)).thenReturn(Optional.of(modulo));
        Optional<Modulo> found = moduloService.findById(id);
        assertTrue(found.isPresent());
        assertEquals(id, found.get().getId());
    }

    @Test
    void testSave() {
        Modulo modulo = new Modulo();
        when(moduloRepository.save(modulo)).thenReturn(modulo);
        Modulo saved = moduloService.save(modulo);
        assertNotNull(saved);
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        Modulo modulo = new Modulo();
        when(moduloRepository.existsById(id)).thenReturn(true);
        when(moduloRepository.save(any(Modulo.class))).thenReturn(modulo);
        Modulo updated = moduloService.update(id, modulo);
        assertNotNull(updated);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        doNothing().when(moduloRepository).deleteById(id);
        moduloService.delete(id);
        verify(moduloRepository, times(1)).deleteById(id);
    }
}
