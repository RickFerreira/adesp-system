package com.project.adesp.services;

import com.project.adesp.models.Period;
import com.project.adesp.repositories.PeriodRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeriodService implements CrudService<Period> {

    @Autowired
    private PeriodRepository periodRepository;

    @Override
    public Period create(Period period) {
        return periodRepository.save(period);
    }

    @Override
    public Optional<Period> findById(Long id) {
        return periodRepository.findById(id);
    }

    @Override
    public List<Period> findAll() {
        return periodRepository.findAll();
    }

    public List<Period> findPeriodsByNameContainingIgnoreCase(String name) {
        return periodRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Period update(Period period) { return periodRepository.save(period); }

    @Override
    public void deleteById(Long id) {
        periodRepository.deleteById(id);
    }

}
