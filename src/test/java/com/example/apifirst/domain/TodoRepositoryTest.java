package com.example.apifirst.domain;

import com.example.apifirst.application.dto.TodoResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    void save_and_get_and_delete(){
        Todo todoToSave = Todo.of("할일");

        final Todo save = todoRepository.save(todoToSave);

        System.out.println("todoToSave " + todoToSave.getId());
        System.out.println("save " +save.getId());

        assertThat(save).isEqualTo(todoToSave);

        assertThat(todoRepository.existsById(save.getId())).isTrue();

        todoRepository.deleteById(save.getId());

        assertThat(todoRepository.existsById(save.getId())).isFalse();
    }
}
