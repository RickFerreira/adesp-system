package com.project.adesp.controllers;

import com.project.adesp.models.Professor;
import com.project.adesp.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professors")
public class ProfessorController implements BaseController<Professor> {

    @Autowired
    private ProfessorService professorService;

    @Override
    public ResponseEntity<List<Professor>> findAll() {
        return new ResponseEntity<>(professorService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Professor> findById(@PathVariable Long id) {
        return professorService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Professor> create(@RequestBody Professor professor) {
        Professor savedProfessor = professorService.create(professor);
        return new ResponseEntity<>(savedProfessor, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Professor> update(@PathVariable Long id, @RequestBody Professor professor) {
        professor.setId(id);
        Professor updatedProfessor = professorService.update(professor);  // Atribua o professor atualizado
        return new ResponseEntity<>(updatedProfessor, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        professorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Professor>> findProfessorsByName(@RequestParam String name) {
        List<Professor> professors = professorService.findProfessorsByNameContainingIgnoreCase(name);
        return new ResponseEntity<>(professors, HttpStatus.OK);
    }


}
