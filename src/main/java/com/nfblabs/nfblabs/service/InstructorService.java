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
    private InstructorRepository repository;

    public List<Instructor> getAllInstructores() {
        return repository.findAll();
    }

    public Optional<Instructor> getInstructorById(Long id) {
        return repository.findById(id);
    }

    public Optional<Instructor> getInstructorByIsbn(String isbn) {
        return repository.findByIsbn(isbn);
    }

    public Instructor saveInstructor(Instructor instructor) {
        return repository.save(instructor);
    }

    public Instructor updateInstructor(Long id, Instructor instructor) {
        return repository.update(id, instructor);
    }

    public boolean deleteInstructor(Long id) {
        return repository.deleteById(id);
    }
}
