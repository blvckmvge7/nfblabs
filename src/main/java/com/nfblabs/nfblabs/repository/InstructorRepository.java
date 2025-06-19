package com.nfblabs.nfblabs.repository;

import com.nfblabs.nfblabs.model.Instructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InstructorRepository {

    private List<Instructor> instructores = new ArrayList<>();

    public List<Instructor> findAll() {
        return instructores;
    }

    public Optional<Instructor> findById(Long id) {
        return instructores.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public Optional<Instructor> findByIsbn(String isbn) {
        return instructores.stream().filter(i -> i.getIsbn().equals(isbn)).findFirst();
    }

    public Instructor save(Instructor instructor) {
        instructores.add(instructor);
        return instructor;
    }

    public Instructor update(Long id, Instructor updatedInstructor) {
        for (int i = 0; i < instructores.size(); i++) {
            if (instructores.get(i).getId().equals(id)) {
                instructores.set(i, updatedInstructor);
                return updatedInstructor;
            }
        }
        return null;
    }

    public boolean deleteById(Long id) {
        return instructores.removeIf(i -> i.getId().equals(id));
    }
}
