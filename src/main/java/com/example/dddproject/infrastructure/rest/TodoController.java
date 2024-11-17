package com.example.dddproject.infrastructure.rest;

import com.example.dddproject.application.service.TodoService;
import com.example.dddproject.domain.model.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return service.getAllTodos();
    }

    @PostMapping
    public Todo createTodo(@RequestBody String description) {
        return service.createTodo(description);
    }

    @PutMapping("/{id}/complete")
    public void completeTodoById(@PathVariable UUID id) {
        service.completeTodoById(id);
    }
}
