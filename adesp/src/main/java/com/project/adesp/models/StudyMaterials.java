package com.project.adesp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "studymaterials")
public class StudyMaterials implements Identification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 255)
    private String fileUrl;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public StudyMaterials() {
    }

    public StudyMaterials(String name, String description, String fileUrl, Subject subject) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("A descrição não pode ser nula ou vazia");
        }
        this.name = name;
        this.description = description;
        this.fileUrl = fileUrl;
        this.subject = subject;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

}
