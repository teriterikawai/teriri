package org.example.danet.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {

    CONFIRMED("Подтверждено"),
    REJECTED("Отклонено"),
    NEW("Новое");

    private final String name;

}
