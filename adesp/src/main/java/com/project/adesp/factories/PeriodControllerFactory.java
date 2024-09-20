package com.project.adesp.factories;

import com.project.adesp.controllers.BaseController;
import com.project.adesp.controllers.PeriodController;
import com.project.adesp.models.Period;

public class PeriodControllerFactory implements ControllerFactory<Period> {

    @Override
    public BaseController<Period> createController() {
        return new PeriodController();
    }

}
