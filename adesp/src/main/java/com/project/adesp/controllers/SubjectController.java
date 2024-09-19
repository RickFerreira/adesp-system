package com.project.adesp.controllers;

import com.project.adesp.models.Subject;
import com.project.adesp.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subjects")
public class SubjectController implements BaseController<Subject> {

    @Autowired
    private SubjectService subjectService;

    @Override
    public ResponseEntity<List<Subject>> findAll() {
        return new ResponseEntity<>(subjectService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Subject> findById(@PathVariable Long id) {
        return subjectService.findById(id)
                .map(subject -> new ResponseEntity<>(subject, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Subject> create(@RequestBody Subject subject) {
        Subject savedSubject = subjectService.create(subject);
        return new ResponseEntity<>(savedSubject, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Subject> update(@PathVariable Long id, @RequestBody Subject subject) {
        subject.setId(id);
        Subject updatedSubject = subjectService.update(subject);
        return new ResponseEntity<>(updatedSubject, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        subjectService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byPeriod/{periodId}")
    public ResponseEntity<List<Subject>> findSubjectsByPeriodId(@PathVariable Long periodId) {
        List<Subject> subjects = subjectService.findSubjectsByPeriodId(periodId);
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @GetMapping("/byProfessor/{professorId}")
    public ResponseEntity<List<Subject>> findSubjectsByProfessorId(@PathVariable Long professorId) {
        List<Subject> subjects = subjectService.findSubjectsByProfessorId(professorId);
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }
}
