package com.project.adesp.controllers;

import com.project.adesp.models.Contact;
import com.project.adesp.models.CurriculumMatrix;
import com.project.adesp.services.CurriculumMatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curriculummatrices")
public class CurriculumMatrixController implements BaseController<CurriculumMatrix> {

    @Autowired
    private CurriculumMatrixService curriculumMatrixService;

    @Override
    public ResponseEntity<List<CurriculumMatrix>> findAll() {
        return new ResponseEntity<>(curriculumMatrixService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CurriculumMatrix> findById(@PathVariable Long id) {
        return curriculumMatrixService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<CurriculumMatrix> create(@RequestBody CurriculumMatrix curriculumMatrix) {
        CurriculumMatrix savedMatrix = curriculumMatrixService.create(curriculumMatrix);
        return new ResponseEntity<>(savedMatrix, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CurriculumMatrix> update(@PathVariable Long id, @RequestBody CurriculumMatrix curriculumMatrix) {
        curriculumMatrix.setId(id);
        CurriculumMatrix updatedCurriculumMatrix = curriculumMatrixService.update(curriculumMatrix);
        return new ResponseEntity<>(updatedCurriculumMatrix, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        curriculumMatrixService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
