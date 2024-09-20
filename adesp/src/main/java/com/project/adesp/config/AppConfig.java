package com.project.adesp.config;

import com.project.adesp.factories.*;
import com.project.adesp.models.*;
import com.project.adesp.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ControllerFactory<Contact> contactControllerFactory() {
        return new ContactControllerFactory();
    }

    @Bean
    public ControllerFactory<CurriculumMatrix> curriculumMatrixControllerFactory(CurriculumMatrixService curriculumMatrixService) {
        return new CurriculumMatrixControllerFactory();
    }

    @Bean
    public ControllerFactory<Period> periodControllerFactory(PeriodService periodService) {
        return new PeriodControllerFactory();
    }

    @Bean
    public ControllerFactory<Professor> professorControllerFactory(ProfessorService professorService) {
        return new ProfessorControllerFactory();
    }

    @Bean
    public ControllerFactory<Schedule> scheduleControllerFactory(ScheduleService scheduleService) {
        return new ScheduleControllerFactory();
    }

    @Bean
    public ControllerFactory<StudyMaterials> studyMaterialsControllerFactory(StudyMaterialsService studyMaterialsService) {
        return new StudyMaterialsControllerFactory();
    }

    @Bean
    public ControllerFactory<Subject> subjectControllerFactory(SubjectService subjectService) {
        return new SubjectControllerFactory();
    }
}
