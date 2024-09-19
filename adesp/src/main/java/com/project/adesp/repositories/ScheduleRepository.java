package com.project.adesp.repositories;

import com.project.adesp.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByProfessorId(Long professorId);

    List<Schedule> findByPeriodId(Long periodId);

}
