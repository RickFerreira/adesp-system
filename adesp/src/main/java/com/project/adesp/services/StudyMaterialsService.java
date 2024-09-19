package com.project.adesp.services;

import com.project.adesp.models.StudyMaterials;
import com.project.adesp.repositories.StudyMaterialsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudyMaterialsService implements CrudService<StudyMaterials> {

    @Autowired
    private StudyMaterialsRepository studyMaterialsRepository;

    @Override
    public StudyMaterials create(StudyMaterials studyMaterials) {
        return studyMaterialsRepository.save(studyMaterials);
    }

    @Override
    public Optional<StudyMaterials> findById(Long id) {
        return studyMaterialsRepository.findById(id);
    }

    @Override
    public List<StudyMaterials> findAll() {
        return studyMaterialsRepository.findAll();
    }

    public List<StudyMaterials> findStudyMaterialsBySubjectId(Long subjectId) {
        return studyMaterialsRepository.findBySubjectId(subjectId);
    }

    @Override
    public StudyMaterials update(StudyMaterials studyMaterial) { return studyMaterialsRepository.save(studyMaterial); }

    @Override
    public void deleteById(Long id) {
        studyMaterialsRepository.deleteById(id);
    }
}
