package com.project.adesp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "periods")
public class Period implements Identification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer semester;

    @OneToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    private Period(){
    }

    private Period(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.semester = builder.semester;
        this.schedule = builder.schedule;
    }

    public static class Builder {
        private Long id;
        private String name;
        private Integer semester;
        private Schedule schedule;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSemester(Integer semester) {
            this.semester = semester;
            return this;
        }

        public Builder withSchedule(Schedule schedule) {
            this.schedule = schedule;
            return this;
        }

        public Period build() {
            return new Period(this);
    }
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

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

}
