package com.comecu.todo.core.param;

import lombok.Getter;

/**
 * TodoIndexParameter
 *
 * @author comeCU
 * @date 2022/3/14 23:29
 */
public final class TodoIndexParameter {
    @Getter
    private final int index;

    public TodoIndexParameter(final int index) {
        this.index = index;
    }

    public static TodoIndexParameter of(final int index) {
        if (index <= 0) {
            throw new IllegalArgumentException("Todo index should be greater than 0");
        }

        return new TodoIndexParameter(index);
    }
}
