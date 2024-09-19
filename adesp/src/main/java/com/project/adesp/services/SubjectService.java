package com.project.adesp.services;

import com.project.adesp.models.Subject;
import com.project.adesp.repositories.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService implements CrudService<Subject> {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject create(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Optional<Subject> findById(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public List<Subject> findSubjectsByPeriodId(Long periodId) {
        return subjectRepository.findByPeriodId(periodId);
    }

    public List<Subject> findSubjectsByProfessorId(Long professorId) {
        return subjectRepository.findByProfessorId(professorId);
    }

    @Override
    public Subject update(Subject subject){ return subjectRepository.save(subject); }

    @Override
    public void deleteById(Long id) {
        subjectRepository.deleteById(id);
    }

}
