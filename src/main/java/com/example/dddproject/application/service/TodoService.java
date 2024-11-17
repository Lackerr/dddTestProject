package com.example.dddproject.application.service;

import com.example.dddproject.domain.model.Todo;
import com.example.dddproject.domain.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository todoRepository) {
        this.repository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return repository.findAll()
                .stream()
                .sorted(Comparator.comparing(todo -> todo.getDescription().toLowerCase()))
                .collect(Collectors.toList());
    }

    public Todo createTodo(String description){
        Todo todo = new Todo(description);
        repository.save(todo);
        return todo;
    }

    public void completeTodoById(UUID id){
        repository.findById(id).ifPresent(Todo::complete);
    }
}
