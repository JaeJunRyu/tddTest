package com.example.apifirst.application.api;

import com.example.apifirst.application.dto.TodoRequest;
import com.example.apifirst.application.dto.TodoResponse;
import com.example.apifirst.application.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<List<TodoResponse>> getTodos(){
        List<TodoResponse> todoResponses = todoService.getTodos();
        return ResponseEntity.ok(todoResponses);
    }

    @PostMapping
    public ResponseEntity<TodoResponse> saveTodo(@RequestBody TodoRequest request) {
        TodoResponse todoResponse = todoService.saveTodo(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(todoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }


}
