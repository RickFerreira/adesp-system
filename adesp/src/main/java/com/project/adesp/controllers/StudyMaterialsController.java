package com.project.adesp.controllers;

import com.project.adesp.models.StudyMaterials;
import com.project.adesp.services.StudyMaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studymaterials")
public class StudyMaterialsController implements BaseController<StudyMaterials> {

    @Autowired
    private StudyMaterialsService studyMaterialsService;

    @Override
    public ResponseEntity<List<StudyMaterials>> findAll() {
        return new ResponseEntity<>(studyMaterialsService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StudyMaterials> findById(@PathVariable Long id) {
        return studyMaterialsService.findById(id)
                .map(material -> new ResponseEntity<>(material, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<StudyMaterials> create(@RequestBody StudyMaterials studyMaterial) {
        StudyMaterials savedMaterial = studyMaterialsService.create(studyMaterial);
        return new ResponseEntity<>(savedMaterial, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<StudyMaterials> update(@PathVariable Long id, @RequestBody StudyMaterials studyMaterial) {
        studyMaterial.setId(id);
        StudyMaterials updatedMaterial = studyMaterialsService.update(studyMaterial); // Atribua o material atualizado
        return new ResponseEntity<>(updatedMaterial, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        studyMaterialsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/bySubject/{subjectId}")
    public ResponseEntity<List<StudyMaterials>> findStudyMaterialsBySubjectId(@PathVariable Long subjectId) {
        List<StudyMaterials> studyMaterials = studyMaterialsService.findStudyMaterialsBySubjectId(subjectId);
        return new ResponseEntity<>(studyMaterials, HttpStatus.OK);
    }

}
