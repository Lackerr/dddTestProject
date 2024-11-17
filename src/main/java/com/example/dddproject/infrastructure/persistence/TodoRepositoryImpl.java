package com.example.dddproject.infrastructure.persistence;

import com.example.dddproject.domain.model.Todo;
import com.example.dddproject.domain.repository.TodoRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TodoRepositoryImpl  implements TodoRepository {
    private final Map<UUID, Todo> database = new HashMap<>();

    @Override
    public Optional<Todo> findById(UUID id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public void save(Todo todo) {
        database.put(todo.getId(), todo);
    }
}
