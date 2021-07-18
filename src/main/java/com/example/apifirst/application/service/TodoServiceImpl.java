package com.example.apifirst.application.service;

import com.example.apifirst.application.dto.TodoRequest;
import com.example.apifirst.application.dto.TodoResponse;
import com.example.apifirst.domain.Todo;
import com.example.apifirst.domain.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    @Override
    public List<TodoResponse> getTodos() {
        return todoRepository.findAll()
            .stream()
            .map(todo -> TodoResponse.of(todo.getId(), todo.getContent()))
            .collect(Collectors.toList());
    }

    @Override
    public TodoResponse saveTodo(TodoRequest request) {
        final Todo save = todoRepository.save(Todo.of(request.getContent()));
        return TodoResponse.of(save.getId(), save.getContent());
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
