package com.comecu.todo.core.repository;

import com.comecu.todo.core.domain.TodoItem;
import org.springframework.data.repository.Repository;

public interface TodoItemRepository extends Repository<TodoItem, Long> {

    TodoItem save(TodoItem item);

    Iterable<TodoItem> findAll();
}
