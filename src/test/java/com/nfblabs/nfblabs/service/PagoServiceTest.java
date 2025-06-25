package com.nfblabs.nfblabs.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.nfblabs.nfblabs.model.Pago;
import com.nfblabs.nfblabs.repository.PagoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class PagoServiceTest {
    @Autowired
    private PagoService pagoService;

    @MockBean
    private PagoRepository pagoRepository;

    @Test
    void testFindAll() {
        when(pagoRepository.findAll()).thenReturn(List.of(new Pago()));
        List<Pago> pagos = pagoService.findAll();
        assertNotNull(pagos);
        assertEquals(1, pagos.size());
    }

    @Test
    void testFindById() {
        Long id = 1L;
        Pago pago = new Pago();
        pago.setId(id);
        when(pagoRepository.findById(id)).thenReturn(Optional.of(pago));
        Optional<Pago> found = pagoService.findById(id);
        assertTrue(found.isPresent());
        assertEquals(id, found.get().getId());
    }

    @Test
    void testSave() {
        Pago pago = new Pago();
        when(pagoRepository.save(pago)).thenReturn(pago);
        Pago saved = pagoService.save(pago);
        assertNotNull(saved);
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        Pago pago = new Pago();
        when(pagoRepository.existsById(id)).thenReturn(true);
        when(pagoRepository.save(any(Pago.class))).thenReturn(pago);
        Pago updated = pagoService.update(id, pago);
        assertNotNull(updated);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        doNothing().when(pagoRepository).deleteById(id);
        pagoService.delete(id);
        verify(pagoRepository, times(1)).deleteById(id);
    }
}
