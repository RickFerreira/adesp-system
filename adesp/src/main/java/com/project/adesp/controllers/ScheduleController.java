package com.project.adesp.controllers;

import com.project.adesp.models.Schedule;
import com.project.adesp.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedules")
public class ScheduleController implements BaseController<Schedule> {

    @Autowired
    private ScheduleService scheduleService;

    @Override
    public ResponseEntity<List<Schedule>> findAll() {
        return new ResponseEntity<>(scheduleService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Schedule> findById(@PathVariable Long id) {
        return scheduleService.findById(id)
                .map(schedule -> new ResponseEntity<>(schedule, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Schedule> create(@RequestBody Schedule schedule) {
        Schedule savedSchedule = scheduleService.create(schedule);
        return new ResponseEntity<>(savedSchedule, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Schedule> update(@PathVariable Long id, @RequestBody Schedule schedule) {
        schedule.setId(id);

        Schedule updatedSchedule = scheduleService.update(schedule);
        return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        scheduleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byProfessor/{professorId}")
    public ResponseEntity<List<Schedule>> findSchedulesByProfessorId(@PathVariable Long professorId) {
        List<Schedule> schedules = scheduleService.findSchedulesByProfessorId(professorId);
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @GetMapping("/byPeriod/{periodId}")
    public ResponseEntity<List<Schedule>> findSchedulesByPeriodId(@PathVariable Long periodId) {
        List<Schedule> schedules = scheduleService.findSchedulesByPeriodId(periodId);
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

}
