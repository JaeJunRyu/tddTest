package com.example.apifirst.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EqualsAndHashCode.Exclude
    private String content;

    public Todo(String content) {
        this.content = content;
    }

    public Todo(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public static Todo of(String content) {
        return new Todo(content);
    }
    public static Todo of(Long id, String content) {
        return new Todo(id, content);
    }

}
