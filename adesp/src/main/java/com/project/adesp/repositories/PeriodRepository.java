package com.project.adesp.repositories;

import com.project.adesp.models.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Long> {

    List<Period> findByNameContainingIgnoreCase(String name);

}
