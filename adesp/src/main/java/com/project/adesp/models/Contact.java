package com.project.adesp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact implements Identification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    public Contact() {}

    public Contact(String type, String value, Professor professor) {
        this.id = null;
        this.type = type;
        this.value = value;
        this.professor = professor;
    }

    @Override
    public Long getId() { return id; }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

}
