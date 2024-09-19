package com.project.adesp.controllers;

import com.project.adesp.models.Contact;
import com.project.adesp.models.Professor;
import com.project.adesp.services.ContactService;
import com.project.adesp.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactController implements BaseController<Contact> {

    @Autowired
    private ContactService contactService;

    @Autowired
    private ProfessorService professorService;

    @Override
    public ResponseEntity<List<Contact>> findAll() {
        return new ResponseEntity<>(contactService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Contact> findById(@PathVariable Long id) {
        return contactService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Contact> create(@RequestBody Contact contact) {
        Contact savedContact = contactService.create(contact);
        return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Contact> update(@PathVariable Long id, @RequestBody Contact contact) {
        contact.setId(id);
        Contact updatedContact = contactService.update(contact);
        return new ResponseEntity<>(updatedContact, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        contactService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/professor/{professorId}")
    public ResponseEntity<List<Contact>> findContactsByProfessor(@PathVariable Long professorId) {
        Professor professor = professorService.findById(professorId).get();
        List<Contact> contacts = contactService.findContactsByProfessor(professor);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }
}