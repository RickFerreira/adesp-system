package com.project.adesp.factories;

import com.project.adesp.controllers.BaseController;

public interface ControllerFactory<T> {

    BaseController<T> createController();

}
