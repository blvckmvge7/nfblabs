package com.nfblabs.nfblabs.service;

import com.nfblabs.nfblabs.model.Instructor;
import com.nfblabs.nfblabs.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    public Optional<Instructor> findById(Long id) {
        return instructorRepository.findById(id);
    }

    public Instructor update(Long id, Instructor instructor) {
        if (instructorRepository.existsById(id)) {
            instructor.setId(id);
            return instructorRepository.save(instructor);
        }
        throw new RuntimeException("Instructor not found with id " + id);
    }

    public void delete(Long id) {
        instructorRepository.deleteById(id);
    }
}