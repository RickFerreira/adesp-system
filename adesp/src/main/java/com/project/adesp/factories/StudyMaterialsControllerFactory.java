package com.project.adesp.factories;

import com.project.adesp.controllers.BaseController;
import com.project.adesp.controllers.StudyMaterialsController;
import com.project.adesp.models.StudyMaterials;

public class StudyMaterialsControllerFactory implements ControllerFactory<StudyMaterials> {

    @Override
    public BaseController<StudyMaterials> createController() {
        return new StudyMaterialsController();
    }

}
