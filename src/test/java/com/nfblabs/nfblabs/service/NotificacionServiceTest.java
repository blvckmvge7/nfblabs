package com.nfblabs.nfblabs.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.nfblabs.nfblabs.model.Notificacion;
import com.nfblabs.nfblabs.repository.NotificacionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class NotificacionServiceTest {
    @Autowired
    private NotificacionService notificacionService;

    @MockBean
    private NotificacionRepository notificacionRepository;

    @Test
    void testFindAll() {
        when(notificacionRepository.findAll()).thenReturn(List.of(new Notificacion()));
        List<Notificacion> notificaciones = notificacionService.findAll();
        assertNotNull(notificaciones);
        assertEquals(1, notificaciones.size());
    }

    @Test
    void testFindById() {
        Long id = 1L;
        Notificacion notificacion = new Notificacion();
        notificacion.setId(id);
        when(notificacionRepository.findById(id)).thenReturn(Optional.of(notificacion));
        Optional<Notificacion> found = notificacionService.findById(id);
        assertTrue(found.isPresent());
        assertEquals(id, found.get().getId());
    }

    @Test
    void testSave() {
        Notificacion notificacion = new Notificacion();
        when(notificacionRepository.save(notificacion)).thenReturn(notificacion);
        Notificacion saved = notificacionService.save(notificacion);
        assertNotNull(saved);
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        Notificacion notificacion = new Notificacion();
        when(notificacionRepository.existsById(id)).thenReturn(true);
        when(notificacionRepository.save(any(Notificacion.class))).thenReturn(notificacion);
        Notificacion updated = notificacionService.update(id, notificacion);
        assertNotNull(updated);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        doNothing().when(notificacionRepository).deleteById(id);
        notificacionService.delete(id);
        verify(notificacionRepository, times(1)).deleteById(id);
    }
}
