package com.comecu.todo.util;

import com.comecu.todo.core.domain.TodoItem;
import com.comecu.todo.core.exception.TodoException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Jsons
 *
 * @author comeCU
 * @date 2022/3/16 23:54
 */
public final class Jsons {
    private static final TypeFactory FACTORY = TypeFactory.defaultInstance();
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private Jsons() {
    }

    public static Iterable<TodoItem> toObjects(final File file) {
        final CollectionType type = FACTORY.constructCollectionType(List.class, TodoItem.class);
        try {
            return MAPPER.readValue(file, type);
        } catch (IOException e) {
            throw new TodoException("Fail to read objects", e);
        }
    }

    public static void writeObjects(final File file, final Iterable<TodoItem> objects) {
        try {
            MAPPER.writeValue(file, objects);
        } catch (IOException e) {
            throw new TodoException("Fail to write objects", e);
        }
    }

}
