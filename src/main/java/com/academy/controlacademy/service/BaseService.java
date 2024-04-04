package com.academy.controlacademy.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseService<T, D> {
  private final JpaRepository<T, Long> repository;

  public BaseService(JpaRepository<T, Long> repository) {
    this.repository = repository;
  }

  public ResponseEntity<T> create(D dto) {
    var entity = newEntityInstance();
    BeanUtils.copyProperties(dto, entity);
    return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(entity));
  }

  public ResponseEntity<T> findById(Long id) {
    Optional<T> record = repository.findById(id);
    return record
        .map(t -> ResponseEntity.status(HttpStatus.OK).body(t))
        .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
  }

  public ResponseEntity<List<T>> index() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(repository.findAll(Sort.by(Sort.Direction.ASC, "id")));
  }

  public ResponseEntity<T> update(D dto, Long id) {
    var originalEntity = repository.findById(id);
    if (originalEntity.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    var entity = originalEntity.get();
    BeanUtils.copyProperties(dto, entity);
    return ResponseEntity.status(HttpStatus.OK).body(repository.save(entity));
  }

  public ResponseEntity<Object> delete(Long id) {
    Optional<T> record = repository.findById(id);
    if (record.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    repository.delete(record.get());
    return ResponseEntity.status(HttpStatus.OK).body("Record deleted successfully");
  }

  protected abstract T newEntityInstance();
}
