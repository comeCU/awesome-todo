package com.comecu.todo.api;

import com.comecu.todo.core.domain.TodoItem;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

/**
 * TodoItemResponse
 *
 * @author comeCU
 * @date 2022/3/25 17:43
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@NoArgsConstructor
public class TodoItemResponse {
    @JsonProperty
    private long index;
    @JsonProperty
    private String content;
    @JsonProperty
    private boolean done;

    public TodoItemResponse(final TodoItem item) {
        this.index = item.getIndex();
        this.content = item.getContent();
        this.done = item.isDone();
    }
}
