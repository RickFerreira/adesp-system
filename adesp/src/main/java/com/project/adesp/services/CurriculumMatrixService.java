package com.project.adesp.services;

import com.project.adesp.models.CurriculumMatrix;
import com.project.adesp.repositories.CurriculumMatrixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurriculumMatrixService implements CrudService<CurriculumMatrix> {

    @Autowired
    private CurriculumMatrixRepository curriculumMatrixRepository;

    @Override
    public CurriculumMatrix create(CurriculumMatrix curriculumMatrix) {
        return curriculumMatrixRepository.save(curriculumMatrix);
    }

    @Override
    public Optional<CurriculumMatrix> findById(Long id) {
        return curriculumMatrixRepository.findById(id);
    }

    @Override
    public List<CurriculumMatrix> findAll() {
        return curriculumMatrixRepository.findAll();
    }

    @Override
    public CurriculumMatrix update(CurriculumMatrix curriculumMatrix) { return curriculumMatrixRepository.save(curriculumMatrix); }

    @Override
    public void deleteById(Long id) {
        curriculumMatrixRepository.deleteById(id);
    }

}
