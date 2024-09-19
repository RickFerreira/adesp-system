package com.project.adesp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "schedules")
public class Schedule implements Identification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String urlSchedule;

    @OneToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToOne
    @JoinColumn(name = "period_id")
    private Period period;

    public Schedule() {
    }

    public Schedule(String urlSchedule, Professor professor, Period period) {
        this.urlSchedule = urlSchedule;
        this.professor = professor;
        this.period = period;
    }

    @Override
    public Long getId() { return id; }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlSchedule() {
        return urlSchedule;
    }

    public void setUrlSchedule(String urlSchedule) {
        this.urlSchedule = urlSchedule;
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

}
