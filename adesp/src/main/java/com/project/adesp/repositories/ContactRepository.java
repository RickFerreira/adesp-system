package com.project.adesp.repositories;

import com.project.adesp.models.Contact;
import com.project.adesp.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByProfessor(Professor professor);

}