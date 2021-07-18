package com.example.apifirst.application.service;

import com.example.apifirst.application.dto.TodoRequest;
import com.example.apifirst.application.dto.TodoResponse;
import com.example.apifirst.domain.Todo;
import com.example.apifirst.domain.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TodoServiceImplTest {

//    private TodoService todoService;
//
//    private TodoRepository todoRepository;
//
//    @BeforeEach
//    public void setUp(){
//        todoRepository = mock(TodoRepository.class);
//        todoService = new TodoServiceImpl(todoRepository);
//    }

    @InjectMocks
    private TodoServiceImpl todoServiceImpl;

    @Mock
    private TodoRepository todoRepository;

    @Test
    void getTodos(){
        List<Todo> todos = List.of(Todo.of(1L, "할일 내용"));

        when(todoRepository.findAll()).thenReturn(todos);

        final List<TodoResponse> todoResponses = todoServiceImpl.getTodos();

        assertThat(todoResponses).hasSize(todos.size());

        verify(todoRepository).findAll();
    }

    @Test
    void saveTodo(){
        TodoRequest request = TodoRequest.of("할일");
        final Todo todo = Todo.of(request.getContent());
        when(todoRepository.save(todo))
            .thenReturn(Todo.of(1L, request.getContent()));

        final TodoResponse todoResponse = todoServiceImpl.saveTodo(request);

        assertThat(todoResponse).isNotNull();

        verify(todoRepository).save(todo);
    }

    @Test
    void deleteTodo(){
        Long id = 1L;
        todoServiceImpl.deleteTodo(id);

        verify(todoRepository).deleteById(id);
    }

}
