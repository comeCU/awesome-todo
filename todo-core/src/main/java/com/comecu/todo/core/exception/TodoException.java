package com.comecu.todo.core.exception;

/**
 * TodoException
 *
 * @author comeCU
 * @date 2022/3/17 0:05
 */
public class TodoException extends RuntimeException{
    public TodoException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
