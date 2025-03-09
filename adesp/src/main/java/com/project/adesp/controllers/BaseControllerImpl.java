package com.project.adesp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class BaseControllerImpl implements BaseController<Object> {

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello, world!");
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Object>> findAll() {
        // Exemplo: você pode retornar uma lista de objetos (aqui fica como um exemplo genérico)
        return ResponseEntity.ok(List.of());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        // Exemplo: retornando um objeto genérico
        return ResponseEntity.ok(new Object());
    }

    @Override
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Object entity) {
        // Lógica de criação do objeto
        return ResponseEntity.status(201).body(entity);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Object entity) {
        // Lógica de atualização do objeto
        return ResponseEntity.ok(entity);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        // Lógica de exclusão do objeto
        return ResponseEntity.noContent().build();
    }
}
