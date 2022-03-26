package com.comecu.todo.cli.file;

import com.comecu.todo.core.domain.TodoItem;
import com.comecu.todo.core.repository.TodoItemRepository;
import com.comecu.todo.util.Jsons;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

import java.io.File;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * FileTodoItemRepository
 *
 * @author comeCU
 * @date 2022/3/16 23:25
 */
public class FileTodoItemRepository implements TodoItemRepository {
    private final File file;

    public FileTodoItemRepository(final File file) {
        this.file = file;
    }

    @Override
    public TodoItem save(TodoItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Todo item should not be null");
        }

        final Iterable<TodoItem> items = findAll();
        final Iterable<TodoItem> newContents = toSaveContent(item, items);
        Jsons.writeObjects(this.file, newContents);
        return item;
    }

    @Override
    public Iterable<TodoItem> findAll() {
        if (this.file.length() == 0) {
            return ImmutableList.of();
        }

        return Jsons.toObjects(this.file);
    }

    private Iterable<TodoItem> toSaveContent(final TodoItem newItem, final Iterable<TodoItem> items) {
        if (newItem.getIndex() == 0) {
            long newIndex = Iterables.size(items) + 1;
            newItem.assignIndex(newIndex);

            return ImmutableList.<TodoItem>builder()
                    .addAll(items)
                    .add(newItem).build();
        }

        return StreamSupport.stream(items.spliterator(), false).map(item -> updateItem(newItem, item))
                .collect(Collectors.toList());
    }

    private TodoItem updateItem(TodoItem newItem, TodoItem item) {
        if (newItem.getIndex() == item.getIndex()) {
            return newItem;
        }

        return item;
    }

}
