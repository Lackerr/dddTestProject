package com.example.dddproject.domain.repository;

import com.example.dddproject.domain.model.Todo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoRepository {
    Optional<Todo> findById(UUID id);
    List<Todo> findAll();
    void save(Todo todo);
}
