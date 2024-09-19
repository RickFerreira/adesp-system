package com.project.adesp.services;

import com.project.adesp.models.Contact;
import com.project.adesp.models.Professor;
import com.project.adesp.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService implements CrudService<Contact> {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact create(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Optional<Contact> findById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public List<Contact> findAll() {

        return contactRepository.findAll();
    }

    public List<Contact> findContactsByProfessor(Professor professor) {
        return contactRepository.findByProfessor(professor);
    }

    @Override
    public Contact update(Contact contact) {

        return contactRepository.save(contact);
    }

    @Override
    public void deleteById(Long id) {

        contactRepository.deleteById(id);
    }

}
