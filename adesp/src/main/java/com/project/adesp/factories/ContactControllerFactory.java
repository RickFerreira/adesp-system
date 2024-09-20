package com.project.adesp.factories;

import com.project.adesp.controllers.BaseController;
import com.project.adesp.controllers.ContactController;
import com.project.adesp.models.Contact;

public class ContactControllerFactory implements ControllerFactory<Contact> {

    @Override
    public BaseController<Contact> createController() {
        return new ContactController();
    }

}