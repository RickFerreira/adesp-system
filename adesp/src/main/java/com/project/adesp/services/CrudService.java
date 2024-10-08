package com.project.adesp.services;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {

    T create(T entity);
    Optional<T> findById(Long id);
    List<T> findAll();
    T update(T entity);
    void deleteById(Long id);

}
