package com.project.adesp.services;

import com.project.adesp.models.Professor;
import com.project.adesp.repositories.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService implements CrudService<Professor> {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public Professor create(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Optional<Professor> findById(Long id) {
        return professorRepository.findById(id);
    }

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public List<Professor> findProfessorsByNameContainingIgnoreCase(String name) {
        return professorRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Professor update(Professor professor) { return professorRepository.save(professor); }

    @Override
    public void deleteById(Long id) {
        professorRepository.deleteById(id);
    }

}
