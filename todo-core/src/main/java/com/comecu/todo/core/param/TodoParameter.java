package com.comecu.todo.core.param;

import com.google.common.base.Strings;
import lombok.Getter;

/**
 * TodoParameter
 *
 * @author comeCU
 * @date 2022/3/14 17:14
 */
public final class TodoParameter {
    @Getter
    private final String content;

    public TodoParameter(final String content) {
        this.content = content;
    }

    public static TodoParameter of(final String content) {
        if (Strings.isNullOrEmpty(content)) {
            throw new IllegalArgumentException("Empty content is not allowed");
        }
        return new TodoParameter(content);
    }
}
