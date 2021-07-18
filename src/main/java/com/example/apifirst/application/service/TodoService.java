package com.example.apifirst.application.service;

import com.example.apifirst.application.dto.TodoRequest;
import com.example.apifirst.application.dto.TodoResponse;

import java.util.List;

public interface TodoService {
    List<TodoResponse> getTodos();

    TodoResponse saveTodo(TodoRequest request);

    void deleteTodo(Long id);
}
