package com.project.adesp.repositories;

import com.project.adesp.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findByPeriodId(Long periodId);

    List<Subject> findByProfessorId(Long professorId);

}
