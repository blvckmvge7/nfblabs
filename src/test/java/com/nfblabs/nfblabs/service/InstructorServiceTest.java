package com.nfblabs.nfblabs.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.nfblabs.nfblabs.model.Instructor;
import com.nfblabs.nfblabs.repository.InstructorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class InstructorServiceTest {
    @Autowired
    private InstructorService instructorService;

    @MockBean
    private InstructorRepository instructorRepository;

    @Test
    void testFindAll() {
        when(instructorRepository.findAll()).thenReturn(List.of(new Instructor()));
        List<Instructor> instructores = instructorService.findAll();
        assertNotNull(instructores);
        assertEquals(1, instructores.size());
    }

    @Test
    void testFindById() {
        Long id = 1L;
        Instructor instructor = new Instructor();
        instructor.setId(id);
        when(instructorRepository.findById(id)).thenReturn(Optional.of(instructor));
        Optional<Instructor> found = instructorService.findById(id);
        assertTrue(found.isPresent());
        assertEquals(id, found.get().getId());
    }

    @Test
    void testSave() {
        Instructor instructor = new Instructor();
        when(instructorRepository.save(instructor)).thenReturn(instructor);
        Instructor saved = instructorService.save(instructor);
        assertNotNull(saved);
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        Instructor instructor = new Instructor();
        when(instructorRepository.existsById(id)).thenReturn(true);
        when(instructorRepository.save(any(Instructor.class))).thenReturn(instructor);
        Instructor updated = instructorService.update(id, instructor);
        assertNotNull(updated);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        doNothing().when(instructorRepository).deleteById(id);
        instructorService.delete(id);
        verify(instructorRepository, times(1)).deleteById(id);
    }
}
