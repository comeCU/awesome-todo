package com.comecu.todo.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * MarkAsDoneRequest
 *
 * @author comeCU
 * @date 2022/3/25 16:19
 */
public class MarkAsDoneRequest {
    @Getter
    private boolean done;

    @JsonCreator
    public MarkAsDoneRequest(@JsonProperty("done") final boolean done) {
        this.done = done;
    }
}
