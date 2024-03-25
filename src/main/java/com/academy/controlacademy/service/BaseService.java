package com.academy.controlacademy.service;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public class BaseService<T> {
    private final JpaRepository<T, Long> repository;

    public BaseService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public T findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<T> index() {
        return repository.findAll();
    }

    public T create(T record) {
        return repository.save(record);
    }

    public T update(T record) {
        return repository.save(record);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
