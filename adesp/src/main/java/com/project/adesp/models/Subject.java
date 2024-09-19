package com.project.adesp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject implements Identification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(unique = true, length = 40)
    private String code;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Integer courseLoad;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "period_id")
    private Period period;

    @ManyToOne
    @JoinColumn(name = "curriculumMatrix_id")
    private CurriculumMatrix curriculumMatrix;

    public Subject() {
    }

    public Subject(String name, String code, String description, Integer courseLoad, Professor professor, Period period, CurriculumMatrix curriculumMatrix) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio");
        }
        if (code == null || code.isBlank() || code.length() > 40) {
            throw new IllegalArgumentException("O código deve ter no máximo 40 caracteres e não pode ser nulo ou vazio");
        }
        this.name = name;
        this.code = code;
        this.description = description;
        this.courseLoad = courseLoad;
        this.professor = professor;
        this.period = period;
        this.curriculumMatrix = curriculumMatrix;
    }

    @Override
    public Long getId() { return id; }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCourseLoad() {
        return courseLoad;
    }

    public void setCourseLoad(int courseLoad) {
        this.courseLoad = courseLoad;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public CurriculumMatrix getCurriculumMatrix() {
        return curriculumMatrix;
    }

    public void setCurriculumMatrix(CurriculumMatrix curriculumMatrix) {
        this.curriculumMatrix = curriculumMatrix;
    }

}
