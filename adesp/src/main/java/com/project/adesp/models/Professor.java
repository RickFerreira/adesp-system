package com.project.adesp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "professors")
public class Professor implements Identification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @OneToOne(mappedBy = "professor")
    private Schedule schedule;

    public Professor() {
    }

    public Professor(String name, String email, Schedule schedule) {
        this.name = name;
        this.schedule = schedule;
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

}
