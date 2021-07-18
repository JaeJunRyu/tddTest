package com.example.apifirst.application.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor(staticName = "of")
public class TodoResponse {
    private final Long id;
    private final String content;
}
