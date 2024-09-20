package com.project.adesp.factories;

import com.project.adesp.controllers.BaseController;
import com.project.adesp.controllers.ProfessorController;
import com.project.adesp.models.Professor;

public class ProfessorControllerFactory implements ControllerFactory<Professor> {

    @Override
    public BaseController<Professor> createController() {
        return new ProfessorController();
    }

}
