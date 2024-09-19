package com.project.adesp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "curriculummatrices")
public class CurriculumMatrix implements Identification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String url;

    public CurriculumMatrix() {}

    public CurriculumMatrix(String url) {
        if (url == null || url.isBlank()) {
            throw new IllegalArgumentException("A URL não pode ser nula ou em branco");
        }
        this.id = null;
        this.url = url;
    }

    @Override
    public Long getId() { return id; }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
