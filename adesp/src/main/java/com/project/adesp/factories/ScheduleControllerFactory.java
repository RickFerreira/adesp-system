package com.project.adesp.factories;

import com.project.adesp.controllers.BaseController;
import com.project.adesp.controllers.ScheduleController;
import com.project.adesp.models.Schedule;

public class ScheduleControllerFactory implements ControllerFactory<Schedule> {

    @Override
    public BaseController<Schedule> createController() {
        return new ScheduleController();
    }
}
