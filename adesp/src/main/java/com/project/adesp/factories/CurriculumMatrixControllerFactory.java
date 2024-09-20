package com.project.adesp.factories;

import com.project.adesp.controllers.BaseController;
import com.project.adesp.controllers.CurriculumMatrixController;
import com.project.adesp.models.CurriculumMatrix;


public class CurriculumMatrixControllerFactory implements ControllerFactory<CurriculumMatrix> {

    @Override
    public BaseController<CurriculumMatrix> createController() {
        return new CurriculumMatrixController();
    }

}
