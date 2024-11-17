package com.example.dddproject.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class Todo {
    private UUID id;
    private String description;
    private boolean completed;

    public Todo(String description) {
        this.id = UUID.randomUUID();
        this.description = description;
        this.completed = false;
    }

    public void complete() {
        this.completed = true;
    }

    public UUID getId() {
        return id;
    }
}
