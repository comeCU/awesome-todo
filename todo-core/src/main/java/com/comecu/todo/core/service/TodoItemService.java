package com.comecu.todo.core.service;

import com.comecu.todo.core.domain.TodoItem;
import com.comecu.todo.core.param.TodoIndexParameter;
import com.comecu.todo.core.param.TodoParameter;
import com.comecu.todo.core.repository.TodoItemRepository;
import com.google.common.collect.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * TodoItemService
 *
 * @author comeCU
 * @date 2022/3/14 16:34
 */
@Service
public class TodoItemService {
    private final TodoItemRepository todoItemRepository;
    @Autowired
    public TodoItemService(final TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public TodoItem addTodoItem(final TodoParameter todoParameter) {
        if (todoParameter == null) {
            throw new IllegalArgumentException("Null or empty content is not allowed");
        }
        final TodoItem item = new TodoItem(todoParameter.getContent());
        return this.todoItemRepository.save(item);
    }

    public Optional<TodoItem> markTodoItemDone(final TodoIndexParameter index) {

        final Iterable<TodoItem> all = this.todoItemRepository.findAll();

        final Optional<TodoItem> optionalItem = StreamSupport.stream(all.spliterator(), false)
                .filter(element -> element.getIndex() == index.getIndex())
                .findFirst();

        return optionalItem.flatMap(this::doMarkAsDone);
    }

    private Optional<TodoItem> doMarkAsDone(final TodoItem todoItem) {
        todoItem.markDone();
        return Optional.of(this.todoItemRepository.save(todoItem));
    }

    public List<TodoItem> list(final boolean all) {
        return Streams.stream(this.todoItemRepository.findAll())
                .filter(item -> all || !item.isDone())
                .collect(Collectors.toList());
    }

}
