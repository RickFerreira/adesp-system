package com.project.adesp.controllers;

import com.project.adesp.models.Period;
import com.project.adesp.services.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/periods")
public class PeriodController implements BaseController<Period> {

    @Autowired
    private PeriodService periodService;

    @Override
    public ResponseEntity<List<Period>> findAll() {
        return new ResponseEntity<>(periodService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Period> findById(@PathVariable Long id) {
        return periodService.findById(id)
                .map(period -> new ResponseEntity<>(period, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Period> create(@RequestBody Period period) {
        Period savedPeriod = periodService.create(period);
        return new ResponseEntity<>(savedPeriod, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Period> update(@PathVariable Long id, @RequestBody Period period) {
        period.setId(id);
        Period updatedPeriod = periodService.update(period);
        return new ResponseEntity<>(updatedPeriod, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        periodService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Period>> findPeriodsByName(@RequestParam String name) {
        List<Period> periods = periodService.findPeriodsByNameContainingIgnoreCase(name);
        return new ResponseEntity<>(periods, HttpStatus.OK);
    }
}
