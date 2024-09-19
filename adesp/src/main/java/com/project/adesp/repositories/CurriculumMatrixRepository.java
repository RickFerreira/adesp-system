package com.project.adesp.repositories;

import com.project.adesp.models.CurriculumMatrix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurriculumMatrixRepository extends JpaRepository<CurriculumMatrix, Long> {

}
