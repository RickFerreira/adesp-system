package com.project.adesp.factories;

import com.project.adesp.controllers.BaseController;
import com.project.adesp.controllers.SubjectController;
import com.project.adesp.models.Subject;

public class SubjectControllerFactory implements ControllerFactory<Subject> {

    @Override
    public BaseController<Subject> createController() {
        return new SubjectController();
    }

}
