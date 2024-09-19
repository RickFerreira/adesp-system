package com.project.adesp.repositories;

import com.project.adesp.models.StudyMaterials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyMaterialsRepository extends JpaRepository<StudyMaterials, Long> {

    List<StudyMaterials> findBySubjectId(Long subjectId);

}
