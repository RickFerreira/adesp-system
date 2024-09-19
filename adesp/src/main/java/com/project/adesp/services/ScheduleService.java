package com.project.adesp.services;

import com.project.adesp.models.Schedule;
import com.project.adesp.repositories.ScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService implements CrudService<Schedule> {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public Schedule create(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        return scheduleRepository.findById(id);
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> findSchedulesByProfessorId(Long professorId) {
        return scheduleRepository.findByProfessorId(professorId);
    }

    public List<Schedule> findSchedulesByPeriodId(Long periodId) {
        return scheduleRepository.findByPeriodId(periodId);
    }

    @Override
    public Schedule update(Schedule schedule) { return scheduleRepository.save(schedule); }

    @Override
    public void deleteById(Long id) {
        scheduleRepository.deleteById(id);
    }

}
