package com.comecu.todo.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * AddTodoItemRequest
 *
 * @author comeCU
 * @date 2022/3/23 23:12
 */
public class AddTodoItemRequest {
    @Getter
    private String content;

    @JsonCreator
    public AddTodoItemRequest(@JsonProperty("content") final String content) {
        this.content = content;
    }
}
