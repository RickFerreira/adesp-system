package com.project.adesp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BaseController<T> {

    @GetMapping
    ResponseEntity<List<T>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<T> findById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<T> create(@RequestBody T entity);

    @PutMapping("/{id}")
    ResponseEntity<T> update(@PathVariable Long id, @RequestBody T entity);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id);

}
